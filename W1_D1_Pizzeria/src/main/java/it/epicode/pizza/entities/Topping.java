package it.epicode.pizza.entities;

import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString(callSuper = true)
public class Topping extends MenuItem {

	public Topping(String name, double price, int calories) {
		super(name, price, calories);
	}

}
