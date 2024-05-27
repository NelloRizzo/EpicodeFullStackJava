package it.epicode.devicesmanagement.presentationlayer.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EmployeeRequestModel( //
		@NotBlank(message = "The 'username' field is mandatory and not blank") //
		@Size(message="The field 'username' is too long (max 25 chars)")
		String username, //
		@NotBlank(message = "The 'firstName' field is mandatory and not blank") //
		@Size(message="The field 'firstName' is too long (max 25 chars)")
		String firstName, //
		@NotBlank(message = "The 'lastName' field is mandatory and not blank") //
		@Size(message="The field 'lastName' is too long (max 25 chars)")
		String lastName, //
		@NotBlank(message = "The 'email' field is mandatory and not blank") //
		@Email(message = "The email is not valid") //
		@Size(message="The field 'email' is too long (max 80 chars)")
		String email) {
}
