package home.practice.basics.keywordsandexpressions;

public class KeyWordsAndExpressions {
	public static void main(String[] args) {
		/* Expressions */

		String str = "This is a sample string.";
		System.out.println(str);
		/*
		 * The number of expressions in the above piece of code is two.
		 */
		/* str = "This is a sample string." */
		/* str */

		/* Code Blocks */

		int score = 10000, levelCompleted = 8, bonus = 200;
		boolean gameover = true;

		if (gameover) {
			int finalScore = score + (levelCompleted * bonus);
			System.out.println("The final score is :- " + finalScore);
		}

	}
}