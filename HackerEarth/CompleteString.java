package HackerEarth;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class CompleteString {
	public static LinkedHashSet<String> words;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		words = new LinkedHashSet<String>();
		for(int i = 0 ; i < tc ; i++){
			words.add(input.nextLine());
		}
		for(String s : words){
			System.out.println(checkCompletness(s));
		}
		input.close();
	}

	public static String checkCompletness(String word){
		HashSet<String> charSet = new HashSet<String>();
		for(int i = 0 ; i < word.length() ; i++){
			charSet.add(word.charAt(i)+"");
		}
		if(charSet.size() == 26){
			return "YES";
		}else{
			return "NO";
		}
	}
}
