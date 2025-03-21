package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Client;
import model.entities.Order;
import model.entities.OrderItem;
import model.entities.Product;
import model.enums.OrderStatus;

import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		System.out.println("Enter client data:");
		
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("Email: ");
		String email = sc.nextLine(); 
		
		System.out.print("Birthdate (DD/MM/YYYY): ");
		String inputDate = sc.nextLine();
		LocalDate birthDate = LocalDate.parse(inputDate, fmt);
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(status,client);
		
		System.out.print(" How many items to this order?");
		int n = sc.nextInt();
		sc.nextLine();
		for(int i = 1; i <= n; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double price = sc.nextDouble();
			
			Product product = new Product(productName, price);
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			sc.nextLine();
			
			OrderItem orderItem = new OrderItem(quantity,price, product);
			
			order.addItem(orderItem);
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		sc.close();
	}

}
