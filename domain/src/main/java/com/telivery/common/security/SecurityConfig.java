package com.telivery.common.security;

import com.telivery.common.security.jwt.JwtAccessDeniedHandler;
import com.telivery.common.security.jwt.JwtAuthenticationEntryPoint;
import com.telivery.common.security.jwt.JwtFilter;
import com.telivery.common.security.jwt.JwtProvider;
import com.telivery.common.security.jwt.JwtUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final JwtProvider jwtTokenProvider;
  private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
  private final JwtUserDetailService jwtUserDetailService;
  private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
  private final CorsConfig corsConfig;

  @Override
  public void configure(WebSecurity web) { }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .addFilter(corsConfig.corsFilter())
        .csrf().disable()
        .authorizeRequests()
        .antMatchers(HttpMethod.OPTIONS, "/api/**").permitAll() //OPTIONS 메소드 허락
        .antMatchers("/api/auth/**").permitAll()
        // DESCRIBE: 사용자 권한 설정
        .anyRequest().authenticated()
        .and()
        // DESCRIBE: JWT를 대신 사용하므로, 세션 Stateless로 설정
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .addFilterBefore(new JwtFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)
        .exceptionHandling()
        .authenticationEntryPoint(jwtAuthenticationEntryPoint)
        .accessDeniedPage("/api/login")
        .accessDeniedHandler(jwtAccessDeniedHandler)
        .and()
        .apply(new JwtFilterConfig(jwtTokenProvider));

  }

  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

}
