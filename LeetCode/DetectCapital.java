package LeetCode;

import java.util.Scanner;

public class DetectCapital {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		System.out.println(detectCapitalUse(str));
		in.close();
	}

	public static boolean detectCapitalUse(String word) {
		int upperCase = 0;
		int lowerCase = 0;

		if(allUpperCase(word)){
			return true;
		}

		for(int i = 0 ; i < word.length(); i++){
			if(((int)word.charAt(i)) >= 97 && (((int)word.charAt(i)) <= 122)){
				lowerCase++;
			}else if((((int)word.charAt(i)) >= 65 && (((int)word.charAt(i)) <= 90)) && (i == 0)){
				upperCase++;
			}
		}
		if(((upperCase == 1) && (lowerCase == word.length() - 1) || (lowerCase == word.length()))){
			return true;
		}
		return false;
	}

	public static boolean allUpperCase(String s){
		int count = 0;
		for(int i = 0 ; i < s.length() ; i++){
			if(((int)s.charAt(i)) >= 65 && (((int)s.charAt(i)) <= 90)){
				count++;
			}
		}
		return count == s.length();
	}
}
