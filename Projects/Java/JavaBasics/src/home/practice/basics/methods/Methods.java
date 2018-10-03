package home.practice.basics.methods;

public class Methods {

	public static void main(String[] args) {
		/* Methods */
		int calculatedScore = calculateScore(true, 8000, 200, 100);
		System.out.println("The calculated score is :- " + calculatedScore);

		calculatedScore = calculateScore(8000, 200, 100);
		System.out.println("The calculated score withing game is :- " + calculatedScore);

	}

	/* Overloaded Method */
	public static int calculateScore(boolean gameover, int score, int levelCompleted, int bonus) {
		int finalScore = -1;
		if (gameover) {
			finalScore = score + (levelCompleted * bonus);
		}
		return finalScore;
	}

	/* Overloaded Method */
	public static int calculateScore(int score, int levelCompleted, int bonus) {
		int finalScore = -1;

		finalScore = score + (levelCompleted * bonus);
		return finalScore;
	}

	/* Overloaded Method */
	public static void calculateScore() {
		System.out.println("No player no score void");
	}

	/* Overloaded Method */
	/*
	 * The below method is not allowed as java does not overloads on the basis of
	 * the return type;
	 */
	/*
	 * public static int calculateScore() {
	 * System.out.println("No player no score int"); }
	 */
}