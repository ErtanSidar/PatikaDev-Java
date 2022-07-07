package Homework.BookSorting;

import java.util.Date;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Book b1 = new Book("Atomic Habits", 280, "James Clear", new Date(12-10-2011));
		Book b2 = new Book("Little Princess", 280, "James Clear", new Date(12-10-2011));
		Book b3 = new Book("Elon Musk", 380, "Asley Vancee", new Date(12-10-2011));
		Book b4 = new Book("Sapiens", 280, "Yuval Noah Harari", new Date(12-10-2011));
		
		TreeSet<Book> books = new TreeSet<Book>(new OrderBookCompare());
		books.add(b1);
		books.add(b2);
		books.add(b3);
		books.add(b4);
		
		for (Book book:books) {
            System.out.println("Book Name : " + book.getBookName() +
                    ",\t Page Size : " + book.getPageSize() +
                    ",\t Author name : " + book.getAuthorName() +
                    ",\t Puplished Date : " + book.getPublishedDate());
        }
	}

}
