package Homework.PatikaStore;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Product {

	static Scanner input = new Scanner(System.in).useLocale(Locale.US);

	private int id;
	private static int idNotebook = 0;
	private static int idMobilePhone = 0;

	private double unitPrice;
	private double discountRate;
	private int stock;

	private String model;
	private String nameBrand;
	private String productName;
	private Brand brand;

	private int storage;
	private double screenSize;
	private double camera;
	private int battery;
	private int RAM;
	private String color;

	private static HashMap<String, ArrayList<Product>> products = new HashMap<>() {
		{
			put("Notebook", new ArrayList<Product>());
			put("MobilePhone", new ArrayList<Product>());
		}
	};

	public Product(int id, double unitPrice, double discountRate, int stock, String model, String nameBrand,
			int storage, double screenSize, int RAM) {
		this.id = id;
		this.unitPrice = unitPrice;
		this.discountRate = discountRate;
		this.stock = stock;
		this.model = model;
		this.nameBrand = nameBrand;
		this.brand = new Brand(nameBrand);
		this.storage = storage;
		this.screenSize = screenSize;
		this.RAM = RAM;
	}

	public Product(int id, double unitPrice, double discountRate, int stock, String model, String nameBrand,
			int storage, double screenSize, int camera, int battery, int RAM, String color) {
		this.id = id;
		this.unitPrice = unitPrice;
		this.discountRate = discountRate;
		this.stock = stock;
		this.model = model;
		this.nameBrand = nameBrand;
		this.storage = storage;
		this.screenSize = screenSize;
		this.camera = camera;
		this.battery = battery;
		this.RAM = RAM;
		this.color = color;
	}

	public static void processMenu(int num) {
		if (num == 1) {
			System.out.println();
			System.out.println("Notebook");
		} else {
			System.out.println();
			System.out.println("Mobile Phone");
		}
		System.out.println("-----------------");
		System.out.println("1 - List Items");
		System.out.println("2 - Add Items");
		System.out.println("3 - Delete Items");
		System.out.println("4 - Filter Items");
		System.out.print("Your choice: ");
		int choice = input.nextInt();
		System.out.println();

		switch (choice) {
		case 1 -> listItems(num);
		case 2 -> addItems(num);
		case 3 -> deleteItems(num);
		case 4 -> filterItems(num);
		default -> {
			System.out.println();
			System.out.println("There is no such an option. Please enter your choice again.");
			processMenu(num);
		}
		}
	}

	public static void listItems(int num) {
		if (num % 2 != 0) {
			// Notebook
			System.out.println(
					"----------------------------------------------------------------------------------------------------------");
			System.out.println(
					"| ID | Product Name                   | Price      | Brand      | Storage    | Screen Size  | RAM        |");
			System.out.println(
					"----------------------------------------------------------------------------------------------------------");

			ArrayList<Product> productList = products.get("Notebook");

			if (!productList.isEmpty()) {
				for (Product product : productList) {
					String productName = product.getNameBrand() + " " + product.getModel();
					product.setProductName(productName);

					System.out.printf("| %-2s | %-30s| %-10s TL | %-10s| %-10s| %-12s | %-10s |\n", product.getId(),
							product.getProductName(), product.getUnitPrice(), product.getNameBrand(),
							product.getStorage(), product.getScreenSize(), product.getRAM());
				}
				System.out.println(
						"----------------------------------------------------------------------------------------------------------");
			}
			System.out.println();

		} else {
			// Mobile phone
			System.out.println(
					"-------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(
					"| ID | Product Name                   | Price      | Brand      | Storage    | Screen Size  | Camera     | Battery    | RAM        | COLOR      |");
			System.out.println(
					"-------------------------------------------------------------------------------------------------------------------------------------------------");

			ArrayList<Product> productList = products.get("MobilePhone");

			if (!productList.isEmpty()) {
				for (Product product : productList) {
					String productName = product.getNameBrand() + " " + product.getModel();
					product.setProductName(productName);

					System.out.printf(
							"| %-2s | %-30s| %-10s TL | %-10s| %-10s| %-12s | %-10s | %-10s | %-10s | %-10s |\n",
							product.getId(), product.getProductName(), product.getUnitPrice(), product.getNameBrand(),
							product.getStorage(), product.getScreenSize(), product.getCamera(), product.getBattery(),
							product.getRAM(), product.getColor());
				}
				System.out.println(
						"-------------------------------------------------------------------------------------------------------------------------------------------------");

			}
			System.out.println();

		}
	}

	public static void addItems(int num) {
		System.out.print("Unit Price: ");
		double unitPriceInput = input.nextDouble();
		System.out.print("Discount Rate: ");
		double discountRateInput = input.nextDouble();
		System.out.print("Stock: ");
		int stockInput = input.nextInt();
		System.out.print("Brand: ");
		String brandInput = input.next();
		input.nextLine();
		System.out.print("Model: ");
		String modelInput = input.nextLine();
		System.out.print("Storage: ");
		int storageInput = input.nextInt();
		System.out.print("Screen Size: ");
		double screenSizeInput = input.nextDouble();
		System.out.print("RAM: ");
		int RAMInput = input.nextInt();

		if (num % 2 != 0) {
			// Notebook
			idNotebook += 1;
			int id = idNotebook;

			Product newNotebook = new Product(id, unitPriceInput, discountRateInput, stockInput, modelInput, brandInput,
					storageInput, screenSizeInput, RAMInput);
			products.get("Notebook").add(newNotebook);

		} else {
			// Mobile Phone
			idMobilePhone += 1;
			int id = idMobilePhone;
			System.out.print("Camera: ");
			int cameraInput = input.nextInt();
			System.out.print("Battery Capacity: ");
			int batteryInput = input.nextInt();
			input.nextLine();
			System.out.print("Color: ");
			String colorInput = input.nextLine();

			Product newMobilePhone = new Product(id, unitPriceInput, discountRateInput, stockInput, modelInput,
					brandInput, storageInput, screenSizeInput, cameraInput, batteryInput, RAMInput, colorInput);
			products.get("MobilePhone").add(newMobilePhone);

		}
	}

	public static void deleteItems(int num) {
		System.out.print("Enter an ID value to delete: ");
		int idProduct = input.nextInt();
		boolean notExist = true;
		if (num % 2 != 0) {
			for (Product product : products.get("Notebook")) {
				if (product.getId() == idProduct) {
					products.get("Notebook").remove(product);
					notExist = false;
					System.out.println("The product with ID " + idProduct + " has been removed from the system.");
					break;
				}
			}

		} else {
			for (Product product : products.get("MobilePhone")) {
				if (product.getId() == idProduct) {
					products.get("MobilePhone").remove(product);
					notExist = false;
					System.out.println("The product with ID " + idProduct + " has been removed from the system.");
					break;
				}
			}

		}
		if (notExist) {
			System.out.println("The value ID is not found in the system. Please check your ID and Try again...");
		}
	}

	public static void filterItems(int num) {
		System.out.print("Enter an ID to filter products or '0' if you don't like to enter an ID: ");
		int idProduct = input.nextInt();
		boolean idExits = idProduct != 0;

		System.out.print("Enter the brand to filter products or 'none' if you don't like to enter a brand: ");
		String brandProduct = input.next();
		boolean brandExits = !brandProduct.equals("none");

		ArrayList<Product> filteredProducts = new ArrayList<>();

		if (num % 2 != 0) {
			if (idExits && brandExits) {
				for (Product product : products.get("Notebook")) {
					if (brandProduct.equals(product.getNameBrand()) && product.getId() == idProduct) {
						filteredProducts.add(product);
						listFilteredItems(num, filteredProducts);
						break;
					} else {
						System.out.println(
								"The value ID or brand is not found in the system. Please check your ID or brand. Then Try again...");
						filterItems(num);
					}
				}
			} else {
				if (brandExits) {
					for (Product product : products.get("Notebook")) {
						if (brandProduct.equals(product.getNameBrand())) {
							filteredProducts.add(product);
						}
					}
					listFilteredItems(num, filteredProducts);
				} else {
					System.out.println(
							"The brand is not found in the system. Please check your brand. Then Try again...\nATTENTION: **You must enter ID with a brand together.**");
					filterItems(num);
				}
			}

		} else {
			if (idExits && brandExits) {
				for (Product product : products.get("MobilePhone")) {
					if (brandProduct.equals(product.getNameBrand()) && product.getId() == idProduct) {
						filteredProducts.add(product);
						listFilteredItems(num, filteredProducts);
						break;
					} else {
						System.out.println(
								"The value ID or brand is not found in the system. Please check your ID or brand. Then Try again...");
						filterItems(num);
					}
				}
			} else {
				if (brandExits) {
					for (Product product : products.get("MobilePhone")) {
						if (brandProduct.equals(product.getNameBrand())) {
							filteredProducts.add(product);
						}
					}
					listFilteredItems(num, filteredProducts);
				} else {
					System.out.println(
							"The brand is not found in the system. Please check your brand. Then Try again...\nATTENTION: **You must enter ID with a brand together.**");
					filterItems(num);
				}
			}
		}
	}

	private static void listFilteredItems(int num, ArrayList<Product> filteredProductList) {
		if (num % 2 != 0) {
			// Notebook
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------");
			System.out.println(
					"| ID | Product Name                   | Price           | Brand      | Storage    | Screen Size  | RAM        |");
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------");

			if (!filteredProductList.isEmpty()) {
				for (Product product : filteredProductList) {
					System.out.printf("| %-2s | %-30s| %-15s TL | %-10s| %-10s| %-12s | %-10s |\n", product.getId(),
							product.getProductName(), product.getUnitPrice(), product.getNameBrand(),
							product.getStorage(), product.getScreenSize(), product.getRAM());
				}
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------");
			}
			System.out.println();

		} else {
			// Mobile phone
			System.out.println(
					"------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(
					"| ID | Product Name                   | Price           | Brand      | Storage    | Screen Size  | Camera     | Battery    | RAM        | COLOR      |");
			System.out.println(
					"------------------------------------------------------------------------------------------------------------------------------------------------------");

			if (!filteredProductList.isEmpty()) {
				for (Product product : filteredProductList) {
					System.out.printf(
							"| %-2s | %-30s| %-15s TL | %-10s| %-10s| %-10s | %-12s | %-10s | %-10s | %-10s |\n",
							product.getId(), product.getProductName(), product.getUnitPrice(), product.getNameBrand(),
							product.getStorage(), product.getScreenSize(), product.getCamera(), product.getBattery(),
							product.getRAM(), product.getColor());
				}
				System.out.println(
						"------------------------------------------------------------------------------------------------------------------------------------------------------");

			}
			System.out.println();

		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getNameBrand() {
		return nameBrand;
	}

	public void setNameBrand(String nameBrand) {
		this.nameBrand = nameBrand;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

	public double getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}

	public double getCamera() {
		return camera;
	}

	public void setCamera(double camera) {
		this.camera = camera;
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int batteryPower) {
		this.battery = batteryPower;
	}

	public int getRAM() {
		return RAM;
	}

	public void setRAM(int RAM) {
		this.RAM = RAM;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public static HashMap<String, ArrayList<Product>> getProducts() {
		return products;
	}

	public static void setProducts(HashMap<String, ArrayList<Product>> products) {
		Product.products = products;
	}
}
