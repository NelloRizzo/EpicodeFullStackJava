package it.epicode.pizzas.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Table(name = "toppings")
public class Topping extends MenuItem {

	public Topping(String name, double price, int calories) {
		super(name, price, calories);
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private String name;
		private double price;
		private int calories;

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setPrice(double price) {
			this.price = price;
			return this;
		}

		public Builder setCalories(int calories) {
			this.calories = calories;
			return this;
		}

		public Topping build() {
			return new Topping(name, price, calories);
		}
	}
}
