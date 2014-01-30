package predictive;

public class WordSig implements Comparable<WordSig> {

	private String word;
	private String signature;

	public WordSig(String word, String signature) {
		this.word = word;
		this.signature = signature;
	}

	public int compareTo(WordSig ws) {
		int sig = Integer.parseInt(signature);
		int wsSig = Integer.parseInt(ws.signature);
		if (sig < wsSig) return -1;
		if (sig > wsSig) return 1;
		return 0;
	}

}
