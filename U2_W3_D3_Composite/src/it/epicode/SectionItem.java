package it.epicode;

import java.util.ArrayList;
import java.util.List;

public class SectionItem extends BookItem {

	private String title;
	private final List<BookItem> content = new ArrayList<>();

	public SectionItem(String title) {
		this.title = title;
	}

	public void addItem(BookItem item) {
		this.content.add(item);
	}

	@Override
	protected void print(int indent) {
		System.out.print("\t".repeat(indent));
		System.out.println(title);
		content.forEach(c -> c.print(indent + 1));
	}

	@Override
	protected int getPages() {
		return content.stream().mapToInt(c -> c.getPages()).sum();
	}

}
