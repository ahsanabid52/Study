package home.practice.basics.generics;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>> {

	String name;
	int won = 0;
	int played = 0;
	int lost = 0;
	int tied = 0;

	ArrayList<T> players = new ArrayList<>();

	public Team(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public ArrayList<T> getPlayers() {
		return players;
	}

	public boolean addPlayer(T p) {
		if (players.contains(p)) {
			System.out.println("Player is already in the team " + name + " Player Name: " + p.getName());
			return false;
		} else {
			players.add(p);
			System.out.println("Player is added in the team " + name + " Player Name: " + p.getName());
			return true;
		}
	}

	public int getNumOfPlayers() {
		return players.size();
	}

	public void matchResult(Team<T> opponent, int ourScore, int theirScore) {
		String message;
		if (ourScore > theirScore) {
			message = " won ";
			won++;
		} else if (ourScore < theirScore) {
			message = " lost ";
			lost++;
		} else {
			message = " drew ";
			tied++;
		}
		played++;
		if (opponent != null) {
			System.out.println(this.getName() + message + "from " + opponent.getName());
			opponent.matchResult(null, theirScore, ourScore);
		}
	}

	public int ranking() {
		return (won * 2) + tied;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Team [name=");
		builder.append(name);
		builder.append(", won=");
		builder.append(won);
		builder.append(", played=");
		builder.append(played);
		builder.append(", lost=");
		builder.append(lost);
		builder.append(", tied=");
		builder.append(tied);
		builder.append(", players=");
		builder.append(players);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Team<T> o) {
		if (this.ranking() > o.ranking()) {
			return 1;
		} else if (this.ranking() < o.ranking()) {
			return -1;
		}
		return 0;
	}
}