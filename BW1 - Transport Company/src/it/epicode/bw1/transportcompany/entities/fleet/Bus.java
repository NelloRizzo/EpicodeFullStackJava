package it.epicode.bw1.transportcompany.entities.fleet;

import it.epicode.bw1.transportcompany.entities.utils.C;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(C.T.Bus.DISCRIMINATOR_VALUE)
public class Bus extends Vehicle {
	private static final int CAPACITY = 56;

	public Bus() {

	}

	public Bus(String number) {
		super(number, CAPACITY);
	}

	@Override
	public void setCapacity(int capacity) {
		super.setCapacity(CAPACITY);
	}
}
