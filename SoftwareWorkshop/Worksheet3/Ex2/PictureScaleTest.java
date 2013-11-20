/** Test class for the PictureScale class which scales a PNM image down by some
 * scale factor and writes the result to a file.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 3
 * Exercise  : 2
 * File name : PictureScaleTest.java
 * @version 2013-11-19
 */
import static org.junit.Assert.*;
import org.junit.Test;

import java.io.IOException;

public class PictureScaleTest {
	public static void main(String[] args) {

		try {
			System.out.println("Reading File...");
			PictureScale compsci =
				new PictureScale("ComputerScience-grey.pnm");

			System.out.println();
			System.out.println("Reading, Converting and Writing File...");
			compsci.scalePicture(5, true);

			System.out.println("Filename    : " + compsci.getFilename());
			System.out.println("Filetype    : " + compsci.getFiletype());
			System.out.println("X dimension : " + compsci.getX());
			System.out.println("Y dimension : " + compsci.getY());

		} catch (IOException e){
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void PictureScaleTest1() {

		try{
			/* Create the object using the filename of an example image, and
			 * apply the scalePicture method to it. */
			PictureScale t1 = new PictureScale("test-grey.pnm");
			t1.scalePicture(2, false);

			/* Compare the resulting image string with the correct value
			 * provided. */
			String testImageString = "P2" + "\n" +
			                         "2 2" + "\n" +
			                         "25" + "\n" +
			                         "  9 16" + "\n" +
			                         "  0 12" + "\n";
			assertEquals(testImageString, t1.getNewImage());

		} catch (IOException e){
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void PictureScaleTest2() {

		try{
			PictureScale t2 = new PictureScale("test2-grey.pnm");
			t2.scalePicture(3, false);

			String testImageString = "P2" + "\n" +
			                         "3 3" + "\n" +
			                         "25" + "\n" +
			                         "  7 21  9" + "\n" +
			                         "  3  3  4" + "\n" +
			                         " 15 15 15" + "\n";
			assertEquals(testImageString, t2.getNewImage());

		} catch (IOException e){
			System.err.println(e.getMessage());
		}
	}
}
