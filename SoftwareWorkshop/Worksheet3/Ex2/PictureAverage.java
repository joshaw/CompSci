import java.io.*;
import java.util.Scanner;

public class PictureAverage {

	private String filename;
	private int averageSize = 2;
	private String fileType;

	private short[][] image;
	private short[][] newImage;

	private int x, y, grey;
	private int xNew, yNew;

	public PictureAverage(String filename, int averageSize) {
		this.filename = filename;
		this.averageSize = averageSize;
		readFile();
	}

	public String getFilename() {
		return filename;
	}
	public int getAverageSize() {
		return averageSize;
	}
	public String getfileType() {
		return fileType;
	}
	public int getX() {
		return x;
	}
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
				imageStringPart += image[i][j] + " ";
			}
			imageString += imageStringPart;
		}
		return imageString;
	}

	private void readFile(){

		try {

			Scanner s = new Scanner(new File(filename + "-in.pnm"));
			fileType = s.next();

			x = s.nextInt();
			xNew = x/averageSize;
			y = s.nextInt();
			yNew = y/averageSize;
			grey = s.nextInt();

			image = new short[x][y];
			newImage = new short[x/averageSize][y/averageSize];

			for (int i=0; i<x; i++) {
				System.out.print("#");
				for (int j=0; j<y; j++){
					image[i][j] = s.nextShort();
				}
			}
			s.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// private void writeFileOriginal() {

	// 	try {
	// 		BufferedWriter out =
	// 			new BufferedWriter(new FileWriter(filename + "-out.pnm"));

	// 		out.write(fileType + "\r");
	// 		out.write(x + " " + y +"\r");
	// 		out.write(grey + "\r");

	// 		String imageString = "";
	// 		int pixelCount = 0;

	// 		for (int i = 0; i < x; i++) {

	// 			System.out.print(".");

	// 			for (int j = 0; j < y; j++) {

	// 				String temp = String.format("%3s", image[i][j]);
	// 				out.write(temp + " ");
	// 				pixelCount++;
	// 				if (pixelCount%17 == 0) {
	// 					out.write("\r");
	// 					pixelCount = 0;
	// 				}
	// 			}
	// 		}
	// 		out.close();

	// 	} catch (IOException e){
	// 		System.out.println("Could not write file.");
	// 	}

	// }

	private void writeFile() {

		try {
			BufferedWriter out =
				new BufferedWriter(new FileWriter(filename + "-out.pnm"));

			out.write(fileType + "\r");
			out.write(xNew + " " + yNew +"\r");
			out.write(grey + "\r");

			String imageString = "";
			int pixelCount = 0;

			for (int i = 0; i < xNew; i++) {

				System.out.print(".");

				for (int j = 0; j < yNew; j++) {

					String temp = String.format("%3s", newImage[i][j]);
					out.write(temp + " ");
					pixelCount++;
					if (pixelCount%xNew == 0) {
						out.write("\r");
					}
				}
			}
			out.close();

		} catch (IOException e){
			System.out.println("Could not write file.");
		}

	}

	public void averagePicture(){

		double temp = 0;
		int iNew = 0;
		int jNew = 0;

		for (int i = 0; i <= x-averageSize; i+=averageSize, iNew++) {
			for (int j = 0; j <= y-averageSize; j+=averageSize, jNew++) {

				temp = 0;

				for (int xPixel = 0; xPixel < averageSize; xPixel++) {
					for (int yPixel = 0; yPixel < averageSize; yPixel++) {

						temp += image[i+xPixel][j+yPixel];
						// System.out.println(i + " " + j + " " + image[i+xPixel][j+yPixel] + " " + temp);

					}
				}

				double averagedPixel = temp / Math.pow(averageSize,2);
				newImage[iNew][jNew] = (short) averagedPixel;

			}

			jNew = 0;
		}

		writeFile();

	}


}
