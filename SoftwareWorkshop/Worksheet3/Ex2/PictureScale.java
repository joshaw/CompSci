import java.io.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class PictureScale {

	private String filename;
	private int averageSize = 2;
	private String fileType;
	private boolean verbose;

	/* Un-initialised arrays to hold the image read from the file and the new
	 * image calculated. The arrays will be initialised with their size when
	 * the image has been read. */
	private short[][] image;
	private short[][] newImage;

	private int x, y, grey;
	private int xNew, yNew;


	/** Constructor for the PictureScale class. Will read the provided file
	 * into memory, but will not perform any actions on it. The
	 * {@link scalePicture} method must be called on the object.
	 *
	 * @param filename the name of the file to be scaled
	 * @param averageSize the size of the image kernel used to scale the image.
	 * The value of averageSize is the width of this kernel, so a value of 2
	 * will result in an image 4 times smaller, since each new pixel is
	 * calculated from the 2*2=4 pixels in that location in the original.
	 * @param verbose whether or not to print extra information about the
	 * process as the program runs.
	 */
	public PictureScale(String filename, int averageSize, boolean verbose) {
		this.filename = filename;
		this.averageSize = averageSize;
		this.verbose = verbose;
		readFile(verbose);
	}

	public PictureScale(String filename, int averageSize){
		this(filename, averageSize, false);
	}

	/** Returns the filename of the image connected with the PictureScale
	 * class object.
	 * @return the filename of the object image.
	 */
	public String getFilename() {
		return filename;
	}
	/** Returns the kernel size specified for the scale opperation on the image
	 * in this object.
	 * @return the kernel size of the object image.
	 */
	public int getAverageSize() {
		return averageSize;
	}
	/** Returns the filetype of the image connected with the PictureScale
	 * class object. Where filetype should be one of
	 *     - "P1" which represents a black and white image
	 *     - "P2" which represents a greyscale image
	 *     - "P3" which represents a colour image.
	 * @return the filetype of the object image.
	 */
	public String getfileType() {
		return fileType;
	}
	/** Returns the x dimension of the image connected with the PictureScale
	 * class object.
	 * @return the x dimension of the object image.
	 */
	public int getX() {
		return x;
	}
	/** Returns the y dimension of the image connected with the PictureScale
	 * class object.
	 * @return the y dimension of the object image.
	 */
	public int getY() {
		return y;
	}

	/** Return the image string to the user, if it is needed before being
	 * written to the file.
	 *
	 * @return string containing the whole image.
	 */
	public String getImage() {
		String imageString = "";
		for (int i = 0; i < x; i++) {
			System.out.print(".");
			String imageStringPart = "";
			for (int j = 0; j < y; j++) {

				// For every pixel in a row, write to a string.
				imageStringPart += image[i][j] + " ";
			}

			/* Concatenate the separate row strings into a single large string.
			 * This offers considerable speed improvements over writing every
			 * pixel to the final string individually. */
			imageString += imageStringPart;
		}
		return imageString;
	}


	/** Read the provided file into the variables x, y and grey and the image
	 * in that file into the array.
	 */
	private void readFile(boolean verbose){
		/* Read the relevant file catching errors that indicate that the file
		 * does not exist or is not writable. */
		try {

			Scanner s = new Scanner(new File(filename + "-in.pnm"));
			fileType = s.next();

			/* Read the first 4 values in the file into the relevant variables
			 * and catch errors if they are of the wrong format suggesting
			 * incorrect file format or file corruption. */
			try {
				x = s.nextInt();
				xNew = x/averageSize;
				y = s.nextInt();
				yNew = y/averageSize;

				if ((x%averageSize != 0) || (y%averageSize != 0)) {
					System.out.println("Image dimensions are not even. Exiting.");
					System.exit(0);
				}

				grey = s.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("File format is wrong. Please ensure file is not corrupt.");
				System.exit(0);
			}

			/* Initialize the arrays with the image size read from the file and
			 * the scale factor from the class object. */
			image = new short[x][y];
			newImage = new short[x/averageSize][y/averageSize];

			/* Read each successive pixel value into the array, with feedback
			 * to the user that the operation continues. */
			for (int j=0; j<y; j++) {

				verbose('#');

				for (int i=0; i<x; i++){
					image[i][j] = s.nextShort();
				}
			}
			System.out.println();
			s.close();

		} catch (IOException e) {
			System.out.println("File " + filename + " not found.");
			System.exit(0);
		}
	}

	/** Write the contents of the variables x, y and grey and the image in the
	 * array to the output file.
	 */
	private void writeFile(boolean verbose) {

		try {
			BufferedWriter out =
				new BufferedWriter(new FileWriter(filename + "-out.pnm"));

			out.write(fileType + "\n");
			out.write(xNew + " " + yNew +"\n");
			out.write(grey + "\n");

			String imageString = "";
			int pixelCount = 0;

			for (int j = 0; j < yNew; j++) {

				verbose('.');
;
				for (int i = 0; i < xNew; i++) {

					String temp = String.format("%3s", newImage[i][j]);
					out.write(temp + " ");
					pixelCount++;
					if (pixelCount%xNew == 0) {
						out.write("\n");
					}
				}
			}
			out.close();

		} catch (IOException e){
			System.out.println("Could not write file.");
		}
	}

	/** Using the image in the array, create a new image, scaled down, using
	 * the average of each group of pixels required to perform the scale. The
	 * dimensions of the new image will be x/averageSize by y/averageSize where
	 * the original image was x by y.
	 */
	public void scalePicture(boolean verbose){

		double temp = 0;
		int iNew = 0;
		int jNew = 0;

		for (int j = 0; j <= y-averageSize; j+=averageSize, jNew++) {
			for (int i = 0; i <= x-averageSize; i+=averageSize, iNew++) {

				temp = 0;

				for (int xPixel = 0; xPixel < averageSize; xPixel++) {
					for (int yPixel = 0; yPixel < averageSize; yPixel++) {

						temp += image[i+xPixel][j+yPixel];
					}
				}

				double averagedPixel = temp / Math.pow(averageSize,2);
				newImage[iNew][jNew] = (short) averagedPixel;
			}

			iNew = 0;
		}

		writeFile(verbose);
	}

	public void scalePicture(){
		scalePicture(false);
	}

	private void verbose(char l) {
		if (verbose) {
			System.out.print(l);
		}
	}
}