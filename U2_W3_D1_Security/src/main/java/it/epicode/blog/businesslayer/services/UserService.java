package it.epicode.blog.businesslayer.services;

import java.util.Optional;

import it.epicode.blog.businesslayer.services.dto.LoginResponseDto;
import it.epicode.blog.businesslayer.services.dto.RegisterUserDto;
import it.epicode.blog.businesslayer.services.dto.RegisteredUserDto;

public interface UserService {
	RegisteredUserDto register(RegisterUserDto user);

	Optional<LoginResponseDto> login(String username, String password);

	Optional<RegisteredUserDto> get(long id);
}
