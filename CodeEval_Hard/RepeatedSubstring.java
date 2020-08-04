package CodeEval_Hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;


public class RepeatedSubstring {
	public static LinkedHashMap<String,Integer> subStringCountMap ; 
	public static String inputString = "";

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;

			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				//System.out.println(line);
				inputString = line;
				findMaxRepeatedSubString(formSubstrings(line));
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void findMaxRepeatedSubString(LinkedHashSet<String> countSet){

		LinkedHashMap<String,Integer> charRepitionsMap = new LinkedHashMap<String,Integer>();
		for(String s : countSet){
			charRepitionsMap = findRepitions(charRepitionsMap,inputString,s);
		}
		findMaxDupString(charRepitionsMap);
	}

	public static void  findMaxDupString(LinkedHashMap<String,Integer> charRepitionsMap){
		LinkedHashMap<String,Integer> finalMap = new LinkedHashMap<String,Integer>();
		String temp = "" ;
		int value = 0;
		Set<Map.Entry<String,Integer>> entrySet1 = charRepitionsMap.entrySet();
		for(Map.Entry<String, Integer> ent : entrySet1){
			temp = ent.getKey();
			value = ent.getValue();
			if(value > 1){
				finalMap.put(temp, value);
			}
		}
		 
		if(finalMap.size() == 0){
			System.out.println("NONE");
		}else{
			findMax(finalMap);
		}
	}

	public static void findMax(LinkedHashMap<String,Integer> dupMap){
		int maxLen = 0 , valueObjLength = 0;
		String temp = "" , maxObj = "";
		Set<Map.Entry<String, Integer>> entrySet = dupMap.entrySet();
		for(Map.Entry<String, Integer> entry : entrySet){
			temp = entry.getKey();
			valueObjLength = temp.length();
			if(valueObjLength > maxLen){
				maxLen = valueObjLength;
				maxObj = temp;
			}
		}
		System.out.println(maxObj);
	}


	public static LinkedHashMap<String,Integer> findRepitions(LinkedHashMap<String,Integer> repMap,String org , String tempo){

		int tempLength = tempo.length();
		for(int i = 0 ; i < (org.length() - tempLength) ; i++){
			if(org.substring(i,i+tempLength).equals(tempo)){
				if(!repMap.containsKey(tempo)){
					repMap.put(tempo, 1);
				}else{
					repMap.put(tempo,(repMap.get(tempo)) + 1);
				}
			}
		}
		return repMap;

	}

	public static LinkedHashSet<String> formSubstrings(String str){
		LinkedHashSet<String> subStringSet = new LinkedHashSet<String>();
		String sub;

		if(str.length() > 0){
			for( int c = 0 ; c < str.length() ; c++ )
			{
				for( int i = 1 ; i <= str.length() - c ; i++ )
				{
					sub = str.substring(c, c+i);
					if(!(sub.trim()).equals("")){
						subStringSet.add(sub);
					}
				}
				sub = "";
			}
			return subStringSet;
		}
		else
			return subStringSet;
	}
}
