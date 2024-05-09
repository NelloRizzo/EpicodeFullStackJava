package it.epicode.bw1.transportcompany.entities.resellers;

import it.epicode.bw1.transportcompany.entities.utils.C;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(C.T.Vendor.DISCRIMINATOR_VALUE)
public class Vendor extends Reseller {

	public Vendor() {
	}

	public Vendor(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return String.format("Vendor(%s)", super.toString());
	}

}
