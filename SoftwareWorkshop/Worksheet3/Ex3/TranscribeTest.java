public class TranscribeTest {
	public static void main(String[] args) {

		String[] filename = {"testfile",
		                     "DonQuixote.txt",
		                     "AliceInWonderland.txt"};

		for(String file: filename){
			System.out.print("Processing file " + file + "...");
			Transcribe.transcribe(file);
			System.out.println("Done");
		}
	}
}
