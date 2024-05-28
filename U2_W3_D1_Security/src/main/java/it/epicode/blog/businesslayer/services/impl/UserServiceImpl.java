package it.epicode.blog.businesslayer.services.impl;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import it.epicode.blog.businesslayer.services.Mapper;
import it.epicode.blog.businesslayer.services.UserService;
import it.epicode.blog.businesslayer.services.dto.RegisterUserDto;
import it.epicode.blog.businesslayer.services.dto.RegisteredUserDto;
import it.epicode.blog.businesslayer.services.exceptions.InvalidLoginException;
import it.epicode.blog.businesslayer.services.exceptions.PersistEntityException;
import it.epicode.blog.config.JwtUtils;
import it.epicode.blog.datalayer.entities.RoleEntity;
import it.epicode.blog.datalayer.entities.UserEntity;
import it.epicode.blog.datalayer.repositories.RolesRepository;
import it.epicode.blog.datalayer.repositories.UsersRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	UsersRepository users;
	@Autowired
	private RolesRepository roles;

	@Autowired
	private AuthenticationManager auth;

	@Autowired
	private JwtUtils jwt;

	@Autowired
	Mapper<RegisterUserDto, UserEntity> toEntity;
	@Autowired
	Mapper<UserEntity, RegisteredUserDto> toDto;

	@Override
	public RegisteredUserDto register(RegisterUserDto user) {
		try {
			var u = toEntity.map(user);
			var p = encoder.encode(user.getPassword());
			log.info("Password encrypted: {}", p);
			u.setPassword(p);
			if (user.getRoles() != null)
				Stream.of(user.getRoles().split(",")).forEach(r -> u.getRoles().add(roles.findOneByName(r) //
						.orElse(roles.save(RoleEntity.builder().withName(r).build()))));
			return toDto.map(users.save(u));
		} catch (Exception e) {
			log.error(String.format("Exception saving user %s", user), e);
			throw new PersistEntityException(user);
		}
	}

	@Override
	public Optional<RegisteredUserDto> login(String username, String password) {
		try {
			var a = auth.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			a.getAuthorities();
			SecurityContextHolder.getContext().setAuthentication(a);

			var dto = toDto.map(users.findOneByUsername(username).orElseThrow());
			dto.setToken(jwt.generateToken(a));
			return Optional.of(dto);
		} catch (NoSuchElementException e) {
			log.error("User not found", e);
			throw new InvalidLoginException(username, password);
		} catch (AuthenticationException e) {
			log.error("Authentication failed", e);
			throw new InvalidLoginException(username, password);
		}
	}

	@Override
	public Optional<RegisteredUserDto> get(long id) {
		try {
			return Optional.of(toDto.map(users.findById(id).orElseThrow()));
		} catch (Exception e) {
			log.error(String.format("User not found for id %s", id), e);
			return Optional.empty();
		}
	}

}
