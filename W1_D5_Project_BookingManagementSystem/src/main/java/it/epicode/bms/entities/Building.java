package it.epicode.bms.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "buildings", indexes = { @Index(columnList = "name,city", unique = true, name = "idx_unique_city_name") })
@ToString(callSuper = true)
public class Building extends BaseEntity {
	@Column(length = 25, nullable = false)
	private String name;
	@Column(length = 125, nullable = false)
	private String address;
	@Column(length = 80, nullable = false)
	private String city;
	@OneToMany(mappedBy = "building")
	@ToString.Exclude
	private final List<Workstation> workstations = new ArrayList<>();
}
