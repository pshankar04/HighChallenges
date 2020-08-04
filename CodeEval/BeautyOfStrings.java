package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


public class BeautyOfStrings {

	public static LinkedHashMap<String,Integer> charMap; 
	public static LinkedHashMap<String,Integer> charValueMap;
	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				line = line.trim();
				findTheBeauty(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void findTheBeauty(String sentence){
		int count = 1;
		charMap = new LinkedHashMap<String,Integer>();
		for(int i = 0 ; i< sentence.length() ; i++){
			if(sentence.charAt(i) == ' ') continue;
			if(charMap.size() == 0){
				if(Character.isAlphabetic(sentence.charAt(i))){
					charMap.put((sentence.charAt(i)+"").toLowerCase(),count);
				}
			}else if(charMap.size() > 0){
				if((Character.isAlphabetic(sentence.charAt(i))) && (charMap.containsKey(((sentence.charAt(i)+"").toLowerCase())))){
					charMap.put((sentence.charAt(i)+"").toLowerCase(), charMap.get((sentence.charAt(i)+"").toLowerCase()) + 1);	
				}
 
				else{
					if(Character.isAlphabetic(sentence.charAt(i))){
						charMap.put((sentence.charAt(i)+"").toLowerCase(), count);	
					}
				}
			}
		}
		orderCharMap(charMap);
		printBeauty(sentence);
	}

	public static void orderCharMap(LinkedHashMap<String,Integer> charCountMap){
		charValueMap = new LinkedHashMap<String,Integer>();

		int maxCount = Collections.max(charCountMap.values());
		int value = 26,valuepair = 0; 
		String keyPair = "" ;
		while(charValueMap.size() != charMap.size()){
			Set<Map.Entry<String,Integer>> entrySet = charCountMap.entrySet();
			for(Map.Entry<String,Integer> entry : entrySet ){
				keyPair = entry.getKey();
				valuepair = entry.getValue();
				if((!charValueMap.containsKey(keyPair)) && (valuepair == maxCount)){
					charValueMap.put(keyPair, value);
					value--;
				}
			}
			maxCount--;
		}
	}

	public static void printBeauty(String letters){
		int sum = 0;
		for(int i = 0 ; i < letters.length() ; i++){
			if(letters.charAt(i) == ' ') {
				continue;
			}else if(Character.isAlphabetic(letters.charAt(i))){
				sum = sum + charValueMap.get(((letters.charAt(i)+"").toLowerCase()));
			}
		}
		System.out.println(sum);
	}
}
