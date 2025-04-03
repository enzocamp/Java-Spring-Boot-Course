package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PayPalService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre os dados do contrato: ");
		
		System.out.print("Numero: ");
		Integer numberContract = sc.nextInt();
		
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate dateContract = LocalDate.parse(sc.next(),fmt);
		
		System.out.print("Valor do contrato: ");
		Double contractValue = sc.nextDouble();
		
		System.out.print("Entre com o numero de parcelas: ");
		int months = sc.nextInt();
		
		Contract contract = new Contract(numberContract, dateContract, contractValue);
		
		ContractService contractService = new ContractService(new PayPalService());
		
		contractService.processContract(contract, months);
		
		System.out.println();
		System.out.println("Parcelas:");

		for(Installment installment : contract.getInstallment()) {
			System.out.println(installment.getDueDate() + " - " + String.format("%.2f", installment.getAmount()));
		}
		
		sc.close();
		
	}

}
