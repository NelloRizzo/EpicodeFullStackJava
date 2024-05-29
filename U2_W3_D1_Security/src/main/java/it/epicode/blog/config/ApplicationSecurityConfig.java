package it.epicode.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig {

	@Bean
	PasswordEncoder stdPasswordEncoder() {
		return new BCryptPasswordEncoder(11);
	}

	@Bean
	AuthTokenFilter authenticationJwtToken() {
		return new AuthTokenFilter();
	}

	@SuppressWarnings("removal")
	@Bean
	AuthenticationManager authenticationManager(HttpSecurity http, //
			PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class) //
				.userDetailsService(userDetailsService) //
				.passwordEncoder(passwordEncoder) //
				.and().build();
	}

	@Bean
	SecurityFilterChain web(HttpSecurity http) throws Exception {
		http //
				.csrf(c -> c.disable())//
				.authorizeHttpRequests(authorize -> //
				authorize //
						// abilita l'accesso anonimo all'api di login
						.requestMatchers("/api/users/login").permitAll() //
						// solo per consentire la registrazione di un utente
						.requestMatchers(HttpMethod.POST, "/api/users").permitAll()
						// tutte le altre richieste sono accessibili ad utenti autenticati
						.requestMatchers("/**").authenticated() //
				) //
				.httpBasic(Customizer.withDefaults()) //
				.sessionManagement( //
						// gestione della sessione di tipo stateless
						sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))//
				.addFilterBefore(authenticationJwtToken(), UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

}
