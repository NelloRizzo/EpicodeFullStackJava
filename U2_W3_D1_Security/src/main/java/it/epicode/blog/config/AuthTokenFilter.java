package it.epicode.blog.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import it.epicode.blog.businesslayer.services.security.ApplicationUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthTokenFilter extends OncePerRequestFilter {

	@Autowired
	JwtUtils jwt;

	@Autowired
	ApplicationUserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, //
			HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		try {
			log.info("Processing AuthTokenFilter");
			// legge lo header
			// Authorization: Bearer TOKEN
			var header = request.getHeader("Authorization");
			if (header != null && header.startsWith("Bearer")) { 
				var token = header.substring(7);
				log.info("Token: {}", token);
				var username = jwt.getUsernameFromToken(token);
				log.info("Username: {}", username);
				var details = userDetailsService.loadUserByUsername(username);
				log.info("Details: {}", details);

				// a questo punto l'utente è stato completamente individuato
				// lo devo solo SCRIVERE NEL CONTESTO DI SICUREZZA
				var auth = new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
				auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				// INTEGRO IL MIO SISTEMA DI AUTENTICAZIONE NEL CONTESTO SPRING
				SecurityContextHolder.getContext().setAuthentication(auth);
			}

		} catch (Exception e) {
			log.error("Exception in auth filter", e);
		}
		filterChain.doFilter(request, response);
	}

}
