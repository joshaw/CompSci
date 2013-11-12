import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Frequency {

	public static double[] countLetters(String filename, boolean sort) {

		int[] countArray = new int[26];
		double[] frequencyArray = new double[26];
		double[] sortedFrequencyArray = new double[26];
		int totalCount = 0;

		String frequencyFile = filename + Transcribe.getAppendedString();

		Transcribe.transcribe(filename);

		try {

			BufferedReader br = new BufferedReader(new FileReader(frequencyFile));
			String line;

			while ((line = br.readLine()) != null) {

				String newString = "";
				for (int i = 0; i < line.length(); i++) {
					for (int j = 0; j < 26; j++) {
						if (line.charAt(i) == Transcribe.LOWERS[j]) {
							countArray[j]++;
							totalCount++;
						}
					}
				}
			}

			br.close();

			int[] sortedCountArray;
			char[] sortedLOWERS;
			if (sort) {
				BubbleLinkedArrays c = new BubbleLinkedArrays(countArray, Transcribe.LOWERS);
				sortedCountArray = c.sort(false);
				sortedLOWERS = c.getArray2();
			} else {
				sortedCountArray = countArray;
				sortedLOWERS = Transcribe.LOWERS;
			}

			for (int i = 0; i < 26; i++) {
				frequencyArray[i] = countArray[i] / (totalCount * 1.0);

				sortedFrequencyArray[i] = sortedCountArray[i] / (totalCount * 1.0);
				System.out.printf("%s -> %.4f  ", sortedLOWERS[i], sortedFrequencyArray[i]);

				for (int j = 0; j < (int)(frequencyArray[i]*1000); j++) {
					System.out.print("-");
				}
				System.out.println();
			}

		} catch(IOException e){
			System.err.println("Could not read from file. Exiting");
		}

		return frequencyArray;

	}

	public static double[] countLetters(String filename) {
		return countLetters(filename, false);
	}

}
