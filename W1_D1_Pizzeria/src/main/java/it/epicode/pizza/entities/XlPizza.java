package it.epicode.pizza.entities;

import java.util.List;

import lombok.ToString;

@ToString(callSuper = true)
public class XlPizza extends Pizza {
	public XlPizza(String name, List<Topping> toppings) {
		super(name, toppings);
		setPrice(this.getPrice() * 1.05);
		setCalories((int) (getCalories() * 1.05));
	}
}
