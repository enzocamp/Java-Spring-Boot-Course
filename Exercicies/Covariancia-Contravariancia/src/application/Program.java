package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import entities.Product;

public class Program {
	public static void main(String[] args) {
		
		Set<Product> set = new HashSet<>();
		 set.add(new Product("TV", 900.0));
		 set.add(new Product("Notebook", 1200.0));
		 set.add(new Product("Tablet", 400.0));
		 Product prod = new Product("Notebook", 1200.0);
		 System.out.println(set.contains(prod));

		List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
		List<Double> myDoubles = Arrays.asList(3.14, 6.28);
		List<Object> myObjs = new ArrayList<Object>();

		copy(myInts, myObjs);
		printList(myObjs);
		copy(myDoubles, myObjs);
		printList(myObjs);
	}

	public static void copy(List<? extends Number> source, List<? super Number> destiny) {
		for (Number number : source) {
			destiny.add(number);
		}
	}

	public static void printList(List<?> list) {
		for (Object obj : list) {
			System.out.print(obj + " ");
		}
		System.out.println();
	}
}

/*
 * // Contravariância
 * 
 * List<Object> myObjs = new ArrayList<Object>(); myObjs.add("Maria");
 * myObjs.add("Alex"); myObjs.add(15);
 * 
 * List<? super Number> myNums = myObjs; myNums.add(10); myNums.add(3.14);
 * 
 * // Number x = myNums.get(0); Não é possivel acessar pois como é aceitavel o
 * super tipo de number, possa ser que o objeto gravado não seja um Number
 */
