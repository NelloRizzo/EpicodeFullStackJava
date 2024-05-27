package it.epicode.devicesmanagement.datalayer.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity extends BaseEntity {
	@Column(length = 25, nullable = false, unique = true)
	private String username;
	@Column(length = 25, nullable = false)
	private String firstName;
	@Column(length = 25, nullable = false)
	private String lastName;
	@EqualsAndHashCode.Include
	@Column(length = 80, nullable = false, unique = true)
	private String email;
	@Column(length = 255, nullable = true)
	private String imagePicture;
	@OneToMany(mappedBy = "employee")
	private final List<DeviceEntity> devices = new ArrayList<>();
}
