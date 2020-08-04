package CodeEvalModerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ExcelColumns {

	public static LinkedHashMap<Integer,String> singleCharMap = new LinkedHashMap<Integer,String>();
	public static LinkedHashMap<Integer,String> doubleCharMap = new LinkedHashMap<Integer,String>();
	public static LinkedHashMap<Integer,String> tripleCharMap = new LinkedHashMap<Integer,String>();
	public static String columnNumber = "";
	public static boolean isFound = false;
	static{
		char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		int value = 1;
		for(int i = 0 ; i < chars.length ; i++){
			singleCharMap.put(value,chars[i]+"");
			value++;
		}
		fillDoubleMap();
		fillTripleMap();

	}

	public static void main(String[] args) {

		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.length() > 0) && (Integer.parseInt(line) > 0)) {
				readColumnNumber(line);
				columnNumber = "";
				isFound = false;
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void fillDoubleMap(){

		int i = 27;
		for(int j = 1 ; j <= 26 ;j++){
			for(int k = 1 ; k <= 26 ;k++){
				doubleCharMap.put(new Integer(i),singleCharMap.get(j)+singleCharMap.get(k));
				i++;
			}
		}
	}

	public static void fillTripleMap(){

		int i = 703;
		for(int j = 1 ; j <= 26 ;j++){
			for(int k = 1 ; k <= 26 ;k++){
				for(int l = 1 ; l <= 26 ;l++){
					tripleCharMap.put(new Integer(i),singleCharMap.get(j)+singleCharMap.get(k)+singleCharMap.get(l));
					i++;
				}
			}
		}
	}


	public static void readColumnNumber(String number){
		 
		if(searchSingleMap(number)){
			System.out.println(columnNumber);
		}else if(searchDoubleMap(number)){
			System.out.println(columnNumber);
		}else if(searchTripleMap(number)){
			System.out.println(columnNumber);
		}
		
	}

	public static boolean searchSingleMap(String num){
		
		Set<Map.Entry<Integer,String>> entrySet = singleCharMap.entrySet();
		for(Map.Entry<Integer, String> entry : entrySet){
			if((entry.getKey()).equals(new Integer(num))){
				isFound = true;
				columnNumber = entry.getValue();
			}
		}
		return isFound;
	}

	public static boolean searchDoubleMap(String num){

		Set<Map.Entry<Integer,String>> entrySet = doubleCharMap.entrySet();
		for(Map.Entry<Integer, String> entry : entrySet){
			if((entry.getKey()).equals(new Integer(num))){
				isFound = true;
				columnNumber = entry.getValue();
			}
		}
		return isFound;
	}

	public static boolean searchTripleMap(String num){
		 
		Set<Map.Entry<Integer,String>> entrySet = tripleCharMap.entrySet();
		for(Map.Entry<Integer, String> entry : entrySet){
			if(entry.getKey() ==  Integer.parseInt(num)){
				isFound = true;
				columnNumber = entry.getValue();
			}
		}
		return isFound;
	}
}
