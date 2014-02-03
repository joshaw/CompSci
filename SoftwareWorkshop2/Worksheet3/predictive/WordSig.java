package predictive;

import java.math.BigInteger;

public class WordSig implements Comparable<WordSig> {

	private String word;
	private String signature;

	public WordSig(String word, String signature) {
		this.word = word;
		this.signature = signature;
	}

	public String getWord() {
		return word;
	}

	public String getSignature() {
		return signature;
	}

	@Override
	public int compareTo(WordSig ws) {
		double sig = Double.parseDouble(signature);
		double wsSig = Double.parseDouble(ws.signature);
		if (sig < wsSig) return -1;
		if (sig > wsSig) return 1;
		return 0;
	}

}
