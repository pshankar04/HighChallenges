package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class NonrepeatedCharacter {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				System.out.println(nonrepeatedCharacter(line));
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static String nonrepeatedCharacter(String word){
		 
		int count = 1;
		String character = "";
		int charCount = 1;
		LinkedHashMap<String,Integer> charCountMap = new LinkedHashMap<String,Integer>();
		for(int i = 0 ; i < word.length() ; i++){
			if(charCountMap.size() == 0 && charCountMap.isEmpty()){
				charCountMap.put(word.charAt(i)+"", count);
			}else if(charCountMap.size() != 0 && !charCountMap.isEmpty() && charCountMap.containsKey(word.charAt(i)+"")){
				charCountMap.put(word.charAt(i)+"", charCountMap.get(word.charAt(i)+"") + 1);
			}else{
				charCountMap.put(word.charAt(i)+"", count);
			}
		}
		 
		Set<Map.Entry<String,Integer>> entrySet = charCountMap.entrySet();
		for(Map.Entry<String, Integer> entry : entrySet){
			if(entry.getValue() == charCount){
				character = entry.getKey();
				break;
			}
		}

		return character;
	}

}
