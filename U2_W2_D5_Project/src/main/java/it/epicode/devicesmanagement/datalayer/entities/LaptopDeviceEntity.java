package it.epicode.devicesmanagement.datalayer.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "laptops")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor
public class LaptopDeviceEntity extends ScreenEquippedDeviceEntity {
	private boolean hddEquipped;
	private boolean dvdEquipped;
	@Column(nullable = true)
	private Integer hddSize;
	private int ramSize;

	@Builder
	public LaptopDeviceEntity(EmployeeEntity employee, DeviceStatus status, String serialNo, int screenSize,
			boolean hddEquipped, boolean dvdEquipped, Integer hddSize, int ramSize) {
		super(employee, status, serialNo, screenSize);
		this.hddEquipped = hddEquipped;
		this.dvdEquipped = dvdEquipped;
		this.hddSize = hddSize;
		this.ramSize = ramSize;
	}
}
