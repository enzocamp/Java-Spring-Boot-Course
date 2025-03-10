package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.Employee;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many employees will be registered?: ");
		Locale.setDefault(Locale.US);
		sc.useLocale(Locale.US);
		Integer empNumber = sc.nextInt();
		
		List<Employee> employees = new ArrayList<>();	
		
		for(int i = 1; i <= empNumber; i++)
		{
			System.out.println("Employee" + i + "º: ");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			while (hasId(employees, id)) {
				System.out.println("Id already taken");
				id = sc.nextInt();
			}
			System.out.print("Name: ");
			sc.nextLine(); //limpando o buffer
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			
			employees.add(new Employee(id, name, salary));
			
		}
		
		System.out.print("Enter the employee id that will have salary increase: ");
		int id = sc.nextInt();
		
		
		Employee emp = employees.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		
		if (hasId(employees, id) != true) {
			System.out.println("This id does not exist");
		}
		else {
			System.out.print("Enter the percentage: ");
			double percent = sc.nextDouble();
			emp.increaseSalary(percent);
		}
		
		System.out.println();
		System.out.println("List of employees:");

		for(Employee e : employees) {
			System.out.println(e);
		}
		sc.close();

	}
	
	public static boolean hasId(List<Employee> employees, int id) {
		Employee emp = employees.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

}
