import java.util.ArrayList;

public class ExamQuestionTest {

	public static void main(String[] args) {

		ExamQuestionNumeric q1 = new ExamQuestionNumeric("2+3 = ?", 3, 5);

		System.out.println(q1.answer(5));
		System.out.println(q1.answer(6));

		ArrayList<String> a = new ArrayList<String>();
		a.add("4");
		a.add("5");
		a.add("10");
		a.add("20");

		ExamQuestionSimpleChoice q2 = new ExamQuestionSimpleChoice("2+3 = ?", 10, a, 2);

		System.out.println(q2.answer(2));
		System.out.println(q2.answer(3));
	}

}
