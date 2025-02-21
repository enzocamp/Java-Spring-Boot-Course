package application;

import java.util.Locale;
import java.util.Scanner;
import util.CurrencyConverter;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Locale.setDefault(Locale.US);
		
		System.out.print("What is the dollar price:  ");
		double dollarPrice = sc.nextDouble();
		System.out.print("How many dollars will be bought?: ");
		double quantity = sc.nextDouble();
		
		System.out.println(CurrencyConverter.conversion(dollarPrice, quantity));
		
		
		sc.close();
	}

}
