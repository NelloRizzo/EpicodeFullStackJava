package it.epicode.blog.businesslayer.services.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with")
@AllArgsConstructor
public class RegisterUserDto extends DtoBase {
	private String username;
	private String password;
	private String friendlyName;
}
