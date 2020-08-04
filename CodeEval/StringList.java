package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.TreeSet;

public class StringList {
	public static TreeSet<String> charSet ;

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;

			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				printAllKLength((line.split(",")[1]).toCharArray(),Integer.parseInt(line.split(",")[0]));
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}



	public static void printAllKLength(char set[], int k) {
		int n = set.length;      
		String finalString = "";
		charSet = new TreeSet<String>();
		printAllKLengthRec(set, "", n, k);
		for(String s : charSet){
			finalString = finalString + s + ",";
		}
		finalString = new String(new StringBuilder(finalString).deleteCharAt(finalString.length()-1));
		System.out.println(finalString);
	}

	public static void printAllKLengthRec(char set[], String prefix, int n, int k) {

		if (k == 0) {
			charSet.add(prefix);
			return;
		}

		for (int i = 0; i < n; ++i) {
			String newPrefix = prefix + set[i]; 
			printAllKLengthRec(set, newPrefix, n, k - 1); 
		}
	}

}
