package it.epicode.pizza.entities;

import lombok.NoArgsConstructor;
import lombok.ToString;

// effettua l'override del toString()
// specificando che al suo interno deve essere incluso il toString() della superclasse
@ToString(callSuper = true)
@NoArgsConstructor
public class Drink extends MenuItem {

	public Drink(String name, double price, int calories) {
		super(name, price, calories);
	}

}
