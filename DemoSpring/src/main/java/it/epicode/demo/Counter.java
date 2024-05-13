package it.epicode.demo;

import lombok.Data;

@Data
public class Counter {
	private int value;

	public void increment() {
		value++;
	}

}
