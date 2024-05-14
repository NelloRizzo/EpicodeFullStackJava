package it.epicode.pizzas.entities;

import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString(callSuper = true)
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
