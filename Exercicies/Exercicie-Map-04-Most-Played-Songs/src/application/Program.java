package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {

	public static void main(String[] args) {
		/*Durante o ano um usuário do Spotify vai ouvindo músicas. Tendo em mãos a lista de musicas que ele escutou durante o ano,
		 *  organize a visualização pela quantidade de vezes que uma musica foi tocada.*/
		
		Map<String, Integer> songs = new HashMap<>();
		
		String filePath = "C:\\Users\\EnzoF\\OneDrive\\Documentos\\Documento-Pessoal\\Desenvolvimento\\Java\\Curso-JavaSpringBoot\\Tasks\\Exercicies\\Exercicie-Map-04-Most-Played-Songs\\src\\files\\musicas_reais.csv";
		
		int sizeOfFile = 0;
		
		try(BufferedReader bw = new BufferedReader(new FileReader(filePath))){
			String line = bw.readLine();
			sizeOfFile++;
			while(line != null) {
				String[] fields = line.split(" ");
				String name = fields[0];
								
				if(!songs.containsKey(name))
					songs.put(name, 1);
				else {
					songs.put(name, songs.get(name) + 1);
				}
				
				line = bw.readLine();
				sizeOfFile++;
			}
			
			
		}
		catch(IOException e) {
			System.out.println("Error reading the file: " + e.getMessage());
		}

		songs.entrySet()
        .stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
        .forEach(entry -> 
            System.out.println(entry.getKey() + ": " + entry.getValue()));
	}
	
}
