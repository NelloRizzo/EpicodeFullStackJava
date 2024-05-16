package it.epicode.pizzas.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder(setterPrefix = "with")
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Table(name = "tables")
public class RestaurantTable extends BaseEntity {
	@Column(length = 15, nullable = false)
	private String name;
	@Column(nullable = false)
	private int maxPlaces;
}
