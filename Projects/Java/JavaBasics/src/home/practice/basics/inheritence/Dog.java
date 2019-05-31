package home.practice.basics.inheritence;

public class Dog extends Animal {

	int eyes;
	int legs;
	int tails;
	int teeth;
	String coat;

	public Dog() {
		super();
	}

	public Dog(int size, int weight, String name, int eyes, int legs, int tails, int teeth, String coat) {
		super(1, 1, size, weight, name);
		this.eyes = eyes;
		this.legs = legs;
		this.tails = tails;
		this.teeth = teeth;
		this.coat = coat;
	}
	
	public void chew() {
		System.out.println("Dog.chew()");
	}
	
	@Override
	public void eat() {
		System.out.println("Dog.eat()");
		chew();
		super.eat();
	}
	
	public void walk() {
		System.out.println("Dog.walk()");
		super.move(1);
	}
	
	public void run() {
		System.out.println("Dog.run()");
		move(10);
	}
	
	@Override
	public void move(int speed) {
		System.out.println("Dog.move()");
		moveLegs();
		super.move(speed);
	}
	
	public void moveLegs() {
		System.out.println("Dog.moveLegs()");
		
	}

	public int getEyes() {
		return eyes;
	}

	public void setEyes(int eyes) {
		this.eyes = eyes;
	}

	public int getLegs() {
		return legs;
	}

	public void setLegs(int legs) {
		this.legs = legs;
	}

	public int getTails() {
		return tails;
	}

	public void setTails(int tails) {
		this.tails = tails;
	}

	public int getTeeth() {
		return teeth;
	}

	public void setTeeth(int teeth) {
		this.teeth = teeth;
	}

	public String getCoat() {
		return coat;
	}

	public void setCoat(String coat) {
		this.coat = coat;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dog [eyes=");
		builder.append(eyes);
		builder.append(", legs=");
		builder.append(legs);
		builder.append(", tails=");
		builder.append(tails);
		builder.append(", teeth=");
		builder.append(teeth);
		builder.append(", coat=");
		builder.append(coat);
		builder.append(", brain=");
		builder.append(brain);
		builder.append(", body=");
		builder.append(body);
		builder.append(", size=");
		builder.append(size);
		builder.append(", weight=");
		builder.append(weight);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

}
