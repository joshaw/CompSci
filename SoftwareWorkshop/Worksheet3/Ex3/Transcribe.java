import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Transcribe {

	private static final char[] CAPITALS = {'A','B','C','D','E','F','G','H','I',
		'J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	public static final char[] LOWERS = {'a','b','c','d','e','f','g','h','i',
		'j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	public static final String appendedString = "_lower";

	private static final String NL = System.getProperty("line.separator");

	public static void transcribe(String filename) {

		try {

			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line;

			try {

				File file = new File(filename + appendedString);
				if (!file.exists()) {
					file.createNewFile();
				}

				BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
				while ((line = br.readLine()) != null) {

					String newString = "";
					for (int i = 0; i < line.length(); i++) {
						newString += toLower(line.charAt(i));
					}
					bw.write(newString + NL);
				}

				br.close();
				bw.close();

			} catch(IOException e){
				System.out.println("Could not write to file. Exiting");
				System.exit(0);
			}

		} catch(IOException e){
			System.out.println("Could not read from file. Exiting");
			System.exit(0);
		}
	}

	/** Function that converts the given character to lower case if it is upper
	 * case, otherwise just returns without chaning it.
	 * @param letter a character to convert to lower case
	 * @return letter converted to lowercase if in uppercase, else letter as
	 * given
	 */
	private static char toLower(char letter){

		// For each of the letters in the capitals array, check if the given
		// letter is a match.
		for (int i = 0; i < 26; i++) {
			if (letter == CAPITALS[i]) {
				letter = LOWERS[i];
				return letter;
			} else if (letter == LOWERS[i] || letter == ' ' || letter == '\n' || letter == '\r'){
				return letter;
			}
		}
		return '\0';
	}

	public static String getAppendedString() {
		return appendedString;
	}
}
