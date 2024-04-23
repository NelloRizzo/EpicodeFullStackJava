package it.epicode;

public class GenericMy<T> {
	private T value;

	public GenericMy(T value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return String.format("My(value = %s)", value);
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}
