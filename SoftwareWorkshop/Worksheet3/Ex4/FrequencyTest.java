public class FrequencyTest {
	public static void main(String[] args) {
		System.out.println("Don Quixote");
		Frequency.countLetters("DonQuixote.txt");

		System.out.println();
		System.out.println("Alice in Wonderland");
		Frequency.countLetters("AliceInWonderland.txt", true);
	}
}
