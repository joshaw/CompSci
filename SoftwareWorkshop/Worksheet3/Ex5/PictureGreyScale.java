/** Class for converting a colour PNM format image to greyscale using one of
 * three methods; brightness, Luminosity or average. An image is read into
 * memory and then the converting operation can be performed before it is
 * written to a new file.
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 3
 * Exercise  : 5
 * File name : PictureGreyScale.java
 * @version 2013-11-19
 */
import java.io.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class PictureGreyScale {

	private String filename;
	private String filetype;
	private String method;
	private boolean verbose;

	/* Un-initialised arrays to hold the image read from the file and the new
	 * image calculated. The arrays will be initialised with their size when
	 * the image has been read. */
	private short[][][] image;
	private short[][] newImage;

	private int x, y, grey;

	/** Constructor for the PictureScale class. Will read the provided file
	 * into memory, but will not perform any actions on it. The
	 * {@link scalePicture} method must be called on the object.
	 *
	 * @param filename the name of the file to be scaled
	 * @param method one of "luminosity", "average" or "brightness"; specifies
	 * the method that is used to convert the colour image to greyscale.
	 *
	 * - "luminosity" is the often the most pleasing. It averages the values of
	 *    the red, green and blue components of the pixel, but applies a
	 *    weighting to the colours to account for human perception. The formula
	 *    for luminosity is 0.21*R + 0.71*G + 0.07*B.
	 * - "average" is simply the average of the three colour components with no
	 *    additional weighting; (R + G + B)/3.
	 * - "brightness" uses the average of the most prominent colour and the least
	 *    prominent colour, ie the average of the brightest and darkest colours
	 *    is used; (max(R,G,B) + min(R,G,B))/2.
	 *
	 * @param verbose whether or not to print extra information about the
	 * process as the program runs.
	 * @throws IOException if the method to convert colour to greyscale is not
	 * recognised, then an error is thrown.
	 */
	public PictureGreyScale( String filename, String method, boolean verbose)
		throws IOException {

		this.filename = filename;
		this.method = method;

		if ( !(method.equals("brightness") ||
					method.equals("luminosity") ||
					method.equals("average") )) {
			throw new IOException("Convert method not recognised.");
		}
		this.verbose = verbose;
		readFile(verbose);
	}

	/** Alternative constructor, uses a default value of false for the
	 * verbosity.
	 *
	 * @param filename the name of the file to be scaled
	 * @param method one of "luminosity", "average" or "brightness"; specifies
	 * the method that is used to convert the colour image to greyscale.
	 * @throws IOException if the method to convert colour to greyscale is not
	 * recognised, then an error is thrown.
	 */
	public PictureGreyScale(String filename, String method) throws IOException{
		this(filename, method, false);
	}

	/** Alternative constructor, default method is "luminosity" and default
	 * verbosity is false.
	 *
	 * @param filename the name of the file to be scaled
	 * @throws IOException if the method to convert colour to greyscale is not
	 * recognised, then an error is thrown.
	 */
	public PictureGreyScale(String filename) throws IOException {
		this(filename, "luminosity", false);
	}

	/** Returns the filename of the image connected with the PictureScale
	 * class object.
	 * @return the filename of the object image.
	 */
	public String getFilename() {
		return filename;
	}

	/** Returns the filetype of the image connected with the PictureScale
	 * class object. Where filetype should be one of
	 *     - "P1" which represents a black and white image
	 *     - "P2" which represents a greyscale image
	 *     - "P3" which represents a colour image.
	 * @return the filetype of the object image.
	 */
	public String getFiletype() {
		return filetype;
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

	/** Return the method used for converting the colour image to greyscale.
	 *
	 * @return greyscale conversion method.
	 */
	public String getMethod() {
		return method;
	}

	/** Sets or changes the method used for converting a colour image to
	 * greyscale.
	 *
	 * @param method greyscale conversion method.
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/** Return the image string, if it is needed before being written to the
	 * file.
	 * @return a string containing the whole image.
	 */
	public String getNewImage() {
		String imageString = filetype + "\n";

		imageString += x + " " + y + "\n";
		imageString += grey + "\n";

		for (int j = 0; j < y; j++) {

			verbose(j, y);
			String imageStringPart = "";

			for (int i = 0; i < x; i++) {

				// For every pixel in a row, write to a string.
				imageStringPart += String.format("%3s ", newImage[i][j]);
			}

			/* Concatenate the separate row strings into a single large string.
			 * This offers considerable speed improvements over writing every
			 * pixel to the final string individually. */
			imageString += imageStringPart + "\n";
		}
		return imageString;
	}

	/** Read the provided file into the variables x, y and grey and the image
	 * in that file into the array.
	 * @param verbose if true, a progress indicator is printed to the screen as
	 * the image is read to indicate the process continues.
	 * @throws IOException Error thrown if the file does not exist or is not
	 * writable.
	 * @throws InputMismatchException Error thrown if the image to be read is
	 * not a colour image, ie the filetype header does not equal "P3".
	 */
	private void readFile(boolean verbose) throws IOException {
		/* Read the relevant file catching errors that indicate that the file
		 * does not exist or is not writable. */
		try {

			Scanner s = new Scanner(new File(filename + "-colour.pnm"));
			filetype = s.next();

			/* The filetype is determined by the first "word" in the file. If
			 * it does not indicate that the file is colour, throw an error.
			 */
			if (!filetype.equals("P3")){
				throw new InputMismatchException("Image format is not as " +
						"expected. Only colour images are supported but " +
						"image format was found to be " + filetype);
			}

			/* Read the first 4 values in the file into the relevant variables
			 * and catch errors if they are of the wrong format suggesting
			 * incorrect file format or file corruption. */
			x = s.nextInt();
			y = s.nextInt();

			grey = s.nextInt();

			/* Initialize the arrays with the image size read from the file and
			 * the scale factor from the class object. */
			image = new short[x][y][3];
			newImage = new short[x][y];

			/* Read each successive pixel value into the array, with feedback
			 * to the user that the operation continues. */
			for (int j=0; j<y; j++) {

				verbose(j,y);

				for (int i=0; i<x; i++){
					for (int h = 0; h < 3; h++) {
						image[i][j][h] = s.nextShort();
					}
				}
			}
			s.close();

		} catch (InputMismatchException e) {
			System.err.print("File not modified: ");
			System.err.println(e.getMessage());
		}
	}

	/** Write the contents of the variables x, y and grey and the image in the
	 * array to the output file.
	 *
	 * @param verbose if true, a progress indicator is printed to the screen as
	 * the image is writtern to file to indicate the process continues.
	 */
	private void writeFile(boolean verbose) {

		try {
			BufferedWriter out =
				new BufferedWriter(new FileWriter(
						filename + "-colour-" + method + ".pnm"));

			if (filetype.equals("P3")) {
				filetype = "P2";
			}

			out.write(filetype + "\n");
			out.write(x + " " + y +"\n");
			out.write(grey + "\n");

			String imageString = "";
			int pixelCount = 0;

			for (int j = 0; j < y; j++) {

				verbose(j,y);

				for (int i = 0; i < x; i++) {

					String temp = String.format("%3s", newImage[i][j]);
					out.write(temp + " ");
					pixelCount++;
					if (pixelCount%x == 0) {
						out.write("\n");
					}
				}
			}
			out.close();

		/* If the file is not writable, or does not exist, then this error will
		 * be thrown. */
		} catch (IOException e){
			System.err.println("Could not write file.");
		}
	}

	/** Using the image in the array, create a new image, scaled down, using
	 * the average of each group of pixels required to perform the scale. The
	 * dimensions of the new image will be x/averageSize by y/averageSize where
	 * the original image was x by y.
	 * @param verbose if true, a progress indicator is printed to the screen as
	 * the image is writtern to file to indicate the process continues.
	 */
	public void greyScalePicture(){

		double temp = 0;
		int iNew = 0;
		int jNew = 0;

		/* For every pixel in the image, taking three values at a time. Three
		 * values represent 1 pixel - (R,G,B). */
		for (int j = 0; j < y; j++) {
			for (int i = 0; i < x; i++) {
				double averagedPixel = 0;

				//
				// Convert pixel to greyscale using Brightness method.
				//
				if (method.equals("brightness")) {

					int R = image[i][j][0];
					int G = image[i][j][1];
					int B = image[i][j][2];

					/* Take the average of the brightest and darkest pixels as
					 * the grey pixel using Math.max and Math.min. */
					averagedPixel = (Math.max(R, Math.max(G, B)) +
						Math.min(R, Math.min(G, B))) / 2;

				//
				// Convert pixel to greyscale using Average method.
				//
				} else if (method.equals("average")) {

					/* Simply average the values of the three colour
					 * components. */
					// temp = 0;
					// for (int h = 0; h < 3; h++) {
					// 	temp += image[i][j][h];
					// }

					// averagedPixel = temp / 3;
					averagedPixel = (image[i][j][0] +
							image[i][j][1] + image[i][j][2]) / 3;

				//
				// Convert pixel to greyscale using Luminosity method.
				//
				} else { //LUMINOSITY

					/* Take the average of the colour components with a
					 * weighting to account for human perception. */
					int R = image[i][j][0];
					int G = image[i][j][1];
					int B = image[i][j][2];

					averagedPixel = 0.21*R + 0.71*G + 0.07*B;
				}

				/* Using whichever method was chosen, set the value of the
				 * pixel in the greyscale image as the grey version of the old
				 * pixel from the colour image. */
				newImage[i][j] = (short) averagedPixel;
			}

			iNew = 0;
		}

		// Write the newImage to file.
		writeFile(verbose);
	}

	/** Prints a percentage complete to the screen if the verbose flag is true.
	 * @param current the current position in the loop
	 * @param last the last element in the loop
	 */
	private void verbose(int current, int last) {
		if (verbose) {
			int percent = (int) (current/(last * 1.0) * 100 +1);
			if (percent%10 == 0) {
				System.out.print("\r    \r");
				System.out.print( "  " + percent + "%");
			}
			if (current == last -1 ) {
				System.out.println();
			}
		}
	}
}
