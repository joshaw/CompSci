/* * * * * * * * * * * * * * * * * * * * * *
 * Copy of Transcribe.java from Exerice 3  *
 * * * * * * * * * * * * * * * * * * * * * */

/** Class for converting all the characters in a file that are upper case to
 * lower case and removing anything that is not a lowercase letter, a space or
 * a newline character from the file.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 3
 * Exercise  : 3
 * File name : Transcribe.java
 * @version 2013-11-14
 */
package frequency;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Transcribe {

	private static final String NL = System.getProperty("line.separator");

	/* Arrays for each of the sets of characters to be recognised. LOWERS is
	 * defined as public so that it can be reused outside the class. */
	private static final char[] CAPITALS = {'A','B','C','D','E','F','G','H','I',
		'J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	public static final char[] LOWERS = {'a','b','c','d','e','f','g','h','i',
		'j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	public static final String appendedString = "_lower";

	/** Converts a file to lowercase, removing any characters that are not
	 * lowercase letters, spaces or newline characters.
	 *
	 * @param filename the file to be converted, can either be relative to the
	 * current location, or an absolute path.
	 * @param overwrite if true, and the file to be written already exists,
	 * then it shall be overwritten.
	 * @return a boolean succeed/fail value.
	 */
	public static boolean transcribe(String filename, boolean overwrite) {

		try {

			// Read from the file provided
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line;

			/* The new file shall have the same name as the old with a suffix
			 * appended so as to not overwrite the original. If this file does
			 * not exist, it is created so it can be written to. */
			File file = new File(filename + appendedString);
			if (!file.exists()) {
				file.createNewFile();
				overwrite = true;
			}

			/* If "overwrite" is true, then the file is written since either it
			 * has just been created, or an existing file of the same name
			 * should be ignored. */
			if (overwrite) {
				BufferedWriter bw = new BufferedWriter(
						new FileWriter(file.getAbsoluteFile()));
				while ((line = br.readLine()) != null) {

					String newString = "";

					/* For each character in the current line of the file,
					 * perform the toLower method on it and add it to the
					 * temporary string to be written to the new file. */
					for (int i = 0; i < line.length(); i++) {
						newString += toLower(line.charAt(i));
					}
					bw.write(newString + NL);
				}

				// Close the read and write files.
				br.close();
				bw.close();

				return true;
			}

			/* An error is thrown if the overwrite flag was not set and the
			 * file already existed. */
			throw new IOException("File exists, not overwriting.");

		} catch(IOException e){
			System.err.println(e.getMessage());
			return false;
		}
	}

	public static boolean transcribe(String filename){
		return transcribe(filename, true);
	}

	/** Function that converts the given character to lower case if it is upper
	 * case, otherwise just returns without chaning it.
	 * @param letter a character to convert to lower case
	 * @return letter converted to lowercase if in uppercase, else letter as
	 * given
	 */
	private static char toLower(char letter){

		/* For each of the letters in the capitals array, check if the given
		 * letter is a match. If it is, then reutrn the corresponding lowercase
		 * letter. If the letter is not a CAPITAL and is a space or newline
		 * char, then no change is made. */
		if (letter == ' ' || letter == '\n') {
			return letter;
		} else {
			for (int i = 0; i < 26; i++) {
				if (letter == LOWERS[i]){
					return letter;
				} else if (letter == CAPITALS[i]) {
					letter = LOWERS[i];
					return letter;
				}
			}
		}

		/* If the letter is none of CAPITALS, LOWERS, space or newline, then
		 * the null character is returned, since some character has to be
		 * provided, effectively removing it from the file. */
		return '\0';
	}

	/** Returns the string that is used as a suffix to separate the original
	 * and the newly written files.
	 *
	 * @return the string appended to the filename in order to create a unique
	 * filename for creation.
	 */
	public static String getAppendedString() {
		return appendedString;
	}
}
