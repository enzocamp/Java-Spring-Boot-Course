package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.BusinessException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		double initialBalance = sc.nextDouble();
		
		System.out.print("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();
		
		Account account = new Account(number, holder, initialBalance, withdrawLimit);
		
		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		double amount = sc.nextDouble();
		
		try {
			account.withdraw(amount);
			System.out.printf("Novo saldo: %.2f%n", account.getBalance());
		}
		catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}

}
