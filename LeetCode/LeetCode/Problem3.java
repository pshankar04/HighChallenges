package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Problem3 {

	public static HashMap<String,Integer> stringMap = new HashMap<String,Integer>();
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		saveIntoMap(str);
		System.out.println(stringMap);
		if(!stringMap.isEmpty() && stringMap.size() != 0){
			System.out.println("Lengtheir String is :"+findLengthierString(stringMap));
		}

	}

	public static void saveIntoMap(String check){
		String[] chkString = check.split(" ");
		for(int i = 0 ; i < chkString.length ; i++){
			if( !stringMap.isEmpty() && stringMap.size() > 0){
				if(stringMap.containsKey(chkString[i])){
					stringMap.put(chkString[i], (stringMap.get(chkString[i]) + 1));
				}else if(checkForRepition(chkString[i])){
					continue;
				}else{
					stringMap.put(chkString[i], 1);
				}
			}else{
				if(checkForRepition(chkString[i])){
					continue;
				}else{
					stringMap.put(chkString[i], 1);
				}
			}
		}
	}

	public static boolean checkForRepition(String sample){
		for(int i = 0 ; i < sample.length() ; i++){
			for(int k = 0 ; k < sample.length() ; k++){
				if(i == k) continue;
				else{
					if(sample.charAt(i) == sample.charAt(k)){
						return true;
					}
				}
			}
		}
		return false;
	}

	public static String findLengthierString(HashMap<String,Integer> contentMap){
		int longerStringlength = 0;
		ArrayList<String> listOfString = new ArrayList<String>();
		Set<Map.Entry<String, Integer>> hashSet = (Set<Map.Entry<String, Integer>>)contentMap.entrySet();
		for(Map.Entry<String, Integer> entry : hashSet){
			if(entry.getKey().length() > longerStringlength){
				if(listOfString.size() == 0){
					listOfString.add(entry.getKey());
					longerStringlength = listOfString.get(0).length();
				}else{
					listOfString.remove(0);
					listOfString.add(entry.getKey());
					longerStringlength = listOfString.get(0).length();
				}
			}
		}
		return listOfString.get(0);
	}
}


