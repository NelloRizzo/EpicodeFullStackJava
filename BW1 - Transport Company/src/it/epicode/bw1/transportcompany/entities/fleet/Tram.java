package it.epicode.bw1.transportcompany.entities.fleet;

import it.epicode.bw1.transportcompany.entities.utils.C;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(C.T.Tram.DISCRIMINATOR_VALUE)
public class Tram extends Vehicle {
	private static final int CAPACITY = 250;

	public Tram() {

	}

	public Tram(String number) {
		super(number, CAPACITY);
	}

	@Override
	public void setCapacity(int capacity) {
		super.setCapacity(CAPACITY);
	}
}
