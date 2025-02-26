package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Pessoa;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		System.out.print("Quantas pessoas serao digitadas? ");
		int n = sc.nextInt();
		
		Pessoa[] pessoas = new Pessoa[n];
		
		double sum = 0.0;
		
		for(int i = 0; i < pessoas.length; i++){
			System.out.println("Dados da " + (i + 1) + "ª" + " pessoas: ");
			System.out.print("Nome: ");
			String name = sc.next();
			System.out.print("Idade: ");
			int idade = sc.nextInt();
			System.out.print("Altura: ");
			double altura = sc.nextDouble();
			
			pessoas[i] = new Pessoa(name, idade, altura);
			
			sum += altura;
						
		}
		
		System.out.println();
		System.out.printf("Altura média: %.2f%n", sum / pessoas.length);
		
		
		int count = 0;
	
		for(int i =0; i < pessoas.length; i++) {
			if (pessoas[i].getAge() > 16) {
				count += 1; 
			}
		}
		
		double percent = ((double) count / n) * 100;
		
		System.out.printf("Pessoas com menos de 16 anos: %.1f%%\n", percent);
		
		sc.close();
	}

}
