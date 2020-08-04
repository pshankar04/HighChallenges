package HackerEarth;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CharacterCount {

	public static LinkedHashMap<String,Long> charCountMap = new LinkedHashMap<String,Long>();
	public static LinkedHashMap<String,Long> charMap = new LinkedHashMap<String,Long>();
	public static long totalSum = 0;
	
	static{
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		for(int i = 0 ; i < chars.length ; i++){
			charCountMap.put(chars[i]+"",0l);
		}
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		long tc = input.nextLong();
		findCharacterCount(str);
		orderMapContents();
		long index = 0;
		for(long i = 0 ; i < tc ; i++){
			index = input.nextLong();
			if(index > totalSum){
				System.out.println("-1");
			}else{
				 printCharacter(index);
			}
		}
		input.close();
	}

	public static void printCharacter(long indexValue){
		 
		long currentvalue = 0 ,previousValue = 0;
		Set<Map.Entry<String,Long>> entrySet = charMap.entrySet();
		for(Map.Entry<String, Long> entry : entrySet){
			currentvalue = entry.getValue();
			if(indexValue > previousValue && indexValue <= currentvalue ){
				System.out.println(entry.getKey());
				break;
			}else if(indexValue > previousValue && indexValue >= currentvalue ){
				previousValue = entry.getValue();
			} 
		}
		
	}
	
	public static void orderMapContents(){
		long temp = 0;
		
		Set<Map.Entry<String,Long>> entrySet = charCountMap.entrySet();
		for(Map.Entry<String, Long> entry : entrySet){
			temp = temp + entry.getValue();
			charMap.put(entry.getKey(),temp);
		}
	}
	
	public static void findCharacterCount(String series){
		String temp = "" , number = "";
		for(int i = 0  ; i < series.length() ; i++){
			if(Character.isAlphabetic(series.charAt(i))){
				temp = series.charAt(i)+"";

			}else if(Character.isDigit(series.charAt(i))){
				while((i < series.length()) && (Character.isDigit(series.charAt(i)))){
					number = number + series.charAt(i);	
					i++;
				}
				if(charCountMap.containsKey(temp)){
					charCountMap.put(temp,charCountMap.get(temp) + Long.parseLong(number));
				} 
				totalSum = totalSum + Long.parseLong(number);
				temp = "";
				number = "";
				i--;
			}
		}
	}
}
