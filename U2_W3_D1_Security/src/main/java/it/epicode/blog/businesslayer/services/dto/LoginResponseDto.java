package it.epicode.blog.businesslayer.services.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
public class LoginResponseDto {
	private long id;
	private String username;
	private String friendlyName;
	private final List<String> roles;
	private String token;

	@Builder(setterPrefix = "with")
	public LoginResponseDto(long id, String username, String friendlyName, String token, List<String> roles) {
		this.id = id;
		this.username = username;
		this.friendlyName = friendlyName;
		this.roles = roles;
		this.token = token;
	}
}
