package it.epicode.w1d3.ex3;

public class Product {
	private String code;
	private String description;
	private int price;
	private int stock;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Product(String code, String description, int price, int stock) {
		super();
		this.code = code;
		this.description = description;
		this.price = price;
		this.stock = stock;
	}

	@Override
	public String toString() {
		return String.format("Product[code=%s, description=%s, price=%s, stock=%s]", code, description, price, stock);
	}

}
