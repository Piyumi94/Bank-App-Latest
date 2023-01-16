package com.ebanking.cloudgateway.configuration.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfigCloud {
	
	private static final String[] PUBLIC_MATCHERS = { "/webjars/**", "/css/**", "/js/**", "/images/**", "/",
			"/about/**", "/contact/**", "/error/**/*", "/console/**", "/signup" };

    @Bean
    public SecurityFilterChain springSecurityFilterChain(HttpSecurity http) throws Exception
    {
		http.authorizeHttpRequests().requestMatchers(PUBLIC_MATCHERS).permitAll().anyRequest().authenticated();
		http.httpBasic().disable();
		return http.build();
    }
}