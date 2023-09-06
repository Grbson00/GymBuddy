package com.g.GymBuddyBE.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
//    private final RequestMatcher MATCHER = new OrRequestMatcher(
//            new AntPathRequestMatcher("/api/test")
//    );
    private final RequestMatcher MATCHER = new AntPathRequestMatcher("/**");

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        security.authorizeHttpRequests((request) -> request.requestMatchers(MATCHER).permitAll()
                .anyRequest().authenticated()
        );

        return security.build();
    }
}
