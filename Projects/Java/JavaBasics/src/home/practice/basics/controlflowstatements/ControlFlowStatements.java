package home.practice.basics.controlflowstatements;

public class ControlFlowStatements {

	public static void main(String[] args) {

		char switchValue = 'K';

		switch (switchValue) {
		case 'A':
			System.out.println("single cases.");
			break;

		case 'B':
			System.out.println("single case.");
			break;

		case 'K':
		case 'P':
		case 'S':
			System.out.println("multiple cases. and value is " + switchValue);
			break;

		default:
			break;
		}

		String currentMonth = "January";

		switch (currentMonth) {
		case "January":
			System.out.println("the current month is january");
			break;

		default:
			System.out.println("the current month is not january");
			break;
		}

		for (int i = 0; i < 10; i++) {
			System.out.println("Loops");
		}

		
		System.out.println(isPrimeNumber(7));
		
		
		
		do {System.out.println("first iteration");}
		while(false);
	}

	@SuppressWarnings("unused")
	public static boolean isPrimeNumber(int n) {
		boolean isPrime = false;

		if (n <= 1) {
			return isPrime;
		}

		for (int i = 2; i < n / 2; i++) {
			if (n % i == 0) {
				return false;
			}
			return true;
		}
		return isPrime;
	}
}
