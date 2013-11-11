import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Frequency {

	public static double[] countLetters(String filename) {

		int[] countArray = new int[26];
		double[] frequencyArray = new double[26];
		double[] sortedFrequencyArray = new double[26];
		int totalCount = 0;

		String frequencyFile = filename + Transcribe.getAppendedString();

		Transcribe.transcribe(filename);

		try {

			BufferedReader br = new BufferedReader(new FileReader(filename));
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

		} catch(IOException e){
			System.out.println("Could not read from file. Exiting");
			System.exit(0);
		}

		BubbleLinkedArrays c = new BubbleLinkedArrays(countArray, Transcribe.LOWERS);
		int[] sortedCountArray = c.sort(false);
		char[] sortedLOWERS = c.getArray2();

		for (int i = 0; i < 26; i++) {
			frequencyArray[i] = countArray[i] / (totalCount * 1.0);

			sortedFrequencyArray[i] = sortedCountArray[i] / (totalCount * 1.0);
			System.out.printf("%s -> %.4f  ", sortedLOWERS[i], sortedFrequencyArray[i]);

			for (int j = 0; j < (int)(frequencyArray[i]*1000); j++) {
				System.out.print("-");
			}
			System.out.println();
		}

		return frequencyArray;

	}
}
