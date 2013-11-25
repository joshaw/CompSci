/**
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 4
 * Exercise  : 3
 * File name : GoodsTest.java
 * @version 2013-11-24
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class GoodsTest {
	public static void main(String[] args) {
		PerishableGood pg =
			new PerishableGood("Name", 1, 2, true, new Day(2, 5, 2013));

		pg.setBestBefore(new Day(3, 5, 2013));
	}
}
