package model.entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Match {

	private Club clubA;
	private Club clubB;
	private int goalsA;
	private int goalsB;
	private static String clubAScalation = "C:\\Users\\EnzoF\\OneDrive\\Documentos\\Documento-Pessoal\\Desenvolvimento\\Java\\Curso-JavaSpringBoot\\Tasks\\Exercicies\\Campeonato-Futebol-Exercicio\\src\\files\\escalacaoTimaA.csv";
	private static String clubBScalation = "C:\\Users\\\\EnzoF\\OneDrive\\Documentos\\Documento-Pessoal\\Desenvolvimento\\Java\\Curso-JavaSpringBoot\\Tasks\\Exercicies\\Campeonato-Futebol-Exercicio\\src\\files\\escalacaoTimaB.csv";

	public Match(Club clubA, Club clubB) {
		this.clubA = clubA;
		this.clubB = clubB;
		simulateMatch();

	}

	public Club getClubA() {
		return clubA;
	}

	public Club getClubB() {
		return clubB;
	}

	public int getGoalsA() {
		return goalsA;
	}

	public int getGoalsB() {
		return goalsB;
	}

	public int getTotalGoals() {
		return goalsA + goalsB;
	}

	public String getClubAScalation() {
		return clubAScalation;
	}

	public String getClubScalation() {
		return clubBScalation;
	}

	public String getWinner() {
		if (goalsA > goalsB) {
			clubA.setScore(3);
			clubB.setScore(0);
			return clubA.getName();
		} else if (goalsB > goalsA) {
			clubB.setScore(3);
			clubA.setScore(0);
			return clubB.getName();
		} else {
			clubA.setScore(1);
			clubB.setScore(1);
			return "empate";
		}
	}

	public void simulateMatch() {

		this.goalsA = ThreadLocalRandom.current().nextInt(0, 6);
		this.goalsB = ThreadLocalRandom.current().nextInt(0, 6);
		clubA.setGoals(goalsA);
		clubB.setGoals(goalsB);

	}

	public String getResult() {
		return clubA.getName() + " " + goalsA + " x " + goalsB + " " + clubB.getName();
		
	}

	public static List<Match> generateRandomMatches(List<Club> clubs, int numberOfMatches) {
		List<Match> matches = new ArrayList<>();
		Set<Set<String>> matchKeys = new HashSet<>();

		while (matches.size() < numberOfMatches) {
			Club teamA = clubs.get(ThreadLocalRandom.current().nextInt(clubs.size()));
			Club teamB = clubs.get(ThreadLocalRandom.current().nextInt(clubs.size()));
			
			if (teamA.equals(teamB))
				continue;

			Set<String> matchKey = teamA.getName().compareTo(teamB.getName()) < 0
					? Set.of(teamA.getName(), teamB.getName())
					: Set.of(teamB.getName(), teamA.getName());

			if (matchKeys.contains(matchKey))
				continue;

			if (matchKeys.stream().flatMap(Set::stream)
					.anyMatch(name -> name.equals(teamA.getName()) || name.equals(teamB.getName())))
				continue;

			teamA.loadPlayersFromCsv(clubAScalation);
			
			teamB.loadPlayersFromCsv(clubBScalation);

			matchKeys.add(matchKey);
			matches.add(new Match(teamA, teamB));
			
		}

		return matches;
	}

	public void writeGoalsToPlayer() {
		//try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePathA))) {
			List<Player> playersSorted = clubA.getPlayers();

			int goalsAdded = 0;

			while(goalsAdded < goalsA) {
				Player player = playersSorted.get(ThreadLocalRandom.current().nextInt(playersSorted.size()));
				if (goalsAdded == goalsA) {
					return;
				}
				//else if(player.getGoals())
				int goalsToAdd = (ThreadLocalRandom.current().nextInt(1, (goalsA - goalsAdded ) + 1 ));
				player.setGoals(player.getGoals() + goalsToAdd);
				goalsAdded += player.getGoals();
			}
		//} catch (IOException e) {
		//	System.out.println("Error putting goals to player in the file " + e.getMessage());
		//}
	}
}
