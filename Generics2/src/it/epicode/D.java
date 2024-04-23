package it.epicode;

public class D extends B {
	public D(String name, String title) {
		super(name);
		this.title = title;
	}

	@Override
	public String toString() {
		return String.format("D [title=%s, getName()=%s]", title, getName());
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private String title;
}
