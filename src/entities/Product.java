package entities;

public class Product {
	private String name;
	private double price;
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void changeName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void changePrice(double price) {
		this.price = price;
	}
	
	
}
