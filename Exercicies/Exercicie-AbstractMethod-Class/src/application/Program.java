package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of tax payers:");
		int n = sc.nextInt();
		
		List<TaxPayer> taxPayers = new ArrayList<>();
		
		for (int i = 1; i <= n; i++ ) {
			System.out.println("Taxpayer #" + i + " data:");
			System.out.print("Individual or company (i/c)?");
			char c = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			Double income = sc.nextDouble();
			
			if( c == 'i') {
				System.out.print("Health expenditures: ");
				Double healthExpenditures = sc.nextDouble();
				taxPayers.add(new Individual(name, income, healthExpenditures));
			}
			else {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				taxPayers.add(new Company(name, income, numberOfEmployees));
			}
		}
		sc.close();
	
		double totalTax = 0.0;
		
		System.out.println("TAXES PAID:");
		for( TaxPayer payer : taxPayers) {
			System.out.println(payer.getName() + " $ " + String.format("%.2f", payer.tax()));
			totalTax += payer.tax();
		}

		System.out.println("TOTAL TAXES: " +  String.format("%.2f", totalTax));
	}

}
