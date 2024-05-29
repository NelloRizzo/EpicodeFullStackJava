package it.epicode;

public class PageItem extends BookItem{

	private String content;
	
	public PageItem(String content) {
		this.content = content;
	}
	
	@Override
	protected void print(int indent) {
		System.out.print("\t".repeat(indent));
		System.out.println(content);
	}

	@Override
	protected int getPages() {
		return 1;
	}

}
