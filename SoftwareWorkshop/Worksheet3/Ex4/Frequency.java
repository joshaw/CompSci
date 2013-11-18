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

		/* The new file shall have the same name as the old with a suffix
		 * appended so as to not overwrite the original. If this file does not
		 * exist, it is created so it can be written to. The file extension is
		 * maintained by splitting at the "." which is followed by a no other
		 * "."'s and then the end of the string. */
		String ext = filename.split("\\.(?=[^\\.]+$)")[1];
		String name = filename.split("\\.(?=[^\\.]+$)")[0];
		String frequencyFile = name + Transcribe.getAppendedString() +"."+ ext;

		/* Convert the file to lowercase using the transcribe method from the
		 * Transcribe class so that uppercase and lowercase letters are
		 * recognised as the same letter. */
		Transcribe.transcribe(filename, true);

		try {

			/* The file that shall be analysed is the file that is created by
			 * the transcribe method run above. */
			BufferedReader br =
				new BufferedReader(new FileReader(frequencyFile));
			String line;

			/* While a line can be read in from the file, ie we are not at the
			 * end of the file. */
			while ((line = br.readLine()) != null) {

				/* For each line in the lowercase file, read a line and check
				 * each character in the line against the lowercase letters. If
				 * a match is found, increment the count for that letter
				 * and for the total letters and exit the letter loop. */
				String newString = "";
			/* If the sort flag is true, sort the array of letter counts and the
			 * array of letters. */
				for (int i = 0; i < line.length(); i++) {
					for (int letter = 0; letter < 26; letter++) {
						if (line.charAt(i) == Transcribe.LOWERS[letter]) {
							countArray[letter]++;
							totalCount++;
							break;
						}
					}
				}
			}
			br.close();

			/* If the sort flag is true, sort the array of letter counts and
			 * the array of letters. */
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

			/* For each of the letters, calculate a frequency using the count
			 * of that letter and the total count of all letters. Using a
			 * scaling factor, print a graph of the relative frequencies. */
			for (int i = 0; i < 26; i++) {
				frequencyArray[i] = countArray[i] / (totalCount * 1.0);

				sortedFrequencyArray[i] =
					sortedCountArray[i] / (totalCount * 1.0);

				System.out.printf("%s -> %.4f  ",
						sortedLOWERS[i], sortedFrequencyArray[i]);

				/* Print a rudimentary graph to show, graphically, the relative
				 * frequencies of the letters in the file. */
				for (int j = 0; j < (int)(frequencyArray[i]*500); j++) {
					System.out.print("-");
				}
				System.out.println();
			}

		} catch(IOException e){

			/* If the transcribe method failed for some reason and the file was
			 * not created or written, then the file will not be found, throw
			 * an error in this case. */
			System.err.println("Could not read from file " +
					frequencyFile + ". Exiting");
		}

		/* The array of frequencies is returned for testing, */
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
