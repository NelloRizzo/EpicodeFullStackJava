package it.epicode.pizzas;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.epicode.pizzas.entities.Drink;
import it.epicode.pizzas.entities.Menu;
import it.epicode.pizzas.entities.Order;
import it.epicode.pizzas.entities.OrderItem;
import it.epicode.pizzas.entities.Pizza;
import it.epicode.pizzas.entities.Table;
import it.epicode.pizzas.entities.Topping;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OrderRunner implements CommandLineRunner {

	@Autowired
	@Qualifier("table1")
	Table table1;

	@Autowired
	Menu menu;

	@Autowired
	@Qualifier("salami_pizza_xl")
	Pizza salamiXl;

	@Autowired
	@Qualifier("lemonade")
	Drink lemonade;

	@Value("${order.placeAmount}")
	double placeAmount;

	@Override
	public void run(String... args) throws Exception {
		var order = Order.builder() // accedo al builder di un ordine
				.withTotalPlaces(2) // imposto il numero di coperti
				.withTable(table1) // imposto il tavolo
				.withPlaceAmount(placeAmount) // imposto il costo per coperti
				.withNumber("1") // imposto il numero dell'ordine
				.withDateTime(LocalDateTime.now()) // imposto la data
				.build(); // qui CREO EFFETTIVAMENTE L'ORDINE

		order.getItems().addAll(Arrays.asList( //
				OrderItem.builder() // crea un builder per un ordine
						.withItem(salamiXl) // imposta l'elemento ordinato
						.withQuantity(2) // imposta la quantità ordinata
						.build(), // crea effettivamente un Order
				OrderItem.builder().withItem(lemonade).withQuantity(2).build()));
		log.info("{}", order);

		@SuppressWarnings("unused")
		var topping = Topping.builder() //
				.setCalories(1000) // notazione fluente
				.setName("Esempio") //
				.setPrice(1.234) //
				.build();
		var b = Topping.builder();
		b.setCalories(1000);
		b.setName("Esempio");
		b.setPrice(1.234);
		
	}

}
