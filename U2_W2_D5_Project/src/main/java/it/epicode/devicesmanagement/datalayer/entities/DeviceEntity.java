package it.epicode.devicesmanagement.datalayer.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class DeviceEntity extends BaseEntity {
	@ToString.Exclude
	@ManyToOne(optional = true)
	private EmployeeEntity employee;
	@Enumerated(EnumType.ORDINAL)
	private DeviceStatus status;
	@Column(length = 50, nullable = false, unique = true)
	private String serialNo;
}
