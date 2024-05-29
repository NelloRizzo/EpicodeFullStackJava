package it.epicode.blog.businesslayer.services.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import it.epicode.blog.datalayer.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

// Utente per la gestione utenti in Spring Security
@Data
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class SecurityUserDetails implements UserDetails {
	private static final long serialVersionUID = 1L;

	// l'elenco dei ruoli dell'utente
	private Collection<? extends GrantedAuthority> authorities;
	private String password;
	private String username;
	@Builder.Default
	private boolean accountNonExpired = true;
	@Builder.Default
	private boolean accountNonLocked = true;
	@Builder.Default
	private boolean credentialsNonExpired = true;
	@Builder.Default
	private boolean enabled = true;

	public static SecurityUserDetails build(UserEntity user) {
		var authorities = user.getRoles().stream() //
				.map(r -> new SimpleGrantedAuthority(r.getName())).toList();
		return SecurityUserDetails.builder() //
				.withUsername(user.getUsername()) //
				.withPassword(user.getPassword()) //
				.withAuthorities(authorities) //
				.build();
	}
}
