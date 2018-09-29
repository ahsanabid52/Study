package home.practice.basics.inheritence;

public class Main {

	public static void main(String[] args) {

		Dog gSheperd = new Dog(1, 1, "GermanSheperd", 2, 4, 1, 32, "Long Coat");

		// gSheperd.eat();
		// gSheperd.walk();
		// gSheperd.run();

		gSheperd.walk();
		System.out.println("##############");
		gSheperd.run();

	}

}
