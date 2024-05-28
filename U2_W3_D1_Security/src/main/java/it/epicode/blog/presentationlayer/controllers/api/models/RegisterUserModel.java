package it.epicode.blog.presentationlayer.controllers.api.models;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;

public record RegisterUserModel( //
		@NotBlank @Length(max = 125) String username, //
		@NotBlank @Length(max = 15) String password, //
		@Length(max = 25) String friendlyName, String roles) {
}
