package it.epicode.bw1.transportcompany.entities.resellers;

import it.epicode.bw1.transportcompany.entities.utils.C;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(C.T.VendingMachine.DISCRIMINATOR_VALUE)
public class VendingMachine extends Reseller {
	private boolean running;

	public VendingMachine() {
	}

	public VendingMachine(String name, boolean running) {
		super(name);
		this.running = running;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	@Override
	public String toString() {
		return String.format("VendingMachine(running=%s, %s)", running, super.toString());
	}

}
