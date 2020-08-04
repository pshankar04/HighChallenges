package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReverseSentence {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				reverseWordsInASentence(line);
			}
			buffer.close();

		}catch(Exception e){
			e.printStackTrace();
		}

	}
	
	public static void reverseWordsInASentence(String sentence){
		String[] words = sentence.split(" ");
		String reversedSentence = "";
		for(int i = words.length - 1 ; i >= 0 ; i--){
			reversedSentence = reversedSentence + words[i] +" ";
		}
		System.out.println(reversedSentence);
	}

}
