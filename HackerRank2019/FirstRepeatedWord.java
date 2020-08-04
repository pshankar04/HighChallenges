package HackerRank;

import java.util.LinkedList;
import java.util.Scanner;

public class FirstRepeatedWord {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		System.out.println(firstRepeatedWord(s));
		input.close();
	}

	public static String firstRepeatedWord(String s){
		boolean found = false;
		String temp = "" , repeatedWord = "";
		LinkedList<String> wordsList = new LinkedList<String>();
		int lastIndex = 0;

		for(int i = 0 ; i < s.length() ; i++){
			if((s.charAt(i) == ' ') || (s.charAt(i) == '\t') || (s.charAt(i) == ',') || (s.charAt(i) == ':') || (s.charAt(i) == ';') || (s.charAt(i) == '-') ||
					(s.charAt(i) == '/') || (s.charAt(i) == '.')){
				temp = s.substring(lastIndex,i);
				wordsList.add(temp.trim());
				temp = "";
				lastIndex = i;
			}

		}

		for(int i = 0 ; i < wordsList.size() ; i++){
			if(!found){
				for(int j = 0 ; j < wordsList.size() ; j++){
					if(i == j){
						continue;
					}else{
						if(wordsList.get(i).equals(wordsList.get(j))){
							repeatedWord = wordsList.get(i);
							found = true;
							break;
						}
					}
				}
			}
		}
		return repeatedWord;
	}
}
