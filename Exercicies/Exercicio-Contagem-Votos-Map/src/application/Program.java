package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import model.entities.Candidate;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a file path: ");
		String sourceFileStr = sc.nextLine();
		
		Map<String, Integer> candidateVotes = new HashMap<>(); 
		
		try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))){
			
			String itemCsv = br.readLine();

			    while (itemCsv != null) {
				
				String[] fields = itemCsv.split(",");
				String name = fields[0];
				Integer vote = Integer.parseInt(fields[1]);
				
				Candidate candidate = new Candidate(name, vote);
				
				if(!candidateVotes.containsKey(name)) {
				
					candidateVotes.put(candidate.getName(), candidate.getVotes());
				}
				else {
					vote += candidateVotes.get(candidate.getName());
					candidateVotes.put(candidate.getName(), vote);
				}
				itemCsv = br.readLine();
			}
		}
		catch (IOException e){
			System.out.println("Error writing file: " + e.getMessage());
			e.printStackTrace();
		}

		candidateVotes.forEach((name, votes) -> {
			System.out.println(String.format("%s %d", name, votes));
		});
		
		
		sc.close();
	}
}
