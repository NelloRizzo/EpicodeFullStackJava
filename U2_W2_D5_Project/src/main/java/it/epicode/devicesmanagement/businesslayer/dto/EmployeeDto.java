package it.epicode.devicesmanagement.businesslayer.dto;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class EmployeeDto extends BaseDto {
	private String username;
	private String firstName;
	private String lastName;
	@EqualsAndHashCode.Include
	private String email;
	private String imagePicture;
	@JsonIgnore
	private MultipartFile file;

	@Builder(setterPrefix = "with")
	public EmployeeDto(Long id, String username, String firstName, String lastName, String email, String imagePicture, MultipartFile file) {
		super(id);
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.imagePicture = imagePicture;
		this.file = file;
	}

}
