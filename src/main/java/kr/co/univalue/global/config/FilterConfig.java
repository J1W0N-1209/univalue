package kr.co.univalue.global.config;

import kr.co.univalue.global.config.error.GlobalExceptionFilter;
import kr.co.univalue.global.security.jwt.JwtTokenFilter;
import kr.co.univalue.global.security.jwt.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@AllArgsConstructor
public class FilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void configure(HttpSecurity builder) {
        JwtTokenFilter jwtTokenFilter = new JwtTokenFilter(jwtTokenProvider);
        GlobalExceptionFilter globalExceptionFilter = new GlobalExceptionFilter();
        builder.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
        builder.addFilterBefore(globalExceptionFilter, JwtTokenFilter.class);
    }
}
