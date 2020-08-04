package HackerRank;

import java.util.Scanner;

public class HRStringReverse {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		if(str.length() != 0)
		System.out.println(reverseString(str));

	}
	
	public static String reverseString(String str){
		String temp = "";
		for(int i = str.length() - 1 ; i>=0 ;i--){
			temp = temp + str.charAt(i);
		}
		if(temp.equals(str)) return "Yes";
		else return "No";
		
	}

}
