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
