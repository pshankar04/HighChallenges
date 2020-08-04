package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution5 {

	public static HashSet<String> elementsSet = new HashSet<String>();
	public static HashMap<String,Integer> palindromeMap = new HashMap<String,Integer>();
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();

		System.out.println("Longest Palindrome :"+longestPalindrome(str));
		

	}

	public static String longestPalindrome(String stringSet){

		String[] parts = stringSet.split(" ");
		//System.out.println("Length : "+parts.length);
		for(int i = 0 ; i <parts.length ; i++){
			elementsSet.add(parts[i]);
		}
		 
	     return searchForLongestPalindrome(savePalindromes(parts));
	}

	public static HashMap<String,Integer> savePalindromes(String[] flex){
		 
		for(int i=0 ; i < flex.length ; i++){
			if(isThisPalindrome(flex[i])){
					palindromeMap.put(flex[i],flex[i].length());
				}
			}
		//System.out.println("Map Contents :"+palindromeMap);
		return palindromeMap;
		}
	

	public static boolean isThisPalindrome(String paliString){
		String temp = "";
		if(paliString.length() == 1) return true;
		for(int k = paliString.length() -1 ; k >= 0  ; k--){
			temp = temp + paliString.charAt(k);
		}
		if(temp.equals(paliString)) return true;
		else return false;
	}
	
	public static String searchForLongestPalindrome(HashMap<String,Integer> paliMap){
		int longestPali = 1;
		StringBuilder longestPalindrome = new StringBuilder();
		Set<Map.Entry<String,Integer>> paliSet = paliMap.entrySet();
		for(Map.Entry<String,Integer> entry : paliSet){
			if(entry.getValue() > longestPali){
				longestPali = entry.getValue();
				longestPalindrome = new StringBuilder(entry.getKey());
			}else{
				longestPalindrome = new StringBuilder(entry.getKey());
			}
			
		}
		return new String(longestPalindrome);
	}

}
