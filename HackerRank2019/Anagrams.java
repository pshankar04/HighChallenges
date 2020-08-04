package HackerRank;

import java.util.HashMap;
import java.util.Scanner;

public class Anagrams {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str1 = input.next();
		String str2 = input.next();

		if(isAnagram(str1,str2)){
			System.out.println("Anagram");
		}else{
			System.out.println("Not an Anagram");
		}
		input.close();
	}

	public static boolean isAnagram(String s1,String s2){
		HashMap<String,Integer> stringCountMap = new HashMap<String,Integer>();
		
		for(int i = 0 ; i < s1.length();i++){
			if(stringCountMap.containsKey(s1.charAt(i)+"")){
				stringCountMap.put(s1.charAt(i)+"",stringCountMap.get(s1.charAt(i)+"") + 1);
			}else{
				stringCountMap.put(s1.charAt(i)+"",1);
			}
		}
		for(int i = 0 ; i < s2.length();i++){
			if(!stringCountMap.containsKey(s2.charAt(i)+"")){
				return false;
			} else{
				stringCountMap.put(s2.charAt(i)+"",stringCountMap.get(s2.charAt(i)+"") - 1);
				if(stringCountMap.get(s2.charAt(i)+"") == 0){
					stringCountMap.remove(s2.charAt(i)+"");
				}
			}
		}
		return stringCountMap.isEmpty();
	}
}
