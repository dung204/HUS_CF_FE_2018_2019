package ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BookManager {
	private static final ArrayList<Book> books = new ArrayList<>();

	public static ArrayList<Book> getBooks() {
		return (ArrayList<Book>) books.clone();
	}

	public static void add(Book book) {
		books.add(book);
	}

	public static void addFromFile(String pathname) throws FileNotFoundException {
		File file = new File(pathname);
		Scanner fileScanner = new Scanner(file);
		while(fileScanner.hasNextLine()) {
			String bookId = fileScanner.nextLine();
			String bookName = fileScanner.nextLine();
			String bookAuthor = fileScanner.nextLine();
			int bookPrice = Integer.parseInt(fileScanner.nextLine());
			double bookDiscount = Double.parseDouble(fileScanner.nextLine());

			BookManager.add(new Book(bookId, bookName, bookAuthor, bookPrice, bookDiscount));
		}
		fileScanner.close();
		System.out.printf("Successfully read from %s\n", pathname);
	}

	public static void sortByAuthor() {
		books.sort(Comparator.comparing(Book::getAuthor));
	}

	public static Book findById(String id) {
		return books.stream().filter(book -> book.getId().equals(id))
				.findFirst().orElse(null);
	}
}
