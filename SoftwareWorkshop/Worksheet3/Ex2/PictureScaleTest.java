import static org.junit.Assert.*;
import org.junit.Test;

public class PictureScaleTest {
	public static void main(String[] args) {
		PictureScale compsci = new PictureScale("ComputerScience", 5, true);

		System.out.println(compsci.getFilename());
		System.out.println(compsci.getfileType());
		System.out.println(compsci.getX());
		System.out.println(compsci.getY());

		compsci.scalePicture(true);
	}

	@Test
	public void PictureScaleTest1() {

		PictureScale t1 = new PictureScale("test", 2, false);
		t1.scalePicture(false);

		String testImageString = t1.getImage();
		assertEquals(testImageString, t1.getImage());
	}

	@Test
	public void PictureScaleTest2() {

		PictureScale t2 = new PictureScale("test", 2, false);
		t2.scalePicture(false);

		String testImageString = t2.getImage();
		assertEquals(testImageString, t2.getImage());
	}
}
