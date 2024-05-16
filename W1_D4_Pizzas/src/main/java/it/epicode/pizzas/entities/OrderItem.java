package it.epicode.pizzas.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Builder(setterPrefix = "with")
@Entity
@Table(name = "order_items")
public class OrderItem extends BaseEntity {
	@ManyToOne
	private MenuItem item;
	@Column(nullable = false)
	private int quantity;
	@ManyToOne
	private Order order;

	@ToString.Include(name = "totalPrice")
	public double getTotalPrice() {
		return item.getPrice() * quantity;
	}
}
