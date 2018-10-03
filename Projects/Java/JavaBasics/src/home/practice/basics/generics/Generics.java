package home.practice.basics.generics;

import java.util.ArrayList;

public class Generics {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);

		printElement(arrayList);
	}

	private static void printElement(ArrayList<Integer> arrayList) {
		for (int i : arrayList) {
			System.out.println(i);
		}
	}
}