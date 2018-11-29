package com.example.dataindexer.frontend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //@formatter:off
        http
                .csrf().disable()
                    .formLogin().loginPage("/login").permitAll()
                    .failureUrl("/login?error").permitAll()
                .and()
                    .logout().logoutSuccessUrl("/login").permitAll()
                .and()
                    .authorizeRequests()
                        .requestMatchers(new VaadinInternalRequestMatcher()).permitAll()
                        .anyRequest().authenticated();
        //@formatter:on
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().mvcMatchers("/VAADIN/**", "/favicon.ico", "/manifest.json",
                "/icons/**", "/images/**", "/frontend/**", "/webjars/**", "/frontend-es5/**", "/frontend-es6/**");
    }
}
