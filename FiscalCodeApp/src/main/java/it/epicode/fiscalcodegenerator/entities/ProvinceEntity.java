package it.epicode.fiscalcodegenerator.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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

@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
@Entity
@ToString(callSuper = true)
@Table(name = "provinces", indexes = { @Index(name = "idx_unique_acronym", columnList = "acronym", unique = true) })
public class ProvinceEntity extends BaseEntity {
	@Column(length = 80, nullable = false)
	private String name;
	@Column(length = 2, nullable = false)
	@EqualsAndHashCode.Include
	private String acronym;
	@JsonIgnore
	@ToString.Exclude
	@OneToMany(mappedBy = "province", cascade = CascadeType.REMOVE)
	private final List<CityEntity> cities = new ArrayList<>();
}
