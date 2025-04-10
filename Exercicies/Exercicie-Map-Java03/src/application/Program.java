package application;

import java.util.HashMap;
import java.util.Map;

public class Program {

	public static void main(String[] args) {
		
		//Write a Java program to remove all mappings from a map.
		
		Map<Integer, Double> mapOne = new HashMap<>();

		mapOne.put(1, 10.00);
		mapOne.put(2, 15.00);
		mapOne.put(50, 264.10);
		mapOne.put(5569, 1511.55);
		
		mapOne.forEach((key, value) -> {
			System.out.println("Before removing " + key + " " + value);
		});

		
		mapOne.clear();
			 
		
		
		if(mapOne.isEmpty() == true) {
			System.out.println("After removing is 0 " + mapOne);
		}
	}

}
