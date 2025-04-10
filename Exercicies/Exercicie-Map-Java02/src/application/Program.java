package application;

import java.util.HashMap;
import java.util.Map;

public class Program {

	public static void main(String[] args) {
		//Write a Java program to copy all mappings from the specified map to another map.
		
		//Contravariância
		
		Map<String, Double> mapOne = new HashMap<>();
		
		mapOne.put("Teste1", 10.00);
		mapOne.put("Teste2", 54.00);
		mapOne.put("Teste3", 3.50);
		
		Map<? super Object, ? super Object> mapTwo = new HashMap<>();
		
		mapTwo.put(1, "now");
		
		mapTwo.putAll(mapOne);
		
		mapOne.forEach((key, value) -> {
			mapTwo.put(key, value);
		});
		
		System.out.println(mapOne);
		System.out.println(mapTwo);
		
	}
}
		//Covariância
		
		/* Map<String, Double> mapTwo = new HashMap<>();
	        
	        // Passa mapOne para o método que aceita qualquer subtipo de Map
	        copyMap(mapOne, mapTwo);

	        System.out.println(mapOne);
	        System.out.println(mapTwo);
	    }

	    Método genérico com ? extends para leitura segura
	    public static <K, V> void copyMap(Map<? extends K, ? extends V> source, Map<K, V> target) {
	        source.forEach((key, value) -> target.put(key, value));
	    }
	}
		
	}
	*/
