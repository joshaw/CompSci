/**  This class is to test the Fraction class and its methods.
 *   We create several objects of class Fraction, print them to the screen and
 *   also print the sum and product of them. Also show the empty constructor.
 */
public class EqualsTest {

	static final char[] capitals = {'A','B','C','D','E','F','G','H','I','J',
		'K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	static final char[] lowers = {'a','b','c','d','e','f','g','h','i','j',
		'k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

	static char toLower(char letter){
		for (int i = 0; i < 26; i++) {
			if (letter == capitals[i]) {
				letter = lowers[i];
				return letter;
			}
		}
		return letter;
	}

	static boolean Equals(String first, String second){

		if (first.length() != second.length()) {
			return false;
		}

		for (int i = 0; i < first.length(); i++) {
			if (toLower(first.charAt(i)) != toLower(second.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args){

		if(Equals(args[0], args[1])){
			System.out.println("True");
		}else{
			System.out.println("False");
		}

	}

}
