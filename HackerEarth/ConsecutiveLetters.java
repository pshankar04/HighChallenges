package HackerEarth;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class ConsecutiveLetters {
	public static LinkedHashSet<String> stringSet;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		stringSet = new LinkedHashSet<String>();
		for(int i = 0 ; i < tc ; i++){
			stringSet.add(input.nextLine());
		}
		for(String s : stringSet){
			System.out.println(deleteConsecutiveLetters(s));
		}
		input.close();
	}

	public static String deleteConsecutiveLetters(String word){
		int j = 0;
		while(j <= word.length()){
			for(int i = 0 ; i < word.length() ; i++,j++){
				if(((i + 1) < word.length()) && (word.charAt(i) == word.charAt(i+1))){
					word = new String((new StringBuilder(word)).deleteCharAt(i));
					j = 0;
					break;
				}
			}
		}
		return word;
	}
}
