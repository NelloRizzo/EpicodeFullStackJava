package it.epicode.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue
	private long id;
	@Column(length = 15)
	private String username;
	@Column(length = 15)
	private String password;

	@ManyToMany
	@JoinTable(name = "users_roles", //
			joinColumns = @JoinColumn(name = "role_fk"), //
			inverseJoinColumns = @JoinColumn(name = "user_fk"))
	private final List<Role> roles = new ArrayList<>();

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User() {
	}

	public long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, username=%s, password=%s]", id, username, password);
	}

}
