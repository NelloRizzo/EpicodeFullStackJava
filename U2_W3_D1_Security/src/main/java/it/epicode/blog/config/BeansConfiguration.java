package it.epicode.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import it.epicode.blog.businesslayer.services.Mapper;
import it.epicode.blog.businesslayer.services.dto.LoginResponseDto;
import it.epicode.blog.businesslayer.services.dto.RegisterUserDto;
import it.epicode.blog.businesslayer.services.dto.RegisteredUserDto;
import it.epicode.blog.datalayer.entities.UserEntity;

@Configuration
public class BeansConfiguration {
	@Bean
	@Scope("singleton")
	Mapper<RegisterUserDto, UserEntity> mapRegisterUser2UserEntity() {
		return (input) -> UserEntity.builder() //
				.withFriendlyName(input.getFriendlyName()) //
				.withPassword(input.getPassword()) //
				.withUsername(input.getUsername()) //
				.build();
	}

	@Bean
	@Scope("singleton")
	Mapper<UserEntity, RegisteredUserDto> mapUserEntity2RegisteredUser() {
		return (input) -> RegisteredUserDto.builder() //
				.withFriendlyName(input.getFriendlyName()) //
				.withId(input.getId()) //
				.withUsername(input.getUsername()) //
				.withRoles(input.getRoles().stream().map(r -> r.getName()).toList()) //
				.build();
	}
	
	@Bean
	@Scope("singleton")
	Mapper<UserEntity, LoginResponseDto> mapUserEntity2LoginResponse() {
		return (input) -> LoginResponseDto.builder() //
				.withFriendlyName(input.getFriendlyName()) //
				.withId(input.getId()) //
				.withUsername(input.getUsername()) //
				.withRoles(input.getRoles().stream().map(r -> r.getName()).toList()) //
				.build();
	}
}
