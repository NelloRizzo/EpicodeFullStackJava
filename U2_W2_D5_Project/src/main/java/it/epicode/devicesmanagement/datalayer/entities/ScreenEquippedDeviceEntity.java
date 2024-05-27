package it.epicode.devicesmanagement.datalayer.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public abstract class ScreenEquippedDeviceEntity extends DeviceEntity {
	@Column(nullable = false)
	private int screenSize;

	public ScreenEquippedDeviceEntity(EmployeeEntity employee, DeviceStatus status, String serialNo, int screenSize) {
		super(employee, status, serialNo);
		this.screenSize = screenSize;
	}

}
