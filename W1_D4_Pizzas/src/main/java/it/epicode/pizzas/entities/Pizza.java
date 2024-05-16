package it.epicode.pizzas.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString(callSuper = true)
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Data
@Table(name = "pizzas")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Pizza extends MenuItem {
	// l'attributo Getter può essere associato anche soltanto ad un attributo della
	// classe
	@Getter
	@ManyToMany
	private final List<Topping> toppings;

	public Pizza(String name, List<Topping> toppings) {
		// 4.3 è il prezzo che vado ad impostare nel campo price
		// 1012 è il contenuto calorico impostato nel campo calories
		super(name, 4.3, 1012);
		this.toppings = toppings;
	}

	public double getPrice() {
		// prendi il prezzo di base (4.3)
		return super.getPrice() + // e aggiungi i prezzi dei toppings
				toppings.stream().mapToDouble(t -> t.getPrice()).sum();
	}

	public int getCalories() {
		return super.getCalories() + //
				toppings.stream().mapToInt(t -> t.getCalories()).sum();
	}
}
