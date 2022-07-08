package Homework.BookList;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b1= new Book("Kuşlarda Gitti", 120, "Yaşar kemal", new Date(10-10-2010));
		Book b2= new Book("İçimizdeki Şeytan", 185, "Sabahattin Ali", new Date(10-10-2010));
		Book b3= new Book("Suç ve Ceza", 500, "Dostoyevski", new Date(10-10-2010));
		Book b4= new Book("Gurur ve Önyargı", 480, "Jane Austin", new Date(10-10-2010));
		Book b5= new Book("Serenad", 320, "Zülfü Livaneli", new Date(10-10-2010));
		
		List<Book> list = new ArrayList<Book>();
		list.add(b1);
		list.add(b2);
		list.add(b3);
		list.add(b4);
		list.add(b5);
		
		Map<String, String> books = new HashMap();
		
		list.stream().forEach(book -> {
			books.put(book.getName(), book.getAuthorName());
		});
		
		list.stream().filter(book -> book.getPage()>200).forEach(book -> System.out.println(book.getName()));
		
		//System.out.println(books.toString());

	}

}
