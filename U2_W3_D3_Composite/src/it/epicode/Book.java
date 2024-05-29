package it.epicode;

import java.util.ArrayList;
import java.util.List;

public class Book {

	private final SectionItem content = new SectionItem("Libro");

	private List<String> authors = new ArrayList<>();
	private float price;

	public void addContent(BookItem content) {
		this.content.addItem(content);
	}

	public void printBook() {
		System.out.println("Totale pagine" + content.getPages());
		content.print();
	}
}
