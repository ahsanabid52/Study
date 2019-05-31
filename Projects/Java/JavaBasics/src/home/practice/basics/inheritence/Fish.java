package home.practice.basics.inheritence;

@SuppressWarnings("unused")
public class Fish extends Animal {

	int eyes;

	int fins;

	int gills;

	public Fish(int size, int weight, String name, int eyes, int fins, int gills) {
		super(1, 1, size, weight, name);
		this.eyes = eyes;
		this.fins = fins;
		this.gills = gills;
	}

	private void rest() {

	}

	private void moveFins() {

	}

	private void moveMuscles() {

	}

	private void swim(int speed) {
		moveMuscles();
		moveFins();
		super.move(speed);
	}
}