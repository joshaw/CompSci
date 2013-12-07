public class Patient {

	private String name;
	private int age;
	private double weight;

	public Patient(String name, int age, double weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}

	public double getMeasure() {
		return weight;
	}

}
