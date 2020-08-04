package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


public class BeautifulStrings {

	public static int alphaCount ;
	public static HashMap<String,Integer> charMap;
	public static HashMap<String,Integer> alternateMap;
	public static LinkedHashMap<String,Integer> countMap ;
	public static LinkedHashMap<String,Integer> finalMap ;
	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				line = line.replaceAll("[-+.^:,=)(@#$%&*;?}{`~\\[\\]\\!\\_\\-]|\\/]","");
				line = line.replace("\\", "");
				charMap = saveCharacters(line);
				if(!charMap.isEmpty()){
				finalMap = createOrderInMap(charMap);
				}if(!finalMap.isEmpty()){
				printBeautiness(finalMap,line);
				}
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static HashMap<String,Integer> saveCharacters(String str){
		str = str.toLowerCase();
		charMap = new HashMap<String,Integer>();
		for(int i = 0 ; i < str.length() ; i++){
			if(str.charAt(i) == ' ') 
				continue;
			else if(!charMap.containsKey(str.charAt(i)+"")){
				charMap.put(str.charAt(i)+"", 1);
			}
			else if(charMap.containsKey(str.charAt(i)+"")){
				int valuePair = charMap.get(str.charAt(i)+"");
				charMap.put(str.charAt(i)+"", ++valuePair);
			}
		}
		return charMap;
	}

	public static LinkedHashMap<String,Integer> createOrderInMap(HashMap<String,Integer> letterMap){
		finalMap = new LinkedHashMap<String,Integer>();
		alternateMap = new HashMap<String,Integer>(letterMap);
		while(letterMap.size() > 0 && !alternateMap.isEmpty()){
			alternateMap = deleteInMap(alternateMap,Collections.max(alternateMap.values()));
		}
		return finalMap;
	}

	public static HashMap<String,Integer> deleteInMap(HashMap<String,Integer> itemMap,int maxValue){
		Set<Map.Entry<String,Integer>> entrySet = itemMap.entrySet();
		for(Map.Entry<String, Integer> entry : entrySet){
			if(entry.getValue() == maxValue){
				finalMap.put(entry.getKey(), entry.getValue());
				itemMap.remove(entry.getKey());
				break;
			}
		}
		return itemMap;
	}

	public static void printBeautiness(LinkedHashMap<String,Integer> orderedMap,String userString){
		int sum = 0;
		countMap = new LinkedHashMap<String,Integer>(orderedMap);
		countMap = initializeMap(countMap);
		userString = userString.toLowerCase();
		for(int b = 0 ; b < userString.length() ; b++){
			if(userString.charAt(b) == ' ') continue;
			else{
				sum = sum + countMap.get(userString.charAt(b)+"");
			}
		}
		System.out.println(sum);
	}

	public static LinkedHashMap<String,Integer> initializeMap(LinkedHashMap<String,Integer> finestMap){
		alphaCount = 26;
		Set<Map.Entry<String, Integer>> entrySet = finestMap.entrySet();
		for(Map.Entry<String, Integer> entry : entrySet){
			finestMap.put(entry.getKey(),alphaCount);
			alphaCount--;
		}
		return finestMap;
	}
}
