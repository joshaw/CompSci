public class ExamQuestion {

	private String question;
	private int maximalMark;

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}

	public void setMaximalMark(int maximalMark) {
		this.maximalMark = maximalMark;
	}

	public int getMaximalMark() {
		return maximalMark;
	}

	@Override
	public String toString(){
		return question + ", max: " + maximalMark;
	}

}
