/* Date        : 2013-10-04
 * Name        : Josh Wainwright
 * UID         : 1079596
 * Worksheet   : 0
 * Title       : Exercise 5
 * Description : Calculate the angle between the hands on a clock given the
 *             :time in hours and minutes.*/

import java.util.Scanner;
public class ex5 {
	public static void main(String[] args) {

		int hours, minutes;
		double hoursDegrees, minsDegrees;

		while (true){
			/* Get values for minutes and hours. Convert to degrees by taking
			 * the modulus so that any repeated cycles around the face are
			 * ignored. Multiply by fraction of face represented by single
			 * minute or hour. */

			Scanner hoursScan = new Scanner(System.in);
			System.out.print("Hours: ");
			hours = hoursScan.nextInt();

			hoursDegrees = (hours%12) * 30.0;

			Scanner minsScan = new Scanner(System.in);
			System.out.print("Minutes: ");
			minutes = minsScan.nextInt();

			minsDegrees = (minutes%60) * 6.0;

			/* Need to take into account the movement of hour hand through
			 * duration on 1 hour. Increment hour position by (fraction of an
			 * hour that has passed) times number of degrees per full hour. */

			hoursDegrees += 30.0*(minutes/60.0);

			System.out.println(hoursDegrees + ", " + minsDegrees);

			/* The answer is then the angle between the two values, if this is
			 * negative, then increment by 360 to get normalised answer. */

			double answer = hoursDegrees - minsDegrees;
			if (answer < 0) {
				answer += 360;
			}
			System.out.println(Math.round(answer));
		}
	}
}
