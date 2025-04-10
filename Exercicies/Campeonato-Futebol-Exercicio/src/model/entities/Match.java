package model.entities;

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

    public String getWinner() {
        if (goalsA > goalsB) {
        	clubA.setScore(3);
        	clubB.setScore(0);
        	return clubA.getName();
        }
        else if (goalsB > goalsA) {
        	clubB.setScore(3);
        	clubA.setScore(0);
        	return clubB.getName();
        }
        else {
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

            if (teamA.equals(teamB)) continue;

            Set<String> matchKey = teamA.getName().compareTo(teamB.getName()) < 0 ?
                    Set.of(teamA.getName(), teamB.getName()) :
                    Set.of(teamB.getName(), teamA.getName());

            if (matchKeys.contains(matchKey)) continue;
            
            if (matchKeys.stream().flatMap(Set::stream)
            	    .anyMatch(name -> name.equals(teamA.getName()) || name.equals(teamB.getName())))
            continue;
            
            matchKeys.add(matchKey);
            matches.add(new Match(teamA, teamB));
        }

        return matches;
    }
}

