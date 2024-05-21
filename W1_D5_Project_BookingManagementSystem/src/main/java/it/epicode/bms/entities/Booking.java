package it.epicode.bms.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
@Table(name = "bookings", indexes = {
		@Index(columnList = "user_id,workstation_id,date", unique = true, name = "idx_unique_user_station"),
		@Index(columnList = "user_id,date", unique = true, name = "idx_unique_user_date") })
public class Booking extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "workstation_id")
	private Workstation workstation;
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private LocalDate date;
}
