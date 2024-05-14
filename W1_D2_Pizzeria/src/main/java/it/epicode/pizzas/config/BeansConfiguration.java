package it.epicode.pizzas.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.epicode.pizzas.entities.Drink;
import it.epicode.pizzas.entities.Menu;
import it.epicode.pizzas.entities.Pizza;
import it.epicode.pizzas.entities.Table;
import it.epicode.pizzas.entities.Topping;
import it.epicode.pizzas.entities.XlPizza;

// indica che la classe partecipa alla configurazione dell'applicazione
@Configuration
public class BeansConfiguration {
	// crea un bean di JEE (non avendo specificato nulla, il bean sarà SINGLETON)
	@Bean(name = "toppings_tomato")
	Topping toppingTomatoBean() {
		return new Topping("Tomato", 0, 0);
	}

	@Bean(name = "toppings_cheese")
	Topping toppingCheeseBean() {
		return new Topping("Cheese", 0.69, 92);
	}

	@Bean(name = "toppings_ham")
	Topping toppingHamBean() {
		return new Topping("Ham", 0.99, 35);
	}

	@Bean(name = "toppings_pineapple")
	Topping toppingPineappleBean() {
		return new Topping("Pineapple", .79, 24);
	}

	@Bean(name = "toppings_salami")
	Topping toppingSalamiBean() {
		return new Topping("Salami", .99, 86);
	}

	@Bean(name = "pizza_margherita")
	Pizza pizzaMargheritaBean() {
		List<Topping> tList = new ArrayList<>();
		tList.add(toppingTomatoBean());
		tList.add(toppingCheeseBean());
		return new Pizza("Pizza Margherita", tList);
	}

	@Bean(name = "hawaiian_pizza")
	Pizza pizzaHawaiianBean() {
		List<Topping> tList = new ArrayList<>();
		tList.add(toppingTomatoBean());
		tList.add(toppingCheeseBean());
		tList.add(toppingHamBean());
		tList.add(toppingPineappleBean());
		return new Pizza("Hawaiian Pizza", tList);
	}

	@Bean(name = "salami_pizza")
	Pizza pizzaSalamiBean() {
		List<Topping> tList = new ArrayList<>();
		tList.add(toppingTomatoBean());
		tList.add(toppingCheeseBean());
		tList.add(toppingSalamiBean());
		return new Pizza("Salami Pizza", tList);
	}

	@Bean(name = "salami_pizza_xl")
	Pizza pizzaSalamiXlBean() {
		List<Topping> tList = new ArrayList<>();
		tList.add(toppingTomatoBean());
		tList.add(toppingCheeseBean());
		tList.add(toppingSalamiBean());
		return new XlPizza("Salami Pizza XL", tList);
	}

	@Bean(name = "lemonade")
	Drink lemonadeBean() {
		return new Drink("Lemonade", 1.24, 128);
	}

	@Bean(name = "water")
	Drink waterBean() {
		return new Drink("Water", 1.29, 0);
	}

	@Bean(name = "wine")
	Drink wineBean() {
		return new Drink("Wine", 7.49, 607);
	}

	@Bean(name = "menu")
	Menu menuBean() {
		List<Pizza> pizzaList = new ArrayList<>();
		List<Drink> drinkList = new ArrayList<>();
		List<Topping> toppingsList = new ArrayList<>();

		pizzaList.add(pizzaMargheritaBean());
		pizzaList.add(pizzaHawaiianBean());
		pizzaList.add(pizzaSalamiBean());
		pizzaList.add(pizzaSalamiXlBean());

		drinkList.add(lemonadeBean());
		drinkList.add(waterBean());
		drinkList.add(wineBean());

		toppingsList.add(toppingTomatoBean());
		toppingsList.add(toppingCheeseBean());
		toppingsList.add(toppingSalamiBean());
		toppingsList.add(toppingHamBean());
		toppingsList.add(toppingPineappleBean());

		return new Menu(pizzaList, drinkList, toppingsList);
	}

	@Bean(name = "table1")
	Table table1() {
		return Table.builder().withMaxPlaces(5).withName("Table n. 1").build();
	}

	@Bean(name = "table2")
	Table table2() {
		return Table.builder().withMaxPlaces(3).withName("Table n. 2").build();
	}
}
