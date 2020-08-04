package HackerEarth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MagicalWords {
	public static HashMap<String,Long> wordMap = new HashMap<String,Long>();
	public static ArrayList<String> wordsList  = new ArrayList<String>();

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		long count = 0;

		for(int i = 0 ; i < tc ; i++){
			wordsList.add(input.nextLine().trim());	
		}
		for(String word : wordsList){
			if(wordMap.containsKey(word)){
				System.out.println(wordMap.get(word));
			}else if(wordMap.containsKey(new String(new StringBuilder(word).reverse()))){
				System.out.println(wordMap.get(new String(new StringBuilder(word).reverse())));
			}else{
				//count = formSubstrings(word);
				formSubstrings(word);
				wordMap.put(word,count);
				System.out.println(count);
			}
		}

		input.close();
	}

	public static long formSubstrings(String str){
		String sub = "";
		long count = 0 ; 
		int sublength = 0 ; 

		for( int c = 0 ; c < str.length() ; c++ )
		{
			for( int i = 1 ; i <= str.length() - c ; i++ )
			{
				sub = str.substring(c, c+i);
				if(isPalindrome(sub)){
					sublength = sub.length();
					count = count + (sublength * sublength);
				}
			}
		}
		sub = "";	

		return count;
	}

	public static boolean isPalindrome(String s) {
		int n = s.length();
		for (int i=0;i<(n / 2);++i) {
			if (s.charAt(i) != s.charAt(n - i - 1)) {
				return false;
			}
		}
		return true;
	}
}
