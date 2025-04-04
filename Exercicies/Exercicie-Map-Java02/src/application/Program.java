package application;

import java.util.HashMap;
import java.util.Map;

public class Program {

	public static void main(String[] args) {
		//Write a Java program to copy all mappings from the specified map to another map.
		
		Map<String, Double> mapOne = new HashMap<>();
		
		mapOne.put("Teste1", 10.00);
		mapOne.put("Teste2", 54.00);
		mapOne.put("Teste3", 3.50);
		
		Map<? super Object, ? super Object> mapTwo = new HashMap<>();
		
		mapTwo.put(1, "now");
		
		mapTwo.putAll(mapOne);
		
		/*mapOne.forEach((key, value) -> {
			mapTwo.put(key, value);
		});*/
		
		System.out.println(mapOne);
		System.out.println(mapTwo);
	}

}
