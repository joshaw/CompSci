public class PictureAverageTest {
	public static void main(String[] args) {
		PictureAverage compsci = new PictureAverage("ComputerScience", 2);

		System.out.println(compsci.getFilename());
		System.out.println(compsci.getfileType());
		System.out.println(compsci.getX());
		System.out.println(compsci.getY());

		compsci.averagePicture();
	}
}
