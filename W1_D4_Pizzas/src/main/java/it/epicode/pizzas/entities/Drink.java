package it.epicode.pizzas.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "drinks")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class Drink extends MenuItem {

	public Drink(String name, double price, int calories) {
		super(name, price, calories);
	}

}
