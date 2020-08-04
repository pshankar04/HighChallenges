package CodeEvalModerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
 
public class Crypto {
	public static LinkedHashMap<Integer,String> charMap = new LinkedHashMap<Integer,String>();
	public static LinkedHashMap<String,String> cryptoMap;
	public static char[] chars = new char[26];

	static{
		chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		for(int i = 0 ; i< chars.length ; i++){
			charMap.put(i+1,chars[i]+"");
		}
	}

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;

			while ((line = buffer.readLine()) != null) {
				decrypt(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void decrypt(String line){
		int cycleCount = 5 , addCount = 7;
		cryptoMap = new LinkedHashMap<String,String>();
		for(int i = 0 ; i < (chars.length) ; i++){
			if((i < (chars.length)/4)){
				cryptoMap.put(chars[i]+"", charMap.get((chars.length) - cycleCount));
				cycleCount--;
			}
			else if((i >= (chars.length)/4) && (i < (chars.length)/2)){
				cryptoMap.put(chars[i]+"", charMap.get(i + 1 + addCount));
			}
			else{
				swapMapElements(cryptoMap);
			}
		}
		decipherByCharacter(line);
	}
	
	public static void swapMapElements(LinkedHashMap<String,String> cipherMap){
		LinkedHashMap<String,String> cMap = new LinkedHashMap<String,String>(cipherMap);
		String key = "" , value = "";
		Set<Map.Entry<String,String>> entrySet = cMap.entrySet();
		for(Map.Entry<String,String> entry : entrySet){
			key = entry.getKey(); value= entry.getValue();
			cryptoMap.put(value,key);
		}
	}
	
	public static void decipherByCharacter(String line){
		String text = "";
		for(int i = 0 ; i < line.length() ; i++){
			text = text + cryptoMap.get(line.charAt(i)+"");
		}
		System.out.println(text);
	}
}

