/** Test class for the CalYear class.
 *
 * Run with the JUnit files to use the test classes, otherwise will take upto 3
 * arguements from the commandline. First is the year for which the calendar
 * will be calculated, second is the number of the first day of the year (0->6
 * for Mon through Sun) and third the width of the calendar in terms of the
 * number of months to be displayed side by side.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 2
 * Exercise  : 5
 * File name : CalYearTest.java
 * @version 2013-11-02
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class CalYearTest {
	public static void main(String[] args) {

		int year = 2013;
		int first = 1;
		int width = 3;

		if (args.length > 0) {
			year = Integer.parseInt(args[0]);
		}
		if (args.length > 1) {
			first = Integer.parseInt(args[1]);
		}
		if (args.length > 2) {
			width = Integer.parseInt(args[2]);
		}

		// Create new year calendar
		CalYear cy = new CalYear(year, first, width);

		System.out.println(cy);
	}

	@Test
	public void CalYearTest1(){
		String calYearString =
"                                2013 AD" + "\n" +
"" + "\n" +
"       January                February                March          " + "\n" +
" Mo Tu We Th Fr Sa Su   Mo Tu We Th Fr Sa Su   Mo Tu We Th Fr Sa Su  " + "\n" +
"     1  2  3  4  5  6                1  2  3                1  2  3  " + "\n" +
"  7  8  9 10 11 12 13    4  5  6  7  8  9 10    4  5  6  7  8  9 10  " + "\n" +
" 14 15 16 17 18 19 20   11 12 13 14 15 16 17   11 12 13 14 15 16 17  " + "\n" +
" 21 22 23 24 25 26 27   18 19 20 21 22 23 24   18 19 20 21 22 23 24  " + "\n" +
" 28 29 30 31            25 26 27 28            25 26 27 28 29 30 31  " + "\n" +
"                                                                     " + "\n" +
"        April                   May                    June          " + "\n" +
" Mo Tu We Th Fr Sa Su   Mo Tu We Th Fr Sa Su   Mo Tu We Th Fr Sa Su  " + "\n" +
"  1  2  3  4  5  6  7          1  2  3  4  5                   1  2  " + "\n" +
"  8  9 10 11 12 13 14    6  7  8  9 10 11 12    3  4  5  6  7  8  9  " + "\n" +
" 15 16 17 18 19 20 21   13 14 15 16 17 18 19   10 11 12 13 14 15 16  " + "\n" +
" 22 23 24 25 26 27 28   20 21 22 23 24 25 26   17 18 19 20 21 22 23  " + "\n" +
" 29 30                  27 28 29 30 31         24 25 26 27 28 29 30  " + "\n" +
"                                                                     " + "\n" +
"         July                  August               September        " + "\n" +
" Mo Tu We Th Fr Sa Su   Mo Tu We Th Fr Sa Su   Mo Tu We Th Fr Sa Su  " + "\n" +
"  1  2  3  4  5  6  7             1  2  3  4                      1  " + "\n" +
"  8  9 10 11 12 13 14    5  6  7  8  9 10 11    2  3  4  5  6  7  8  " + "\n" +
" 15 16 17 18 19 20 21   12 13 14 15 16 17 18    9 10 11 12 13 14 15  " + "\n" +
" 22 23 24 25 26 27 28   19 20 21 22 23 24 25   16 17 18 19 20 21 22  " + "\n" +
" 29 30 31               26 27 28 29 30 31      23 24 25 26 27 28 29  " + "\n" +
"                                               30                    " + "\n" +
"       October                November               December        " + "\n" +
" Mo Tu We Th Fr Sa Su   Mo Tu We Th Fr Sa Su   Mo Tu We Th Fr Sa Su  " + "\n" +
"     1  2  3  4  5  6                1  2  3                      1  " + "\n" +
"  7  8  9 10 11 12 13    4  5  6  7  8  9 10    2  3  4  5  6  7  8  " + "\n" +
" 14 15 16 17 18 19 20   11 12 13 14 15 16 17    9 10 11 12 13 14 15  " + "\n" +
" 21 22 23 24 25 26 27   18 19 20 21 22 23 24   16 17 18 19 20 21 22  " + "\n" +
" 28 29 30 31            25 26 27 28 29 30      23 24 25 26 27 28 29  " + "\n" +
"                                               30 31                 " + "\n" +
"";
		CalYear cy = new CalYear();

		assertEquals(calYearString, cy.toString());
	}

	@Test
	public void CalYearTest2(){
		String calYearString2 =
"                                2008 AD" + "\n" +
"" + "\n" +
"       January                February                March          " + "\n" +
" Mo Tu We Th Fr Sa Su   Mo Tu We Th Fr Sa Su   Mo Tu We Th Fr Sa Su  " + "\n" +
"                    1          1  2  3  4  5             1  2  3  4  " + "\n" +
"  2  3  4  5  6  7  8    6  7  8  9 10 11 12    5  6  7  8  9 10 11  " + "\n" +
"  9 10 11 12 13 14 15   13 14 15 16 17 18 19   12 13 14 15 16 17 18  " + "\n" +
" 16 17 18 19 20 21 22   20 21 22 23 24 25 26   19 20 21 22 23 24 25  " + "\n" +
" 23 24 25 26 27 28 29   27 28 29               26 27 28 29 30 31     " + "\n" +
" 30 31                                                               " + "\n" +
"        April                   May                    June          " + "\n" +
" Mo Tu We Th Fr Sa Su   Mo Tu We Th Fr Sa Su   Mo Tu We Th Fr Sa Su  " + "\n" +
"                    1       1  2  3  4  5  6                1  2  3  " + "\n" +
"  2  3  4  5  6  7  8    7  8  9 10 11 12 13    4  5  6  7  8  9 10  " + "\n" +
"  9 10 11 12 13 14 15   14 15 16 17 18 19 20   11 12 13 14 15 16 17  " + "\n" +
" 16 17 18 19 20 21 22   21 22 23 24 25 26 27   18 19 20 21 22 23 24  " + "\n" +
" 23 24 25 26 27 28 29   28 29 30 31            25 26 27 28 29 30     " + "\n" +
" 30                                                                  " + "\n" +
"         July                  August               September        " + "\n" +
" Mo Tu We Th Fr Sa Su   Mo Tu We Th Fr Sa Su   Mo Tu We Th Fr Sa Su  " + "\n" +
"                    1          1  2  3  4  5                   1  2  " + "\n" +
"  2  3  4  5  6  7  8    6  7  8  9 10 11 12    3  4  5  6  7  8  9  " + "\n" +
"  9 10 11 12 13 14 15   13 14 15 16 17 18 19   10 11 12 13 14 15 16  " + "\n" +
" 16 17 18 19 20 21 22   20 21 22 23 24 25 26   17 18 19 20 21 22 23  " + "\n" +
" 23 24 25 26 27 28 29   27 28 29 30 31         24 25 26 27 28 29 30  " + "\n" +
" 30 31                                                               " + "\n" +
"       October                November               December        " + "\n" +
" Mo Tu We Th Fr Sa Su   Mo Tu We Th Fr Sa Su   Mo Tu We Th Fr Sa Su  " + "\n" +
"  1  2  3  4  5  6  7             1  2  3  4                   1  2  " + "\n" +
"  8  9 10 11 12 13 14    5  6  7  8  9 10 11    3  4  5  6  7  8  9  " + "\n" +
" 15 16 17 18 19 20 21   12 13 14 15 16 17 18   10 11 12 13 14 15 16  " + "\n" +
" 22 23 24 25 26 27 28   19 20 21 22 23 24 25   17 18 19 20 21 22 23  " + "\n" +
" 29 30 31               26 27 28 29 30         24 25 26 27 28 29 30  " + "\n" +
"                                               31                    " + "\n" +
"";
		CalYear cy2 = new CalYear(2008, 6);

		assertEquals(calYearString2, cy2.toString());
	}
}
