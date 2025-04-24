package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the file path: ");
		String path = sc.nextLine();
		
		List<Employee> employees = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			
			while(line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				String email = fields[1];
				Double price = Double.parseDouble(fields[2]);
				
				employees.add(new Employee(name,email,price));
				
				line = br.readLine();
			}
			
			System.out.print("Enter the base salary: ");
			double value = sc.nextDouble();
			
			List<String> emails = employees.stream()
				.filter(p -> p.getSalary() > value)
				.map(p -> p.getEmail())
				.sorted((x,y) -> x.toLowerCase().compareTo(y.toLowerCase()))
				.collect(Collectors.toList());
			
			double sum = employees.stream()
					.filter(p -> p.getName().charAt(0) == 'M')
					.map(p -> p.getSalary())
					.reduce(0.0, (x,y) -> x + y);
			
			System.out.println(String.format("Email of people whose salary is more than: %f", value));
			
			emails.forEach(System.out::println);
			
			
			System.out.println(String.format("Sum of salary of people whose name starts with 'M': %.2f", sum));
			
		}
		catch(IOException e){
			System.out.println("Error: " + e.getMessage());
		}
		
		
		sc.close();
	}

}
