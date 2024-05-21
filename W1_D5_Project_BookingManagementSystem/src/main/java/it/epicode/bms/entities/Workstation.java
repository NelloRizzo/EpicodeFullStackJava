package it.epicode.bms.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
@Table(name = "workstations", indexes = {
		@Index(columnList = "code,building_id", unique = true, name = "idx_unique_building_code") })
public class Workstation extends BaseEntity {
	public enum Type {
		PRIVATE, OPENSPACE, MEETING_ROOM
	}

	@Column(length = 10, nullable = false)
	private String code;
	@Column(length = 255, nullable = true)
	private String description;
	@Enumerated(EnumType.ORDINAL)
	private Type type;
	@Column(nullable = true)
	private int maxAttendance;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "building_id")
	private Building building;

	@OneToMany(mappedBy = "workstation")
	private final List<Booking> bookings = new ArrayList<>();
}
