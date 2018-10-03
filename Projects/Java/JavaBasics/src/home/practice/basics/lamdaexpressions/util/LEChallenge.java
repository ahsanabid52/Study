package home.practice.basics.lamdaexpressions.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;

public class LEChallenge {

	public static void main(String[] args) {

		/* Challenge 1 */
		new Thread(() -> {
			String myString = "This is my string.";
			String[] split = myString.split(" ");
			for (String string : split) {
				// System.out.println(string);
			}
		}).start();

		/* Challenge 2 */
		/*
		 * Use a function in order to make a function of a lambda which gets something
		 * in input and returns something in the output.
		 */
		Function<String, String> lambdaFunction = (String s) -> {
			StringBuilder stringBuilder = new StringBuilder();
			for (int i = 0; i < s.length(); i++) {
				if (i % 2 == 0) {
					stringBuilder.append(s.charAt(i));
				}
			}
			return stringBuilder.toString();
		};
		/* Challenge 3 */
		// System.out.println(lambdaFunction.apply("abcdefghijklmnopqrstuvwxyz"));

		/* Challenge 4 & 5 */
		System.out.println(callFunction("1234567890", lambdaFunction));

		/* Challenge 6 */
		Supplier<String> iLoveJava = () -> "ILOVEJAVA";
		/* Challenge 7 */
		String supplierResult = iLoveJava.get();
		System.out.println(supplierResult);

		/* Challenge 8 */
		/*
		 * If the interface is a functional interface we can map a lambda expression to
		 * it otherwise no. There should be only one method that needs the
		 * implementation in that interface.
		 */
		/* Callable */
		/*
		 * Yes it can be used as it has only one method furthermore its being annotated
		 * by the @FunctionalInterface.
		 */
		/* Comparator */
		/*
		 * Yes it can be used as it has only one method furthermore its being annotated
		 * by the @FunctionalInterface.
		 */

		/* Challenge 9 & 10 */

		Function<String, String> toUpperCase = (String s) -> s = s.substring(0, 1).toUpperCase() + s.substring(1);

		List<String> top5Name = Arrays.asList("ahsan", "ali", "hassan", "salman", "mohammad", "fatima", "ayesha",
				"sana", "rabia", "maira");
		List<String> upperCased = new ArrayList<>();

		for (String string : top5Name) {
			upperCased.add(toUpperCase.apply(string));
		}
		System.out.println("####################################");
		// Without streams
		upperCased.sort(String::compareTo);
		upperCased.forEach(System.out::println);
		// With Streams
		// upperCased.stream().sorted().forEach(System.out::println);

		/* Challenge 11 */
		System.out.println("####################################");
		System.out.println("Challenge 11");
		top5Name.stream().map(s -> s = s.substring(0, 1).toUpperCase() + s.substring(1)).sorted()
				.forEach(System.out::println);

		System.out.println("####################################");
		System.out.println("Challenge 12");
		System.out.println("Number of names starting with A is : "
				+ top5Name.stream().filter(name -> name.startsWith("a")).count());
		System.out.println("####################################");
		System.out.println("Challenge 13");
		System.out.println("Number of names starting with A is : "
				+ top5Name.stream().map(s -> s = s.substring(0, 1).toUpperCase() + s.substring(1))
						.peek(System.out::println).sorted(String::compareTo));
		// this code does not contain a terminal expression and thats why stream will
		// not be evaluated as java streams are lazily loaded.
		// they are not evaluated until there is a terminal operation at the end.
		System.out.println("####################################");
		System.out.println("Challenge 14");
		System.out.println(
				"Names Are : " + top5Name.stream().map(s -> s = s.substring(0, 1).toUpperCase() + s.substring(1))
						.peek(System.out::println).sorted(String::compareTo).count());

	}

	private static String callFunction(String input, Function<String, String> lambdaFunction) {
		return lambdaFunction.apply(input);
	}

}