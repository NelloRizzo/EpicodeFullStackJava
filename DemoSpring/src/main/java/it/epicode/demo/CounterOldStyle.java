package it.epicode.demo;

public class CounterOldStyle {
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void increment() {
		value++;
	}

	@Override
	public String toString() {
		return "Counter[value=%s]".formatted(value);
	}

}
