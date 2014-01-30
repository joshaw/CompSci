public class PredictivePrototype {

	public static String wordtoSignature(String word) {
		String sig = "";
		String letter = "";
		for (int i = 0; i < word.length(); i++) {
			letter = Character.toString(word.charAt(i));
			if (letter.matches("[a-c]")) {
				sig += "2";
			} else if (letter.matches("[d-f]")) {
				sig += "3";
			} else if (letter.matches("[g-i]")) {
				sig += "4";
			} else if (letter.matches("[j-l]")) {
				sig += "5";
			} else if (letter.matches("[m-o]")) {
				sig += "6";
			} else if (letter.matches("[p-s]")) {
				sig += "7";
			} else if (letter.matches("[t-v]")) {
				sig += "8";
			} else if (letter.matches("[w-z]")) {
				sig += "9";
			}
		}
		return sig;
	}

}
