package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LongestWord {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				findLongestWord(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void findLongestWord(String sentence){
		LinkedHashMap<String,Integer> wordMap = new LinkedHashMap<String,Integer>();
		String[] words = sentence.split(" ");
		int longWordLength = 0;
		String longestWord = "";
		for(int i = 0 ; i < words.length ; i++){
			wordMap.put(words[i],words[i].length());
		}

		Set<Map.Entry<String,Integer>> entrySet = wordMap.entrySet();
		for(Map.Entry<String, Integer> entry : entrySet){
			String word = entry.getKey();
			if(word.length() > longWordLength){
				longWordLength = word.length();
				longestWord = entry.getKey();
			}
		}
		System.out.println(longestWord);
	}

}
