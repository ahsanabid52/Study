package home.practice.basics.generics;

public class Main {

	public static void main(String[] args) {

		FootballPlayer fp = new FootballPlayer("Kaka");
		FootballPlayer fp1 = new FootballPlayer("Tim");
		BaseballPlayer bp = new BaseballPlayer("Michael");

		Team<FootballPlayer> milan = new Team<>("Milan");
		milan.addPlayer(fp);

		System.out.println("Number of players: " + milan.getNumOfPlayers());

		Team<BaseballPlayer> chicagoCubs = new Team<>("ChicagoCubs");
		chicagoCubs.addPlayer(bp);

		Team<FootballPlayer> laGalaxy = new Team<>("LaGalaxy");
		laGalaxy.addPlayer(fp1);

		milan.matchResult(laGalaxy, 5, 2);
		laGalaxy.matchResult(milan, 3, 4);

//		System.out.println(milan.compareTo(laGalaxy)?"Milan is higher in the ranking.":"LaGalaxy is higher in the ranking.");
		
	}
}