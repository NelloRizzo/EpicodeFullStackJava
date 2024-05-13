package it.epicode.pizza.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter(value = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
public class MenuItem {
	private String name;
	private double price;
	private int calories;
}
