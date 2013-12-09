/** Class to hold the information representing a patient. Implements the
 * Measurable interface to return some measure.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 5
 * Exercise  : 1
 * File name : Patient.java
 * @version 2013-12-08
 */
public class Patient implements Measurable {

	private String name;
	private int age;
	private double weight;

	/** Create an instance of a Patient
	 *
	 * @param name name of the patient
	 * @param age the age of the patient
	 * @param weight the weight of the patient
	 */
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

	/** Use the interface method to return the weight
	 *
	 * @return the weight stored with the patient
	 */
	public double getMeasure() {
		return weight;
	}

}
