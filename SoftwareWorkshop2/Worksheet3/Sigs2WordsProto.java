import predictive.*;

public class Sigs2WordsProto {
	public static void main(String[] args) {
		for (String sig: args) {
			System.out.print(sig + ": ");
			System.out.println(PredictivePrototype.signatureToWords(sig));
		}
	}
}
