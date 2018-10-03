package home.practice.basics.inheritence.challenge;

public class SportsCar extends Car {

	int nos;

	public SportsCar(String model, String engine, String color, int speed, int wheels, int doors, int gear, int nos) {
		super(model, engine, color, speed, wheels, doors, gear);
		this.nos = nos;
		System.out.println("SportsCar");
	}

	public void applyNos() {
		System.out.println("Applying nos");
		incrementSpeed();
	}
}