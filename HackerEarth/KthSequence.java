package HackerEarth;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class KthSequence {
	public static char[] chars = {'O','Z'};
	public static LinkedHashSet<String> charSet = new LinkedHashSet<String>();

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		if(tc >=1 && tc <= 100){
			String[] series ;
			for(int i = 0 ; i < tc ; i++){
				series = input.nextLine().split(" ");
				if(Integer.parseInt(series[0]) >= 1 && Integer.parseInt(series[0]) <= 1000 && (Integer.parseInt(series[1]) >= 1)){
					saveCharacters(chars,"",chars.length,Integer.parseInt(series[0]));
					removeDuplicates(charSet);
					Collections.sort(new LinkedList<String>(charSet)); 
					System.out.println((new LinkedList<String>(charSet)).get(Integer.parseInt(series[1])-1));
				}
			}
		}
		input.close();
	}

	static void saveCharacters(char set[], String prefix, int n, int len) {

		if (len == 0) {
			charSet.add(prefix);
			return;
		}

		for (int index = 0; index < n; ++index) {
			String beginStr = prefix + set[index]; 
			saveCharacters(set, beginStr, n, len - 1); 
		}
	}

	public static void removeDuplicates(LinkedHashSet<String> charsSet){
		LinkedHashSet<String> cSet = new LinkedHashSet<String>(charsSet);
		for(String s : cSet){
			for(int i = 0 ; i < s.length() ; i++){
				if(((i+1) < s.length()) && (s.charAt(i) == 'Z') && (s.charAt(i) == s.charAt(i+1))){
					charsSet.remove(s);
					break;
				}
			}
		}
	}

}
