package com.telivery.common.security;

import com.telivery.common.security.jwt.JwtFilter;
import com.telivery.common.security.jwt.JwtProvider;
import com.telivery.common.security.jwt.JwtUserDetailService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@AllArgsConstructor
public class JwtFilterConfig extends
    SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

  private final JwtProvider jwtProvider;

  @Override
  public void configure(HttpSecurity http) {
    JwtFilter jwtCustomFilter = new JwtFilter(jwtProvider);
    http.addFilterBefore(jwtCustomFilter, UsernamePasswordAuthenticationFilter.class);
  }

}
