package it.epicode.bw1.transportcompany.entities.resellers;

import it.epicode.bw1.transportcompany.entities.BaseEntity;
import it.epicode.bw1.transportcompany.entities.utils.C;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = C.Names.DISCRIMINATOR_COLUMN, discriminatorType = DiscriminatorType.INTEGER)
public abstract class Reseller extends BaseEntity {
	@Column(nullable = false)
	private String name;

	public Reseller() {
	}

	public Reseller(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Reseller(name=%s, %s)", name, super.toString());
	}

}
