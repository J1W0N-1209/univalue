package kr.co.univalue.global.config;

import kr.co.univalue.global.security.jwt.JwtTokenFilter;
import kr.co.univalue.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@RequiredArgsConstructor
@Configuration
public class SecurityConfig {
    private final JwtTokenProvider jwtProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .httpBasic().disable()
                .formLogin().disable()
                .logout().disable();

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(new JwtTokenFilter(jwtProvider),
                UsernamePasswordAuthenticationFilter.class);

        http.cors().and()
                .authorizeRequests()
                .requestMatchers("/user").authenticated()
//                .requestMatchers("/api/files/**").authenticated()

                .anyRequest().permitAll();

        http.exceptionHandling().authenticationEntryPoint(
                new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));

        http
            .apply(new FilterConfig(jwtProvider));

        return http.build();
    }
}