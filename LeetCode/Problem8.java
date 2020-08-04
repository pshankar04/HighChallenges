package LeetCode;

import java.util.Scanner;

public class Problem8 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String strInput = input.nextLine();
		long output = myAtoi(strInput);
		//int b = 2 + output;
		System.out.println("Output is :"+output);
	}
	
	public static long myAtoi(String str) {
		if(str.equals("")) return 0;
		try{
			str = str.trim();
		return checkForOtherChars(str);
		}catch(NumberFormatException ne){
			return 0;
		}
	}
	
	
	public static long checkForOtherChars(String string){
		char[] chars = string.toCharArray();
		String temp = "";
		for(int i = 0 ; i< chars.length ; i++){
			if(((chars[i] == '-') || (chars[i] == '+') || ((Character.getNumericValue(chars[i]) >= 0) && (Character.getNumericValue(chars[i]) <= 9)))){
				temp = temp + chars[i];
			}else if(chars[i] == ' '){
				break;
			}
			else if((int)chars[i] > 65 && (int)chars[i] < 123){
				break;
			}
			System.out.println("temp: "+temp);
		}
		
		return (new Integer(temp)).longValue();
	}

}
