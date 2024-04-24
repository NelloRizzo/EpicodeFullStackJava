package it.epicode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Program {

	static Random rnd = new Random(1234);
	static String[] categories = { "Baby", "Books", "Boys", "Girls", "Newspapers" };
	static String[] status = { "Confirmed", "In transit", "Delivered" };

	static List<Product> generateProducts(int count) {
		return LongStream.range(0, count) // crea un insieme di numeri Long da 0 a count
				.mapToObj(n -> new Product(n, // usa il numero per l'id
						String.format("Product %d", n), // ... poi per il prodotto
						categories[rnd.nextInt(categories.length)], // qui prende una categoria a caso tra quelle sopra
						rnd.nextDouble() * 1000 + 1) // un prezzo a caso tra 1 e 1000
				).toList();
	}

	static List<Customer> generateCustomers(int count) {
		return LongStream.range(0, count) //
				.mapToObj(n -> new Customer(n, //
						String.format("Customer %d", n), //
						rnd.nextInt(1, 11)))
				.toList();
	}

	static List<Order> generateOrders(int count, List<Product> products, List<Customer> customers) {
		var now = LocalDate.now();
		return LongStream.range(0, count) //
				.mapToObj(n -> new Order(n, //
						status[rnd.nextInt(status.length)], //
						now.plusDays(rnd.nextInt(-60, 2)), // una data a caso tra (oggi - 60 gg) e (oggi + 2 gg)
						now.plusDays(rnd.nextInt(0, 30)), // una data a caso tra oggi e (oggi + 30 gg)
						customers.get(rnd.nextInt(customers.size())), // prende un customer a caso tra tutti i customers
						IntStream.range(0, rnd.nextInt(1, 5)) // creo un numero casuale di prodotti nell'ordine
								.mapToObj( //
										x -> products.get(rnd.nextInt(products.size()))) // prodotto a caso
								.toList() // crea la lista dei prodotti da passare all'ordine
				)).toList();

	}

	public static void main(String[] args) {
		var customers = generateCustomers(15);
		// prendo la lista generata dal metodo generateProducts
		// e metto tutto il risultato all'interno di un nuovo ArrayList
		// perché la lista generata non sarebbe modificabile in
		// quanto il toList() utilizzato nel metodo produce
		// una LISTA IMMUTABILE
		// ho fatto ricorso a questa soluzione perché tra gli esercizi
		// uno diceva di modificare il prezzo dei prodotti
		var products = new ArrayList<Product>(generateProducts(15));
		var orders = generateOrders(15, products, customers);

		System.out.println("***** Books: ");
		products.stream() //
				.filter(p -> p.getCategory().equals("Books")) // ricerca per categoria in prodotti
				.filter(p -> p.getPrice() > 100) // prezzo > 100
				.forEach(System.out::println);

		System.out.println("\n***** Ordini con prodotti Baby:");
		orders.stream() //
				.filter(o -> // questa richiesta prevede che ci sia almeno un prodotto Baby
				o.getProducts().stream() // prendo i prodotti (si tratta di una collection)
						.anyMatch(p -> p.getCategory().equals("Baby")) // anyMatch restituisce true se ALMENO un
																		// elemento della collection soddisfa la
																		// condizione
				).forEach(System.out::println);

		var from = LocalDate.of(2024, 2, 1); // 1 febbraio 2024
		var to = LocalDate.of(2024, 4, 1); // 1 aprile 2024
		var level = 1;
		System.out.format("\n***** Ordini tra il %tD e il %tD con clienti livello %d:%n", from, to, level);
		orders.stream() //
				.filter(o -> o.getOrderDate().isAfter(from) && o.getOrderDate().isBefore(to)) // filtro su orderDate
				.filter(o -> o.getCustomer().getTier() == level) // filtro sul livello del cliente
				.forEach(System.out::println);

		System.out.println("\n***** Modifica del prezzo");
		// modifica del prezzo dei prodotti Boys
		// ho utilizzato una lambda un po' più complessa per far comprendere
		// le possibilità che abbiamo a disposizione
		products.replaceAll(p -> { // prende il prodotto p
			if (p.getCategory().equals("Boys")) { // se la categoria è Boys
				System.out.format("Prodotto: %s €%.2f", p.getName(), p.getPrice());
				p.setPrice(p.getPrice() * .9); // applica il 10% di sconto
				System.out.format(" - dopo lo sconto: €%.2f%n", p.getPrice());
			}
			return p; // rimette a posto il prodotto p nella collection
		});
	}

}
