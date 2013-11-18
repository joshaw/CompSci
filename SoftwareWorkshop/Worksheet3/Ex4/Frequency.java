/** Counts the number of letters in a file and the occurances of each letter to
 * give a relative frequency of each letter. First the file is converted to
 * lowercase and all non-letters are removed.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 3
 * Exercise  : 4
 * File name : Frequency.java
 * @version 2013-11-15
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* Import the "frequency" package which contains the bubble sort superclass and
 * subclass and the transcribe class for sorting the final array, and
 * converting the file to lower case respectively. */
import frequency.*;

public class Frequency {

	/** Method to perform frequency alalysis on the file "filename"
	 *
	 * @param filename the name of the file to count letters in
	 * @param sort boolean value which specifies whether the output information
	 * should be sorted by frequency or not. The subclass BubbleLinkedArrays of
	 * the superclass Bubble is used to sort the array of frequencies and the
	 * array of letters.
	 * @return an array containing the relative frequencies of the lowercase
	 * letters in the file "filename".
	 */
	public static double[] countLetters(String filename, boolean sort) {

		int[] countArray = new int[26];
		double[] frequencyArray = new double[26];
		double[] sortedFrequencyArray = new double[26];
		int totalCount = 0;

		String ext = filename.split("\\.(?=[^\\.]+$)")[1];
		String name = filename.split("\\.(?=[^\\.]+$)")[0];
		String frequencyFile = name + Transcribe.getAppendedString() +"."+ ext;

		Transcribe.transcribe(filename);

		try {

			BufferedReader br =
				new BufferedReader(new FileReader(frequencyFile));
			String line;

			while ((line = br.readLine()) != null) {

				String newString = "";
				for (int i = 0; i < line.length(); i++) {
					for (int j = 0; j < 26; j++) {
						if (line.charAt(i) == Transcribe.LOWERS[j]) {
							countArray[j]++;
							totalCount++;
						}
					}
				}
			}

			br.close();

			int[] sortedCountArray;
			char[] sortedLOWERS;
			if (sort) {

				BubbleLinkedArrays c =
					new BubbleLinkedArrays(countArray, Transcribe.LOWERS);

				sortedCountArray = c.sort(false);
				sortedLOWERS = c.getArray2();
			} else {
				sortedCountArray = countArray;
				sortedLOWERS = Transcribe.LOWERS;
			}

			for (int i = 0; i < 26; i++) {
				frequencyArray[i] = countArray[i] / (totalCount * 1.0);

				sortedFrequencyArray[i] =
					sortedCountArray[i] / (totalCount * 1.0);

				System.out.printf("%s -> %.4f  ",
						sortedLOWERS[i], sortedFrequencyArray[i]);

				for (int j = 0; j < (int)(frequencyArray[i]*500); j++) {
					System.out.print("-");
				}
				System.out.println();
			}

		} catch(IOException e){
			System.err.println("Could not read from file. Exiting");
		}

		return frequencyArray;

	}

	/** Method to perform frequency alalysis on the file "filename" with a
	 * default sorting setting of false.
	 * @param filename the name of the file to count letters in
	 * @return an array containing the relative frequencies of the lowercase
	 * letters in the file "filename".
	 */
	public static double[] countLetters(String filename) {
		return countLetters(filename, false);
	}

}
