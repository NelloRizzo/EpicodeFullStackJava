package it.epicode.pizzas.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Entity
public class Menu extends BaseEntity {
	@ManyToMany
	private final List<MenuItem> items = new ArrayList<>();

	/**
	 * Stampa il menu.
	 * 
	 * @param includeXL indica se stampare anche le pizze XL.
	 */
	public void printMenu(boolean includeXL) {
		// ho scelto di usare il println() per consentire una lettura
		// comoda del menu. questa scelta NON VARRA' in nessun altro esempio!!!!
		System.out.println("****** MENU ******");
		System.out.println("Pizze");
		items.stream().filter(p -> p instanceof Pizza).filter(p -> !(p instanceof XlPizza) || includeXL)
				.forEach(System.out::println);
		System.out.println("Toppings");
		items.stream().filter(p -> p instanceof Topping).forEach(System.out::println);
		System.out.println("Drinks");
		items.stream().filter(p -> p instanceof Drink).forEach(System.out::println);
	}
}
