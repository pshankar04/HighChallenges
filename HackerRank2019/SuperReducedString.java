package HackerRank;

import java.util.Scanner;

public class SuperReducedString {
	public static String word = "";
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		word = input.nextLine();
		while(word.length() >= 2){
			if(adjacentDuplicates(word)){
				word = removeDuplicates(word);
			}else{
				System.out.println(word);
				break;
			}
		}
		if(word.length() == 0){
			System.out.println("Empty String");
		}
		input.close();
	}

	public static boolean adjacentDuplicates(String str){
		boolean dupExist = false;
		for(int i = 0 ; i < str.length() ; i++){
			if(((i + 1) < str.length()) && (str.charAt(i) == str.charAt(i + 1))){
				dupExist = true;
				break;
			}
		}
		return dupExist;
	}

	public static String removeDuplicates(String str){
		String temp = "";
		for(int i = 0 ; i < str.length() ; i++){
			if(((i + 1) < str.length()) && (str.charAt(i) == str.charAt(i + 1))){
				temp = replaceNow(str,i);
				break;
			}
		}
		return temp;
	}

	public static String replaceNow(String s , int index){
		String tempo = "";
		for(int i = 0 ; i < s.length() ; i++){
			if((i != index) && (i != (index + 1))){
				tempo = tempo + s.charAt(i);
			}
		}

		return tempo;
	}
}
