package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class EliminateRepetitions {

	public static void main(String[] args) {

		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				reomveDuplicates(line);
				System.out.print("\n");
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void reomveDuplicates(String sentence){
		String modSentence = removeSpace(sentence);
		String[] words = modSentence.split(" ");
		StringBuilder word;
				boolean completed = false;
				for(int i = 0 ; i < words.length ; i++){
					word = new StringBuilder(words[i].trim());
					while(!completed){
						for(int k = 0 ; k < word.length() ; k++){
							if(((k+1) < word.length()) && (word.charAt(k) == word.charAt(k+1))){
								word = word.deleteCharAt(k+1);
								break;
							}else{
								if(k == word.length() -1){
									completed = true;
									break;
								}else{
									continue;
								}
							}
						}
					}
		System.out.print(word+" ");
		completed = false;

		}
	}

	public static String removeSpace(String readline){
		ArrayList<String> wordList = new ArrayList<String>();
		String[] newSentence = readline.split(" ");
		String tested = "";
		for(int i = 0 ; i < newSentence.length ; i++){
			if(!newSentence[i].equals("")){
				wordList.add(newSentence[i]);
			}
		}

		for(String str : wordList){
				tested = tested + (new String(str)).trim() + " " ;
		}
		return tested;
	}
}
