package HackerRank;

import java.util.Scanner;

public class EachCharacterCount {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		int[] chars = new int[65535];
		for(int i = 0 ; i < str.length() ; i++){
			char c = str.charAt(i);
			chars[c]++;
		}
		for(int i = 0 ; i < chars.length ; i++){
			if(chars[i] >= 1){
				System.out.println((char)i+" "+chars[i]);
			}
		}
		input.close();
	}

}
