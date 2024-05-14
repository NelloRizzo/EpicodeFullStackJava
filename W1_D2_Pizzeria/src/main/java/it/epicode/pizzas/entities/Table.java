package it.epicode.pizzas.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with")
public class Table {
	private String name;
	private int maxPlaces;
}
