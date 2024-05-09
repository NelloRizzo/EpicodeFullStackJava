package it.epicode.bw1.transportcompany.entities.users;

import java.util.ArrayList;
import java.util.List;

import it.epicode.bw1.transportcompany.entities.BaseEntity;
import it.epicode.bw1.transportcompany.entities.tickets.Subscription;
import it.epicode.bw1.transportcompany.entities.utils.C;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

@Entity
@NamedQuery(name = C.T.User.Queries.SELECT_ALL, query = "SELECT u FROM User u")
public class User extends BaseEntity {
	@Column(nullable = false)
	private String name;
	@Embedded
	private Card card;

	@OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
	private final List<Subscription> subscriptions = new ArrayList<>();

	public User() {
	}

	public User(String name, Card card) {
		this.name = name;
		this.card = card;
	}

	public String getName() {
		return name;
	}

	public Card getCard() {
		return card;
	}

	public List<Subscription> getSubscriptions() {
		return subscriptions;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return String.format("User(name=%s, card=%s, %s)", name, card, super.toString());
	}
}
