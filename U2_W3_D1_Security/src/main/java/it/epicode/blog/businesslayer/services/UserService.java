package it.epicode.blog.businesslayer.services;

import java.util.Optional;

import it.epicode.blog.businesslayer.services.dto.RegisterUserDto;
import it.epicode.blog.businesslayer.services.dto.RegisteredUserDto;

public interface UserService {
	Optional<RegisteredUserDto> register(RegisterUserDto user);
}
