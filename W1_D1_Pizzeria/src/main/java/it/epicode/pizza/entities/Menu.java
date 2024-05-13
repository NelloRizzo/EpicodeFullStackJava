package it.epicode.pizza.entities;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Menu {
	private final List<Pizza> pizzas;
	private final List<Drink> drinks;
	private final List<Topping> toppings;

	/**
	 * Stampa il menu.
	 * @param includeXL indica se stampare anche le pizze XL.
	 */
	public void printMenu(boolean includeXL) {
		// ho scelto di usare il println() per consentire una lettura
		// comoda del menu. questa scelta NON VARRA' in nessun altro esempio!!!!
		System.out.println("****** MENU ******");
		System.out.println("Pizze");
		pizzas.stream().filter(p -> !(p instanceof XlPizza) || includeXL).forEach(System.out::println);
		System.out.println("Toppings");
		toppings.forEach(System.out::println);
		System.out.println("Drinks");
		drinks.forEach(System.out::println);
	}
}
