package it.epicode;

public class IntWrapper {
	private int value;

	public IntWrapper() {
		this(0);
	}

	public IntWrapper(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
