package it.epicode.pizzas.entities;

import java.util.List;

import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class XlPizza extends Pizza {
	public XlPizza(String name, List<Topping> toppings) {
		super(name, toppings);
		// aggiunge il 5% al prezzo di base di una pizza
		setPrice(this.getPrice() * 1.05);
		// idem dicasi per le calorie
		setCalories((int) (getCalories() * 1.05));
	}
}
