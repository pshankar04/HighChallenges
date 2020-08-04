package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CapitalizeWord {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim(); 
				capitalizeString(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public static void capitalizeString(String sentence){
		String finalSentence = "";
		String[] words = sentence.split(" ");
		for(int i = 0 ; i < words.length ;  i++){
			words[i] = capitalize(words[i]);
			finalSentence = finalSentence + words[i] + " ";
		}
		System.out.println(finalSentence);
	}
	
	public static String capitalize(String str){
		String capWord = "";
		for(int i = 0 ; i < str.length() ; i++){
			if(i == 0){
			capWord = String.valueOf(str.charAt(i)).toUpperCase();
			}else{
				capWord = capWord + str.substring(1,str.length());
				break;
			}
		}
		return capWord;
	}
}
