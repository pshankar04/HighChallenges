package Serials;

import java.util.Arrays;

public class CharacterCount {

	public static void main(String[] args) {
		String str = "A set of candid interviews with individuals from the computer science community at the University of Waterloo";
		int[] charArray = new int[Character.MAX_VALUE];
		for(int i = 0 ; i < str.length() ; i++){
			char c = str.charAt(i);
			charArray[c]++;
		}
		
		for(int i = 0 ; i < charArray.length ; i++){
			if(charArray[i] >= 1)
			System.out.println((char)i+" : "+charArray[i]);
		}
		 

	}

	
}
