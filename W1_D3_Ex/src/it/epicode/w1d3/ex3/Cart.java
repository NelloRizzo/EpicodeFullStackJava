package it.epicode.w1d3.ex3;

import java.util.Arrays;

public class Cart {
	private Customer customer;
	private Product[] products;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product[] getProducts() {
		return products;
	}

	public void setProducts(Product[] products) {
		this.products = products;
	}

	public int getTotalPrice() {
		int sum = 0;
		for (int i = 0; i < products.length; ++i) {
			sum += products[i].getPrice();
		}
		return sum;
	}

	public Cart(Customer customer, Product[] products) {
		this.customer = customer;
		this.products = products;
	}

	public String toString() {
		return String.format("Cart[customer=%s, totalPrice=%d, products=%s]", customer, getTotalPrice(),
				Arrays.toString(products));
	}
}
