package entities;

public class Pessoa {

	private String name;
	private int age;
	private double high;
	
	public Pessoa(String name, int age, double high) {
		super();
		this.name = name;
		this.age = age;
		this.high = high;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}
	
	
	
	
}
