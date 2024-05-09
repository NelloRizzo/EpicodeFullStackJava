package it.epicode.bw1.transportcompany.entities.tickets;

import java.time.LocalDateTime;

import it.epicode.bw1.transportcompany.entities.resellers.Reseller;
import it.epicode.bw1.transportcompany.entities.users.User;
import it.epicode.bw1.transportcompany.entities.utils.C;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;

@Entity
@DiscriminatorValue(C.T.Subscription.DISCRIMINATOR_VALUE)
@NamedQuery(name = C.T.Subscription.Queries.SELECT_ALL, //
		query = "SELECT s FROM Subscription s WHERE s.owner IS NULL")
public class Subscription extends TravelDocument {
	@Embedded
	private TimeSpan timespan;
	@ManyToOne(optional = true)
	private User owner;

	public Subscription(String code, Reseller reseller, LocalDateTime issuedAt, TimeSpan timespan) {
		super(code, reseller, issuedAt);
		this.timespan = timespan;
	}

	public Subscription() {
	}

	public TimeSpan getTimespan() {
		return timespan;
	}

	public User getOwner() {
		return owner;
	}

	public void setTimespan(TimeSpan timespan) {
		this.timespan = timespan;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return String.format("Subscription(timespan=%s, owner=%s %s)", timespan, owner, super.toString());
	}

}
