package it.epicode.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "events")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(length = 80, nullable = false)
	private String title;
	private Date date;
	@Column(length = 255, nullable = true)
	private String description;
	@Enumerated(EnumType.ORDINAL)
	private EventType type;
	@Column(name = "max_attendance")
	private int maxAttendance;
	@ManyToOne
	private Location location;
	@OneToMany(mappedBy = "event")
	private final List<Attendance> attendances = new ArrayList<>();

	public Event() {
	}

	public Event(String title, Date date, String description, EventType type, int maxAttendance) {
		this.title = title;
		this.date = date;
		this.description = description;
		this.type = type;
		this.maxAttendance = maxAttendance;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Date getDate() {
		return date;
	}

	public String getDescription() {
		return description;
	}

	public EventType getType() {
		return type;
	}

	public int getMaxAttendance() {
		return maxAttendance;
	}

	public Location getLocation() {
		return location;
	}

	public List<Attendance> getAttendances() {
		return attendances;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	public void setMaxAttendance(int maxAttendance) {
		this.maxAttendance = maxAttendance;
	}

	@Override
	public String toString() {
		return String.format(
				"Event[id=%d, title=\"%s\", date=%s, description=\"%s\", type=%s, maxAttendance=%d, location=%s]", id,
				title, date, description, type, maxAttendance, location);
	}

}
