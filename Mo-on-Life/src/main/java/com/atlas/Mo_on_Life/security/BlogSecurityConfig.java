package com.atlas.Mo_on_Life.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.net.http.HttpClient;

@Configuration
@EnableWebSecurity
public class BlogSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails admin = User.withUsername("muhammet")
                .password(passwordEncoder().encode("enes123"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
            http.authorizeHttpRequests(authorize -> authorize
                    .requestMatchers("/new").hasRole("ADMIN")
                    .anyRequest().permitAll())
                    .formLogin(form -> form
                            .defaultSuccessUrl("/new", true)
                            .permitAll())
                    .exceptionHandling(exception -> exception
                            .accessDeniedPage("/access-denied"));

            return http.build();



    }


}
