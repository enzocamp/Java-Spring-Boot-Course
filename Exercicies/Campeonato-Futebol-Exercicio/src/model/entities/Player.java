package model.entities;

public class Player {

	private String name;
	private Integer goals;
	private Club club;
	
	public Player(String name, Integer goals) {
		this.name = name;
		this.goals = goals;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGoals() {
		return goals;
	}

	public void setGoals(Integer goals) {
		this.goals = goals;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	
	
}
