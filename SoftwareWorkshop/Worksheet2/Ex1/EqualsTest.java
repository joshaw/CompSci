/** Defines a program to compare two strings and return true if they are equal
 * and false if they differ, irrespective of case.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 2
 * Exercise  : 1
 * @version 2013-11-07
 */
public class EqualsTest {

	static final char[] capitals = {'A','B','C','D','E','F','G','H','I','J',
		'K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	static final char[] lowers = {'a','b','c','d','e','f','g','h','i','j',
		'k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

	/** Function that converts the given character to lower case if it is upper
	 * case, otherwise just returns without chaning it.
	 * @param letter a character to convert to lower case
	 * @return letter converted to lowercase if in uppercase, else letter as
	 * given
	 */
	static char toLower(char letter){

		// For each of the letters in the capitals array, check if the given
		// letter is a match.
		for (int i = 0; i < 26; i++) {
			if (letter == capitals[i]) {
				letter = lowers[i];
				return letter;
			}
		}
		return letter;
	}

	/** Equals function which returns boolean true if the two strings supplied
	 * are the same, irrespective of case, else returns false.
	 * @param str1 first of two strings to compare
	 * @param str2 second of two strings to compare
	 * @return true if the strings are the same, false if they differ.
	 */
	static boolean Equals(String str1, String str2){

		// If the strings are different lengths, they must be different, so no
		// need to check characters.
		if (str1.length() != str2.length()) {
			return false;
		}

		// Character by character, check if the lower case versions are the
		// same. If at any point they differ, return that the string is false -
		// no need to check whole thing.
		for (int i = 0; i < str1.length(); i++) {
			if (toLower(str1.charAt(i)) != toLower(str2.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/** Test function for the Equals method
	 */
	public static void main(String[] args){

		// Use two arguements to the program.
		if (args.length == 2) {
			if(Equals(args[0], args[1])){
				System.out.println("Strings are Equal");
			}else{
				System.out.println("Strings are Different");
			}
		}

		System.out.println(Equals("String","STRING")); // true
		System.out.println(Equals("test","tesT"));     // true
		System.out.println(Equals("test","TEST"));     // true
		System.out.println(Equals("test","TesT"));     // true
		System.out.println(Equals("test","tESt"));     // true
		System.out.println(Equals("test","tes"));      // false
		System.out.println(Equals("test","testS"));    // false
		System.out.println(Equals("test",""));         // false
	}

}
