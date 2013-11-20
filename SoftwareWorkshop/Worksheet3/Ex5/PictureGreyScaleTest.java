/** Test file for the PictureGreyScale class for converting a colour PNM image
 * to greyscale.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 3
 * Exercise  : 5
 * File name : PictureGreyScaleTest.java
 * @version 2013-11-19
 */
import static org.junit.Assert.*;
import org.junit.Test;

import java.io.IOException;
import java.util.InputMismatchException;

public class PictureGreyScaleTest {
	public static void main(String[] args) {

		try {
			System.out.println("Reading File...");
			PictureGreyScale compsci = new
				PictureGreyScale("ComputerScience");

			String[] methods = {"brightness", "luminosity", "average"};
			for (String method: methods) {
				// compsci.setMethod(method);

				System.out.println("Filename       : " + compsci.getFilename());
				System.out.println("Filetype       : " + compsci.getFiletype());
				System.out.println("X dimension    : " + compsci.getX());
				System.out.println("Y dimension    : " + compsci.getY());
				// System.out.println("Convert method : " + compsci.getMethod());

				System.out.println();
				System.out.println("Converting and Writing File...");
				compsci.greyScalePicture(method, true);
			}

		} catch (IOException e){
			System.err.println(e.getMessage());
		} catch (InputMismatchException e){
			System.err.println(e.getMessage());
		}

	}

	@Test
	public void PictureGreyScaleTest1() {

		try{
			PictureGreyScale t1 = new PictureGreyScale("test");
			t1.greyScalePicture("brightness", false);

			String testImageString = "P2" + "\n" +
			                         "3 2" + "\n" +
			                         "255" + "\n" +
			                         "127 127 127 " + "\n" +
			                         "127 255   0 " + "\n";
			assertEquals(testImageString, t1.getNewImage());

		} catch (IOException e){
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void PictureGreyScaleTest2() {

		try{
			PictureGreyScale t2 = new PictureGreyScale("test");
			t2.greyScalePicture("luminosity", false);

			String testImageString = "P2" + "\n" +
			                         "3 2" + "\n" +
			                         "255" + "\n" +
			                         " 53 181  17 " + "\n" +
			                         "234 252   0 " + "\n";
			assertEquals(testImageString, t2.getNewImage());

		} catch (IOException e){
			System.err.println(e.getMessage());
		}
	}
}
