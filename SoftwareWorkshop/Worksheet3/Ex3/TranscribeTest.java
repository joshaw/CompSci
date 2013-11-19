/** Test class for the Transcribe class which converts a file to lowercase,
 * removing anything that is not a lowercase letter, space or newline
 * character.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 3
 * Exercise  : 3
 * File name : TranscribeTest.java
 * @version 2013-11-19
 */
public class TranscribeTest {
	public static void main(String[] args) {

		String[] filename = {"../testfile.txt",
		                     "../DonQuixote.txt",
		                     "../AliceInWonderland.txt",
		                     "../FileDoesNotExist.txt"};

		/* For each of the named files, transcribe the contents to lower case
		 * and write the results to a new file. */
		for(String file: filename){
			System.out.print("Processing file " + file + "... ");

			if ( Transcribe.transcribe(file, true) ){
				System.out.println("Done");
				System.out.println();
			} else {
				System.out.println("Failed");
				System.out.println();
			}
		}
	}
}
