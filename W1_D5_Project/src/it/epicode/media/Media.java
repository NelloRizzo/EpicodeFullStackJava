package it.epicode.media;

public abstract class Media {

	private String title;

	public Media(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return String.format("[%s] %s", getClass().getSimpleName(), title);
	}
}
