package CodeEval_Hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashMap;

public class FollowingInteger {
	public static LinkedHashMap<String,Integer> charCountMap;

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;

			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				computeNext(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void computeNext(String number){
		long start = Long.parseLong(number);
		
		saveCharacters(number);
		for(long k = start + 1 ; k < 1000000 ; k++){
			if(digitsExist(k)){
				System.out.println(k);
				break;
			}
		}
	}

	public static boolean digitsExist(long num){

		LinkedHashMap<String,Integer> charsMap = new LinkedHashMap<String,Integer>();
		String number = Long.toString(num);
		charsMap = saveExampleString(number);
		boolean matches = false;
		int matchCount = 0;
		
		if(charsMap.size() == charCountMap.size()){
			for(int i = 0 ; i < number.length() ; i++){
				if(charsMap.get(number.charAt(i)+"") == charCountMap.get(number.charAt(i)+"")){
					matchCount++;
				}
			}
			if(matchCount == number.length()){
				matches = true;
			} 
		}
		return matches;
	}

	public static LinkedHashMap<String,Integer> saveExampleString(String num){
		LinkedHashMap<String,Integer> charMap = new LinkedHashMap<String,Integer>();

		for(int  i = 0 ; i < num.length() ; i++){
			if(num.charAt(i) != '0'){
				if(charMap.containsKey(num.charAt(i)+"")){
					charMap.put(num.charAt(i)+"",charMap.get(num.charAt(i)+"") + 1);
				}else{
					charMap.put(num.charAt(i)+"", 1);
				}
			}
		}
		return charMap;
	}

	public static void saveCharacters(String num){
		charCountMap = new LinkedHashMap<String,Integer>();
		
		for(int  i = 0 ; i < num.length() ; i++){
			if(num.charAt(i) != '0'){
				if(charCountMap.containsKey(num.charAt(i)+"")){
					charCountMap.put(num.charAt(i)+"",charCountMap.get(num.charAt(i)+"") + 1);
				}else{
					charCountMap.put(num.charAt(i)+"", 1);
				}
			}
		}
		 
	}
}
