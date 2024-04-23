package it.epicode;

public class My {

	private Object value;

	public My(Object value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return String.format("My(value = %s)", value);
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
