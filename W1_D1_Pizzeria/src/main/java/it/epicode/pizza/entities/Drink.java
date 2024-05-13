package it.epicode.pizza.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class Drink extends MenuItem {

	public Drink(String name, double price, int calories) {
		super(name, price, calories);
	}

}
