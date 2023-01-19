package ex2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Invoice {
	private final String customerId;
	private final String customerName;
	private final ArrayList<String> bookIds;
	private final int isVIP;

	public Invoice(String customerId, String customerName, ArrayList<String> bookIds, int isVIP) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.bookIds = bookIds;
		this.isVIP = isVIP;
	}

	@Override
	public String toString() {
		return String.format(
			"""
			Ma KH: %s
			Ten KH: %s
			Danh sach nhung quyen sach da mua:%s
			Tong tien: %,d (vnd)
			""",
			this.customerId, this.customerName,
			this.getBoughtBooksAsStringFromIds(),
			this.getTotalPrice()
		);
	}

	private String getBoughtBooksAsStringFromIds() {
		StringBuilder result = new StringBuilder();
		AtomicInteger count = new AtomicInteger(1);
		ArrayList<Book> boughtBooks = getBoughtBooksFromIds();
		boughtBooks.forEach(book -> {
			result.append('\n').append(count.get()).append(". ").append(book.toString());
			count.getAndIncrement();
		});
		return result.toString();
	}

	private int getTotalPrice() {
		AtomicInteger sum = new AtomicInteger(0);
		ArrayList<Book> boughtBooks = getBoughtBooksFromIds();
		boughtBooks.forEach(book -> {
			int price = (int) (book.getPrice() * (1 - (book.getDiscount() / 100)));
			sum.getAndAdd(price);
		});
		return sum.get();
	}

	private ArrayList<Book> getBoughtBooksFromIds() {
		ArrayList<Book> boughtBooks = new ArrayList<>();
		this.bookIds.forEach(id -> {
			Book found = BookManager.findById(id);
			boughtBooks.add(found);
		});
		return boughtBooks;
	}

	public void writeToFile(String pathname) throws IOException {
		FileWriter writer = new FileWriter(pathname);
		writer.write(this.toString());
		writer.close();
		System.out.printf("Successfully write invoice to %s\n", pathname);
	}
}
