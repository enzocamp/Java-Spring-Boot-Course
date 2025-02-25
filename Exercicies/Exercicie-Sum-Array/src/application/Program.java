// Faça um programa que leia N números reais e armazene-os em um vetor. Em seguida:
// Imprimir todos os elementos do vetor 
// Mostrar na tela a soma e a média dos elementos do vetor

package application;

import java.util.Scanner;
import java.util.Locale;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		System.out.print("Quantos numeros voce vai digitar? ");
		int number = sc.nextInt();
		
		double[] vect = new double[number];
		
		for(int i =0; i < vect.length; i++) {
			System.out.print("Digite um numero: ");
			vect[i] = sc.nextDouble();
		}
		
		double sum = 0;
		
		System.out.print("VALORES = ");
		for(int i =0; i < vect.length; i++) {
			System.out.print(vect[i] + " ");
			sum += vect[i];
		}
		
		System.out.println();
		System.out.println("SOMA = " + sum);
		System.out.println("MÉDIA = " + sum / vect.length);
		
		sc.close();
		
	}

}
