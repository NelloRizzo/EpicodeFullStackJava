package it.epicode.pizza.entities;

import java.util.List;

import lombok.ToString;

@ToString(callSuper = true)
// Xl è una pizza
public class XlPizza extends Pizza {
	public XlPizza(String name, List<Topping> toppings) {
		super(name, toppings);
		// aggiunge il 5% al prezzo di base di una pizza
		setPrice(this.getPrice() * 1.05);
		// idem dicasi per le calorie
		setCalories((int) (getCalories() * 1.05));
	}
}
