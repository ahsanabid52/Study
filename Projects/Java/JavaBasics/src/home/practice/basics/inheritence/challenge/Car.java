package home.practice.basics.inheritence.challenge;

public class Car extends Vehicle {

	int wheels;
	int doors;
	int gear;

	public Car(String model, String engine, String color, int speed, int wheels, int doors, int gear) {
		super(model, engine, color, speed);
		this.wheels = wheels;
		this.doors = doors;
		this.gear = gear;
		System.out.println("Car");
	}

	@Override
	public void move() {
		System.out.println("Car is moving...");
	}

	public void incrementSpeed() {
		System.out.println("Increasing speed");
		speed++;
		move();
	}

	public void decrementSpeed() {
		System.out.println("Decreasing speed");
		speed--;
		move();
	}

	public void changeGear(int gear) {
		System.out.println("previous gear was: " + gear);
		this.gear = gear;
		System.out.println("new gear was: " + this.gear);
	}

	public int getWheels() {
		return wheels;
	}

	public void setWheels(int wheels) {
		this.wheels = wheels;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	public int getGear() {
		return gear;
	}

	public void setGear(int gear) {
		this.gear = gear;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Car [wheels=");
		builder.append(wheels);
		builder.append(", doors=");
		builder.append(doors);
		builder.append(", gear=");
		builder.append(gear);
		builder.append(", model=");
		builder.append(model);
		builder.append(", engine=");
		builder.append(engine);
		builder.append(", color=");
		builder.append(color);
		builder.append(", speed=");
		builder.append(speed);
		builder.append("]");
		return builder.toString();
	}

}