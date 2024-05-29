package it.epicode;

public class Book {

	private final SectionItem content = new SectionItem("Libro");

	public void addContent(BookItem content) {
		this.content.addItem(content);
	}

	public void printBook() {
		content.print();
	}
}
