package it.epicode.blog.businesslayer.services.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class RegisteredUserDto {
	private long id;
	private String username;
	private String friendlyName;
}
