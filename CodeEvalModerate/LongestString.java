package CodeEvalModerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LongestString {

	public static boolean isNumber = true;
	public static int printCount = 0;
	public static LinkedHashMap<String,Integer> lengthMap = new LinkedHashMap<String,Integer>();
	public static LinkedHashMap<String,Integer> orderMap;
	
	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null){
				saveString(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		lengthMap.remove(String.valueOf(printCount));
		findLongestString(lengthMap);
	}
	
	public static void saveString(String lines){
		
		if(isNumber){
			printCount = Integer.parseInt(lines);
			isNumber = false;
		}
		lengthMap.put(lines,lines.length());
		
	}
	
	public static void findLongestString(LinkedHashMap<String,Integer> lMap){
		orderMap = new LinkedHashMap<String,Integer>();
		Integer maxLength = Collections.max(lMap.values());
		String key = "";
		Integer value = 0;
		 
		while(orderMap.size() != lengthMap.size()){
			Set<Map.Entry<String,Integer>> entrySet = lengthMap.entrySet();
			for(Map.Entry<String,Integer> entry : entrySet){
				key = entry.getKey(); value = entry.getValue();
				if(value.equals(maxLength) && !orderMap.containsKey(key)){
					orderMap.put(key, value);
				}
			}	
			maxLength--;	
		}
		printFromLongest(orderMap,printCount);
	}
	
	public static void printFromLongest(LinkedHashMap<String,Integer> oMap,int count){
		String key = "";
	
		Set<Map.Entry<String,Integer>> entrySet = oMap.entrySet();
		for(Map.Entry<String,Integer> entry : entrySet){
			key = entry.getKey();  
			 if(count >= 1){
				 System.out.println(key);
				 count--;
			 }
		}
		
	}
	
}
