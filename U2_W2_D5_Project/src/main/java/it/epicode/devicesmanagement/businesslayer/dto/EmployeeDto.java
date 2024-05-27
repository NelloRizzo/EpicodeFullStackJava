package it.epicode.devicesmanagement.businesslayer.dto;

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

	@Builder(setterPrefix = "with")
	public EmployeeDto(Long id, String username, String firstName, String lastName, String email, String imagePicture) {
		super(id);
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.imagePicture = imagePicture;
	}

}
