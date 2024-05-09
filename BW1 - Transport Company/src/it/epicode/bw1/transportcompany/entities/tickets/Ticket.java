package it.epicode.bw1.transportcompany.entities.tickets;

import java.time.LocalDateTime;

import it.epicode.bw1.transportcompany.entities.resellers.Reseller;
import it.epicode.bw1.transportcompany.entities.utils.C;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(C.T.Ticket.DISCRIMINATOR_VALUE)
public class Ticket extends TravelDocument {

	public Ticket() {
	}

	public Ticket(String number, Reseller issuedBy, LocalDateTime issuedAt) {
		super(number, issuedBy, issuedAt);
	}

	@Override
	public String toString() {
		return String.format("Ticket(%s)", super.toString());
	}

}
