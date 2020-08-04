package HackerEarth;

import java.util.Scanner;

public class ToggleString {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		String temp = "";
		for(int i = 0 ; i < str.length() ; i++){
			int c = str.charAt(i);
			if(c >= 65 && c <= 90){
				temp = temp + String.valueOf(str.charAt(i)).toLowerCase();	
			}else if(c >= 91 && c <= 123){
				temp = temp + String.valueOf(str.charAt(i)).toUpperCase();
			}
		}
		System.out.println(temp);
		input.close();
	}

}
