/**
 *
 * @author Josh Wainwright
 * UID       : 1079596
 * Worksheet : 3
 * Exercise  : Worksheet3
 * File name : MapDictionary.java
 * @version 2014-02-03
 */
package predictive;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;
import java.util.TreeMap;

public class MapDictionary implements Dictionary {

	private String dictFile = "testfiles/words";
	private File file = new File(dictFile);
	private TreeMap<String,String> wordSet = new TreeMap<String,String>();

	public MapDictionary() {
		readDictionary(dictFile);
	}

	public MapDictionary(String dictFile) {
		readDictionary(this.dictFile);
	}

	private void readDictionary(String dictFile) {

	}

	public Set<String> signatureToWords(String signature){
		return new TreeSet<String>();
	}

}
