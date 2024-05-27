package it.epicode.devicesmanagement.datalayer.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tablets")
public class TabletDeviceEntity extends ScreenEquippedDeviceEntity {
	private boolean keyboardEquipped;
	@Column(length = 10, nullable = true)
	private String keyboardLayout;

	@Builder
	public TabletDeviceEntity(EmployeeEntity employee, DeviceStatus status, String serialNo, int screenSize,
			boolean keyboardEquipped, String keyboardLayout) {
		super(employee, status, serialNo, screenSize);
		this.keyboardEquipped = keyboardEquipped;
		this.keyboardLayout = keyboardLayout;
	}
}
