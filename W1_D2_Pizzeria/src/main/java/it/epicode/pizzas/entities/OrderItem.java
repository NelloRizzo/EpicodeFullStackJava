package it.epicode.pizzas.entities;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder(setterPrefix = "with")
public class OrderItem {
	private MenuItem item;
	private int quantity;

	@ToString.Include(name = "totalPrice")
	public double getTotalPrice() {
		return item.getPrice() * quantity;
	}
}
