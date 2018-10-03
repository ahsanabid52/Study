package home.practice.basics.classes;


public class Car extends Vehicle {

	int wheels;
	int doors;
	String model;
	String engine;
	String color;

	public Car() {
		this(4, 4, "Nissan", "Tida", "White");
		/*
		 * This can be used to call the constructor also but it should be the first
		 * line.
		 */
		System.out.println("Default Constructor after calling overloaded constructor with default values.");
	}

	public Car(int wheels, int doors, String model, String engine, String color) {

		System.out.println("Overloaded Constructor");
		this.wheels = wheels;
		this.doors = doors;
		this.model = model;
		this.engine = engine;
		this.color = color;
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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Car [wheels=");
		builder.append(wheels);
		builder.append(", doors=");
		builder.append(doors);
		builder.append(", model=");
		builder.append(model);
		builder.append(", engine=");
		builder.append(engine);
		builder.append(", color=");
		builder.append(color);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public void move() {
		System.out.println("Car is moving...");

	}

}