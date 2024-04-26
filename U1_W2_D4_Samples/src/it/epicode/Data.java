package it.epicode;

public class Data {
	private int value;
	private String name;

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Data(int value, String name) {
		this.value = value;
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Data [value=%s, name=%s]", value, name);
	}

}
