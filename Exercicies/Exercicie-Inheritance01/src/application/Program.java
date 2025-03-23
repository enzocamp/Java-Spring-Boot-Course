package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) {
	
		final DateTimeFormatter fmt =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> products = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Product #" + i +  " data: ");
			System.out.print(" Common, used or imported (c/u/i)? ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			if (type == 'i') {
				System.out.print("Customsfee: ");
				Double customFee = sc.nextDouble();
				products.add(new ImportedProduct(name, price, customFee));
			}
			else if (type == 'u') {
				System.out.print("Manufacturedate (DD/MM/YYYY): ");
				String  date = sc.next();
				LocalDate manufactureDate = LocalDate.parse(date,fmt);
				products.add(new UsedProduct(name, price, manufactureDate));
			}
			else{
				products.add(new Product(name, price));
			}
		}
		
		System.out.println("PRICE TAGS: ");
		for(Product prd : products) {
			System.out.println(prd.priceTag());
		}
		
		sc.close();
	}

}
