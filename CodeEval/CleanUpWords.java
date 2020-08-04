package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class CleanUpWords {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			int count = 0;
			while ((line = buffer.readLine()) != null && (line.trim().length() >= 10) && (line.trim().length() <= 100) && (count < 40)){
				cleanUp(line);
				System.out.println();
				count++;
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void cleanUp(String words){
		words = words + ".";
		String modWord = "";
		ArrayList<String> wordsList = new ArrayList<String>();
		for(int i = 0 ; i< words.length() ; i++){
			if(Character.isAlphabetic(words.charAt(i))){
				modWord = modWord + words.charAt(i);
			}else{
				if((modWord.length() > 0)){
					wordsList.add(modWord.trim());
					modWord = "";
				}
			}
		}
		 
		if(wordsList.size() >= 1){
			for(String word : wordsList){
				System.out.print((word.trim()).toLowerCase()+ " ");
			}
		}
	}

}
