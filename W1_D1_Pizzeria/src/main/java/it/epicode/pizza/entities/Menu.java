package it.epicode.pizza.entities;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Menu {
	private final List<Pizza> pizzas;
	private final List<Drink> drinks;
	private final List<Topping> toppings;

	public void printMenu(boolean includeXL) {
		System.out.println("****** MENU ******");
		System.out.println("Pizze");
		pizzas.stream().filter(p -> !(p instanceof XlPizza) || includeXL).forEach(System.out::println);
		System.out.println("Toppings");
		toppings.forEach(System.out::println);
		System.out.println("Drinks");
		drinks.forEach(System.out::println);
	}
}
