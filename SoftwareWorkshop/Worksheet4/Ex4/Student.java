/**
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 4
 * Exercise  : 4
 * File name : Student.java
 * @version 2013-11-24
 */
import java.util.InputMismatchException;
import java.util.ArrayList;

public class Student {

	private int passMark;
	private int mark = 0;
	private String name;

	public Student(String name, int passMark) {
		this.name = name;
		this.passMark = passMark;
	}

	public int finalMark() {
		return mark;
	}

	public boolean hasPassed() {
		if (mark > passMark) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void toString() {
		return name + ": " + mark;
	}

}
