package it.epicode.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "attendances")
public class Attendance {
	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	private Person person;
	@ManyToOne
	private Event event;
	@Enumerated(EnumType.ORDINAL)
	private Status status;

	public Attendance(Person person, Event event, Status status) {
		this.person = person;
		this.event = event;
		this.status = status;
	}

	public Attendance() {
	}

	public long getId() {
		return id;
	}

	public Person getPerson() {
		return person;
	}

	public Event getEvent() {
		return event;
	}

	public Status getStatus() {
		return status;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return String.format("Attendance[id=%s, person=%s, event=%s, status=%s]", id, person.getFirstName(), event,
				status);
	}

}
