package it.epicode;

import java.time.LocalDate;
import java.util.List;

public class Order {
	private Long id;
	private String status;
	private LocalDate orderDate;
	private LocalDate deliveryDate;
	private Customer customer;
	private final List<Product> products; // è, in genere, final perché viene costruita una sola volta
	// in genere non è efficiente procurare la riassegnazione di una collection,
	// quindi si implementa come final per evitare che ci sia una diversa new che
	// modifichi l'area occupata
	// UNA VARIABILE DICHIARATA final DEVE ESSERE INIZIALIZZATA O
	// IN FASE DI DICHIARAZIONE (cioè a riga 12) O NEL COSTRUTTORE DELLA CLASSE
	// (come in questo caso)
	// Poiché la variabile è final, non avrà un setter ma solo un getter
	// Tramite il getter potremo comunque aggiungere o eliminare elementi dalla
	// collection

	public Order(Long id, String status, LocalDate orderDate, LocalDate deliveryDate, Customer customer,
			List<Product> products) {
		this.id = id;
		this.status = status;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.customer = customer;
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public String getStatus() {
		return status;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return String.format("Order(id=%d, status=%s, orderDate=%tD, deliveryDate=%tD, customer=%s, products=%s)", id,
				status, orderDate, deliveryDate, customer, products);
	}

}
