package predictive;

import java.util.*;

interface Dictionary {
	// String wordToSignature(String word);
	Set<String> signatureToWords(String signature, int upperRange, int lowerRange);
	Set<String> signatureToWords(String signature);
	String getWord(int index);
	String getSignature(int index);

}
