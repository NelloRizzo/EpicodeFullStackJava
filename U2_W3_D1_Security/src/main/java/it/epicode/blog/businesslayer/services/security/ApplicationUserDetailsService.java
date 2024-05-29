package it.epicode.blog.businesslayer.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.epicode.blog.datalayer.repositories.UsersRepository;

// Servizio di recupero di un utente tramite le procedure di gestione utente di Spring Security
@Service
public class ApplicationUserDetailsService implements UserDetailsService {

	@Autowired
	UsersRepository users;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var user = users.findOneByUsername(username).orElseThrow();
		var applicationUser = SecurityUserDetails.build(user);
		return applicationUser;
	}

}
