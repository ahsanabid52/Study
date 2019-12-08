package home.practice.basics.inheritence.challenge;

public class Vehicle {
	String model;
	String engine;
	String color;
	int speed;

	public Vehicle() {
		System.out.println("Vehicle Default Constructor");
	}

	public Vehicle(String model, String engine, String color, int speed) {
		super();
		this.model = model;
		this.engine = engine;
		this.color = color;
		this.speed = speed;
		System.out.println("Vehicle");
	}

	public void move() {
		System.out.println("Vehicle.move()");
	}
	
	public void stop() {
		System.out.println("Vehicle.stop()");
		this.speed = 0;
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vehicle [model=");
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