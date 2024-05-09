package it.epicode.bw1.transportcompany.entities.fleet;

import it.epicode.bw1.transportcompany.entities.BaseEntity;
import it.epicode.bw1.transportcompany.entities.utils.C;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.NamedQuery;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = C.Names.DISCRIMINATOR_COLUMN, discriminatorType = DiscriminatorType.INTEGER)
@NamedQuery(name = C.T.Vehicle.Queries.SELECT_ALL, query = "SELECT v FROM Vehicle v")
public abstract class Vehicle extends BaseEntity {
	@Column(length = 15, nullable = false)
	private String number;
	@Column(nullable = false, updatable = false)
	private int capacity;

	public Vehicle() {
	}

	public Vehicle(String number, int capacity) {
		this.number = number;
		this.capacity = capacity;
	}

	public String getNumber() {
		return number;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return String.format("Vehicle(number=%s, capacity=%s, %s)", number, capacity, super.toString());
	}

}
