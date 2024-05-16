package it.epicode.pizzas.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
	@ToString.Exclude
	@OneToMany(mappedBy = "order")
	private final List<OrderItem> items = new ArrayList<>();
	@Column(nullable = false)
	private double seatAmount;
	@Column(nullable = false)
	private int totalPlaces;
	@Column(nullable = false, length = 15)
	private String number;
	@Column(nullable = false)
	private LocalDateTime dateTime;
	@ManyToOne
	private RestaurantTable table;

	@ToString.Include(name = "totalPrice")
	public double getTotalPrice() {
		return seatAmount * totalPlaces + items.stream().mapToDouble(OrderItem::getTotalPrice).sum();
	}
}
