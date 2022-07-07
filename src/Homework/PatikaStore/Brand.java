package Homework.PatikaStore;

import java.util.LinkedHashMap;

public class Brand {
	private int id;
	private String name;
	private static String[] brands = new String[9];
	private static LinkedHashMap<String, Integer> nameId = new LinkedHashMap<>();
	private Product product;

	public Brand(String name) {
		this.id = nameId.get(name);
		this.name = name;
	}

	public static void printBrands() {
		compare(brands);

		System.out.println();
		System.out.println("BRANDS");
		System.out.println("----------------------------");
		for (String brand : brands) {
			System.out.println("- " + brand);
		}
		System.out.println();

	}

	private static void compare(String[] brands) {
		for (int i = 0; i < brands.length; i++) {
			String first = brands[i];
			int index = i;
			for (int j = i + 1; j < brands.length; j++) {
				int result = first.compareTo(brands[j]);
				if (result > 0) {
					first = brands[j];
					index = j;
				}
			}
			String temp = brands[i];
			brands[i] = first;
			brands[index] = temp;

		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static String[] getBrands() {
		return brands;
	}

	public static void addBrand(String brand, int index) {
		brands[index] = brand;
		nameId.put(brand, (index + 1));
	}
}
