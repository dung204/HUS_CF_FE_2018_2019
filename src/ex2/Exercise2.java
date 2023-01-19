package ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise2 {
	public static void solve() throws IOException {
		// Requirement 1: read from file, add to a book ArrayList
		System.out.println("Exercise 2:");
		BookManager.addFromFile("books.txt");
		System.out.println("----------------------------------------");

		// Requirement 2: sort books by author then print to console
		BookManager.sortByAuthor();
		BookManager.getBooks().forEach(System.out::println);
		System.out.println("----------------------------------------");

		// Requirement 3: input customer's info from keyboard
		Scanner in = new Scanner(System.in);
		String customerId = in.nextLine();
		String customerName = in.nextLine();
		int numberOfBoughtBooks = Integer.parseInt(in.nextLine());
		ArrayList<String> bookIds = new ArrayList<>();
		for (int i = 1; i <= numberOfBoughtBooks; i++) {
			bookIds.add(in.nextLine());
		}
		int isVIP = Integer.parseInt(in.nextLine());
		Invoice invoice = new Invoice(customerId, customerName, bookIds, isVIP);

		// Requirement 4: write invoice to file
		System.out.println("----------------------------------------");
		invoice.writeToFile("invoice.txt");
	}
}
