package it.epicode.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ApplicationSecurityConfig {

	@Bean
	PasswordEncoder stdPasswordEncoder() {
		return new BCryptPasswordEncoder(11);
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

//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration config = new CorsConfiguration();
//		config.setAllowedOrigins(List.of("http://localhost:80"));
//		config.setAllowedMethods(List.of("GET", "POST"));
//		UrlBasedCorsConfigurationSource src = new UrlBasedCorsConfigurationSource();
//		src.registerCorsConfiguration("/**", config);
//		return (CorsConfigurationSource) src;
//	}

	@Bean
	SecurityFilterChain web(HttpSecurity http) throws Exception {
		http //
				//.cors(c -> corsConfigurationSource())
				.csrf(c -> c.disable()) //
				.authorizeHttpRequests(authorize -> //
				authorize //
						.requestMatchers(HttpMethod.POST).permitAll() //
						.anyRequest().authenticated()) //
				.httpBasic(Customizer.withDefaults()) //
				.sessionManagement(sm -> //
				sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		;

		return http.build();
	}

}
