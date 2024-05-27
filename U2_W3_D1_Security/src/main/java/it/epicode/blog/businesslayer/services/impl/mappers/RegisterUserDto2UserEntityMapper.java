package it.epicode.blog.businesslayer.services.impl.mappers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import it.epicode.blog.businesslayer.services.Mapper;
import it.epicode.blog.businesslayer.services.dto.RegisterUserDto;
import it.epicode.blog.datalayer.entities.UserEntity;

@Component
@Scope("singleton")
public class RegisterUserDto2UserEntityMapper implements Mapper<RegisterUserDto, UserEntity> {

	@Override
	public RegisterUserDto convertTo(UserEntity input) {
		return RegisterUserDto.builder() //
				.withFriendlyName(input.getFriendlyName()) //
				.withPassword(input.getPassword())//
				.withUsername(input.getUsername()).build();
	}

	@Override
	public UserEntity convertFrom(RegisterUserDto input) {
		return UserEntity.builder() //
				.withFriendlyName(input.getFriendlyName()) //
				.withPassword(input.getPassword()) //
				.withUsername(input.getUsername()) //
				.build();
	}

}
