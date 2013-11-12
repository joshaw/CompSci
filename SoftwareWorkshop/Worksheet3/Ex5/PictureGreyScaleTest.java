public class PictureGreyScaleTest {
	public static void main(String[] args) {
		PictureGreyScale compsci = new PictureGreyScale("ComputerScience", "brightness", true);

		System.out.println(compsci.getFilename());
		System.out.println(compsci.getfileType());
		System.out.println(compsci.getX());
		System.out.println(compsci.getY());

		compsci.greyScalePicture(true);

	}
}
