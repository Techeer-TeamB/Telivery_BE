package com.telivery.common.security.jwt;

import com.telivery.persistence.user.dao.UserRepository;
import com.telivery.persistence.user.entity.User;
import com.telivery.persistence.user.entity.UserAdapter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Slf4j
@Component
@RequiredArgsConstructor
@PropertySource("classpath:/application-jwt.properties")
public class JwtProvider {

  private final UserRepository userRepository;

  @Value("${security.jwt.token.secret-key}")
  private String secretKey;

  @Value("${security.jwt.token.expire.length}")
  private long validityInMilliseconds;

  @PostConstruct
  protected void init() {
    secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
  }

  private static final String AUTHORITIES_KEY = "auth";
  private static final String AUTHORIZATION_HEADER = "Authorization";

  public String generateAccessToken(Authentication authentication) {
    String authorities = authentication.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority)
        .collect(Collectors.joining(","));

    return Jwts.builder()
        .setSubject(authentication.getName())
        .claim(AUTHORITIES_KEY, authorities)
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + validityInMilliseconds))
        .signWith(SignatureAlgorithm.HS512, secretKey)
        .compact();
  }

  public Authentication getAuthentication(String token) {
    Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    Collection<? extends GrantedAuthority> authorities =
        Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());
    String username = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Account [" + username + "] not found exception"));
    return new UsernamePasswordAuthenticationToken(UserAdapter.makeAdaptor(user), token, authorities);
  }

  public boolean validateToken(String token) {
    try {
      getAllClaimsFromToken(token);
    }
    catch (IllegalArgumentException e) {
      log.info("잘못된 인수입니다.");
      return false;
    } catch(SignatureException e){
      log.info("시그니처 검증에 실패한 토큰입니다.");
      return false;
    } catch (UnsupportedJwtException e) {
      log.info("지원하지 않는 JWT 토큰입니다.");
      return false;
    } catch (MalformedJwtException e) {
      log.info("손상된 JWT 토큰입니다.");
      return false;
    } catch (SecurityException e) {
      log.info("잘못된 JWT 서명입니다.");
      return false;
    }
    return true;
  }

  public boolean isTokenExpired(String token) {
    final Date expiration = getClaimFromToken(token, Claims::getExpiration);
    return expiration.before(new Date());
  }

  public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = getAllClaimsFromToken(token);
    return claimsResolver.apply(claims);
  }

  private Claims getAllClaimsFromToken(String token) {
    try {
      return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    } catch (ExpiredJwtException e) {
      return e.getClaims();
    }
  }

  public String resolveToken(HttpServletRequest req) {
    String bearerToken = req.getHeader(AUTHORIZATION_HEADER);
    if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
      return bearerToken.substring(7);
    }
    return null;
  }

}
