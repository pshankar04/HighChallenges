package HackerRank;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class HRAnagrams {

	public static HashSet<String> anagramSet = new HashSet<String>();
	public static long anaFact;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str1 = input.nextLine();
		String str2 = input.nextLine();
		anaFact = fact(str1.length());
		//System.out.println("Factorial :"+ anaFact);
		boolean isAnagram = isAnagram(str1,str2);
		if(isAnagram)
			System.out.println("Anagrams");
		else System.out.println("Not Anagrams");


	}

	public static HashSet<String> formAnagrams(String anagramString){
		String temp = "";
		for(int i = 0 ; i < anagramString.length() ; i++){
			temp = anagramString.charAt(i)+"";
			for(int k =0 ; k < anagramString.length() ; k++){
				if(i == k) continue;
				else{
					temp = temp + String.valueOf(anagramString.charAt(k));
				}	
			}
			anagramSet.add(temp);
			temp = "";
		}
		//System.out.println(anagramSet);
		return anagramSet;
	}

	public static boolean isAnagram(String sample1,String sample2){
		anagramSet = formAnagrams(sample1); 
		anagramSet = formAnagrams(reverseString(sample1));
		while(anagramSet.size() != anaFact){
			cartesianProduct(anagramSet);
		}
		//System.out.println("Total Size :"+anagramSet.size());
		return (anagramSet.contains(sample2)) ? true : false;

	}

	public static String reverseString(String str){
		String temp = "";
		for(int i = str.length() - 1; i >= 0 ; i--){
			temp = temp + String.valueOf(str.charAt(i));
		}
		return temp;
	}

	public static long fact(int a){
		if(a == 1) return 1;
		else if( a == 0) return 0;
		else{
			return (a * fact(a-1));
		}
	}

	public static void cartesianProduct(HashSet<String> anagrams){
		HashSet<String> newAnagramSet = new HashSet<String>(anagrams);
		Iterator<String> itr = newAnagramSet.iterator();
		while(itr.hasNext()){
			String anagram = (String)itr.next();
			formAnagrams(anagram);
		}

	}

}
