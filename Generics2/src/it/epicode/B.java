package it.epicode;

public class B {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public B(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("B [name=%s]", name);
	}

}
