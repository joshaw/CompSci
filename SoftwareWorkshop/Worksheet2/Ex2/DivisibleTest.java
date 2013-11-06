/** Test class for the Divisible class which finds integers that match certain
 * parameters.
 *
 * Run with the JUnit files to test with JUnit tests. Run without to use main
 * which accepts an integer arguement as maximum and finds the relevant numbers
 * between 0 and this maximum and prints them.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 2
 * Exercise  : 2
 * File name : DivisibleTest.java
 * @version 2013-11-07
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class DivisibleTest {

	public static void main(String[] args) {

		int maximum = 300;

		try{
			// Accept argument to program as "maximum" if it exists.
			if (args.length > 0) {
				int temp = Integer.parseInt(args[0]);
				if (temp > 2) {
					maximum = temp;
				}
			}else{
				System.out.println("Using default value for maximum: " + maximum);
			}
		}catch(NumberFormatException e){
			System.out.println("Not a valid input. Using default value 300");
		}

		/* Find the numbers that math the criteria from 0 to "maximum" as
		 * provided by the arguements to the program. */
		Divisible.findDivisible(maximum);
		System.out.println("\nThere are " + Divisible.getCount() + " numbers that satisfy");

		System.out.println();

		/* Find the applicable numbers from 0 to 135.*/
		Divisible.findDivisible(135);
		System.out.println("\nThere are " + Divisible.getCount() + " numbers that satisfy");
	}

	/* Junit test for the numbers 0 to 300. The Divisible class returns a
	 * string which is then printed, so check the numbers against a string
	 * containing all the numbers that should appear. */
	@Test
	public void DivisibleTest1(){
		String checkString300 =
"   2   3   4   5   6   8   9  10  12  15  16  18  20  24  25  26  27  30  32  34" + "\n" +
"  36  38  39  40  45  46  48  50  51  52  54  57  58  60  62  64  65  68  69  72" + "\n" +
"  74  75  76  78  80  81  82  85  86  87  90  92  93  94  95  96 100 102 104 106" + "\n" +
" 108 111 114 115 116 117 118 120 122 123 124 125 128 129 130 134 135 136 138 141" + "\n" +
" 142 144 145 146 148 150 152 153 155 156 158 159 160 162 164 166 170 171 172 174" + "\n" +
" 177 178 180 183 184 185 186 188 190 192 194 195 200 201 202 204 205 206 207 208" + "\n" +
" 212 213 214 215 216 218 219 222 225 226 228 230 232 234 235 236 237 240 243 244" + "\n" +
" 246 248 249 250 254 255 256 258 260 261 262 265 267 268 270 272 274 276 278 279" + "\n" +
" 282 284 285 288 290 291 292 295 296 298";
		Divisible.findDivisible(300);
		assertEquals(checkString300, Divisible.getNumbers());
	}

	@Test
	public void DivisibleTest2(){
		String checkString100 =
"   2   3   4   5   6   8   9  10  12  15  16  18  20  24  25  26  27  30  32  34" + "\n" +
"  36  38  39  40  45  46  48  50  51  52  54  57  58  60  62  64  65  68  69  72" + "\n" +
"  74  75  76  78  80  81  82  85  86  87  90  92  93  94  95  96 100";
		Divisible.findDivisible(100);
		assertEquals(checkString100, Divisible.getNumbers());
	}

}
