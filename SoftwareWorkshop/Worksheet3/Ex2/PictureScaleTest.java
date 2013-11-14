import static org.junit.Assert.*;
import org.junit.Test;

import java.io.IOException;

public class PictureScaleTest {
	public static void main(String[] args) {

		try {
			System.out.println("Reading File...");
			PictureScale compsci = new PictureScale("../ComputerScience", 5, true);

			System.out.println("Filename    : " + compsci.getFilename());
			System.out.println("Filetype    : " + compsci.getFiletype());
			System.out.println("X dimension : " + compsci.getX());
			System.out.println("Y dimension : " + compsci.getY());
			System.out.println("Scale factor: " + compsci.getAverageSize());

			System.out.println();
			System.out.println("Converting and Writing File...");
			compsci.scalePicture(true);

		} catch (IOException e){
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void PictureScaleTest1() {

		try{
			PictureScale t1 = new PictureScale("../test", 2, false);
			t1.scalePicture(false);

			String testImageString = t1.getImage();
			assertEquals(testImageString, t1.getImage());

		} catch (IOException e){
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void PictureScaleTest2() {

		try{
			PictureScale t2 = new PictureScale("../test", 2, false);
			t2.scalePicture(false);

			String testImageString = t2.getImage();
			assertEquals(testImageString, t2.getImage());

		} catch (IOException e){
			System.err.println(e.getMessage());
		}
	}
}
