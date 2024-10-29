package com.secuirity.demo.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class springconfig {
@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		UserDetails normalUser=User.withUsername("mayur").password(passwordEncoder().encode("password"))
				.roles("public").build();
		
		
		UserDetails adminUser=User.withUsername("mayur1").password(passwordEncoder().encode("password"))
				.roles("admin").build();
		
		
		return new InMemoryUserDetailsManager(normalUser,adminUser);
		
		
		
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.csrf().disable()
		.authorizeHttpRequests().requestMatchers("/home/public")
		.permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin();
		return httpSecurity.build();
		
		
		
		
	}
	
}
