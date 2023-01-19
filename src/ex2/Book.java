package ex2;

public class Book {
	private final String id;
	private final String name;
	private final String author;
	private final int price;
	private final double discount;

	public Book(String id, String name, String author, int price, double discount) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
		this.discount = discount;
	}

	public String getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}

	public int getPrice() {
		return price;
	}

	public double getDiscount() {
		return discount;
	}

	@Override
	public String toString() {
		return String.format("%s, %s, %s, %d (vnd), %.1f%%",
				this.id, this.name, this.author, this.price, this.discount);
	}
}
