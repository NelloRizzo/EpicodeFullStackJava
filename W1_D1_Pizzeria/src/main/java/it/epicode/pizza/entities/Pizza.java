package it.epicode.pizza.entities;

import java.util.List;

import lombok.Getter;
import lombok.ToString;

@ToString(callSuper = true)
public class Pizza extends MenuItem {
	@Getter
	private final List<Topping> toppings;

	public Pizza(String name, List<Topping> toppings) {
		super(name, 4.3, 1012);
		this.toppings = toppings;
	}

	public double getPrice() {
		return super.getPrice() + toppings.stream().mapToDouble(t -> t.getPrice()).sum();
	}

	public int getCalories() {
		return super.getCalories() + toppings.stream().mapToInt(t -> t.getCalories()).sum();
	}
}
