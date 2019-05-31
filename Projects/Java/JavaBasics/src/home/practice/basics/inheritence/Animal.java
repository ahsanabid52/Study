package home.practice.basics.inheritence;

public class Animal {

	int brain;
	int body;
	int size;
	int weight;
	String name;

	public Animal() {
	}

	public Animal(int brain, int body, int size, int weight, String name) {
		super();
		this.brain = brain;
		this.body = body;
		this.size = size;
		this.weight = weight;
		this.name = name;
	}

	public void eat() {
		System.out.println("Animal.eat()");
	}

	public void move(int speed) {
		System.out.println("Animal.move() : " + speed);
	}

	public int getBrain() {
		return brain;
	}

	public void setBrain(int brain) {
		this.brain = brain;
	}

	public int getBody() {
		return body;
	}

	public void setBody(int body) {
		this.body = body;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Animal [brain=");
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

	public void move() {
		// TODO Auto-generated method stub
		
	}

}