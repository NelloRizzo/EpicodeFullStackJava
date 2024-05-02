package it.epicode.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue
	private long id;
	@Column(length = 15)
	private String name;

	@ManyToMany(mappedBy = "roles", cascade = CascadeType.REMOVE)
	private final List<User> users = new ArrayList<>();

	public Role(String name) {
		this.name = name;
	}

	public Role() {
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Role [id=%s, name=%s]", id, name);
	}

}
