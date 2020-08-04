package CareerCup;

import java.util.Scanner;

public class CaseConversion {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		String temp = "";
		for(int i = 0 ; i < str.length() ; i++){
			if(((int)(str.charAt(i)) >= 65) && ((int)(str.charAt(i)) < 91)){
				temp = temp + (char)(32 + (int)str.charAt(i));
			}else if(((int)(str.charAt(i)) >= 91) && ((int)(str.charAt(i)) < 123)){
				temp = temp + (char)((int)str.charAt(i) - 32);
			}
		} 
		System.out.println(temp);
		input.close();
	}

}

