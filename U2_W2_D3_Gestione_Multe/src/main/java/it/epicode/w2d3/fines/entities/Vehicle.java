package it.epicode.w2d3.fines.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vehicles", indexes = { @Index(columnList = "plate", unique = true) })
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicle_seq")
	@SequenceGenerator(name = "vehicle_seq", sequenceName = "vehicle_seq")
	public Long id;
	@Column(length = 10, nullable = false)
	@EqualsAndHashCode.Include
	public String plate;
	@Column(length = 25, nullable = true)
	public String make;
	@Column(length = 25, nullable = true)
	public String model;
	@Column(length = 50, nullable = false)
	public String owner;
}
