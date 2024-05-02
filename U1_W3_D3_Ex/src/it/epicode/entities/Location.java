package it.epicode.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Location {
	@Id
	@GeneratedValue
	private long id;
	@Column(length = 80, nullable = false)
	private String name;
	@Column(length = 80, nullable = false)
	private String city;
	@OneToMany(mappedBy = "location")
	private final List<Event> events = new ArrayList<>();
	
	public Location(String name, String city) {
		this.name = name;
		this.city = city;
	}
	public Location() {
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCity() {
		return city;
	}
	public List<Event> getEvents(){
		return events;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return String.format("Location[id=%s, name=%s, city=%s]", id, name, city);
	}
	
}
