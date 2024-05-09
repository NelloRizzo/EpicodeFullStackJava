package it.epicode.bw1.transportcompany.entities.routes;

import it.epicode.bw1.transportcompany.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Route extends BaseEntity {
	@Column(length = 25, nullable = false)
	private String name;
	@Column(length = 25, nullable = false)
	private String starting;
	@Column(length = 25, nullable = false)
	private String finish;

	public Route() {
	}

	public Route(String name, String from, String to) {
		this.name = name;
		this.starting = from;
		this.finish = to;
	}

	public String getName() {
		return name;
	}

	public String getStarting() {
		return starting;
	}

	public String getFinish() {
		return finish;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStarting(String from) {
		this.starting = from;
	}

	public void setFinish(String to) {
		this.finish = to;
	}

	@Override
	public String toString() {
		return String.format("Route(name=%s, from=%s, to=%s, %s)", name, starting, finish, super.toString());
	}

}
