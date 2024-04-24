package it.epicode;

public class Product {
	private Long id;
	private String name;
	private String category;
	private Double price;

	public Product(Long id, String name, String category, Double price) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public Double getPrice() {
		return price;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("Product(id=%d, name=%s, category=%s, price= €%.2f)", id, name, category, price);
	}

}
