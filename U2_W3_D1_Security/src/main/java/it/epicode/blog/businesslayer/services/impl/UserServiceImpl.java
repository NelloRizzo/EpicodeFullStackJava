package it.epicode.blog.businesslayer.services.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.blog.businesslayer.services.Mapper;
import it.epicode.blog.businesslayer.services.UserService;
import it.epicode.blog.businesslayer.services.dto.RegisterUserDto;
import it.epicode.blog.businesslayer.services.dto.RegisteredUserDto;
import it.epicode.blog.businesslayer.services.exceptions.InvalidLoginException;
import it.epicode.blog.businesslayer.services.exceptions.PersistEntityException;
import it.epicode.blog.datalayer.entities.UserEntity;
import it.epicode.blog.datalayer.repositories.UsersRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	UsersRepository users;

	@Autowired
	Mapper<RegisterUserDto, UserEntity> dto2Entity;

	@Override
	public Optional<RegisteredUserDto> register(RegisterUserDto user) {
		try {
			var u = users.save(dto2Entity.convertFrom(user));
			return Optional.of(RegisteredUserDto.builder() //
					.withFriendlyName(u.getFriendlyName()).withId(u.getId()) //
					.withUsername(u.getUsername()).build());
		} catch (Exception e) {
			log.error(String.format("Exception saving user %s", user), e);
			throw new PersistEntityException(user);
		}
	}

	@Override
	public Optional<RegisteredUserDto> login(String username, String password) {
		try {
			var u = users.findOneByUsernameAndPassword(username, password).orElseThrow();
			return Optional.of(RegisteredUserDto.builder() //
					.withFriendlyName(u.getFriendlyName()).withId(u.getId()) //
					.withUsername(u.getUsername()).build());
		} catch (NoSuchElementException e) {
			log.error("User not found", e);
			throw new InvalidLoginException(username, password);
		}
	}

}
