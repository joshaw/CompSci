public class EqualsTest {
	/** Test function for the Equals method
	 */
	public static void main(String[] args){

		// Use two arguements to the program.
		if (args.length == 2) {
			if(Equals.equals(args[0], args[1])){
				System.out.println("Strings are Equal");
			}else{
				System.out.println("Strings are Different");
			}
		}

		System.out.println(Equals.equals("test","tesT"));     // true
		System.out.println(Equals.equals("test","TEST"));     // true
		System.out.println(Equals.equals("test","TesT"));     // true
		System.out.println(Equals.equals("test","tESt"));     // true
		System.out.println(Equals.equals("test","tes"));      // false
		System.out.println(Equals.equals("test","testS"));    // false
		System.out.println(Equals.equals("test",""));         // false
	}

}