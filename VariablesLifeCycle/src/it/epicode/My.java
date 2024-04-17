package it.epicode;

public class My {
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public My(int value) {
		this.value = value;
	}

	public String asString() {
		return "My(" + value + ")";
	}
}
