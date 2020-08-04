package Arrays;

import java.util.Scanner;

public class ReverseStringsWithoutSpecialCharacters {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine() ;
		String reverseTemp = "";
		String temp = "";
		String finalStr = "";
		int l = 0;
		for(int i = 0 ; i < str.length() ; i++){
			if(Character.isAlphabetic(str.charAt(i))){
				temp  =  temp+ str.charAt(i);
			}
		}
		reverseTemp = new String(new StringBuilder(temp).reverse());
		
		for(int k = 0 ; k < str.length() ; k++){
			if(Character.isAlphabetic(str.charAt(k))){
				finalStr = finalStr + reverseTemp.charAt(l);
				l++;
			}else{
				finalStr = finalStr + str.charAt(k);
			}
		}
		 
			System.out.println(finalStr);
		
		input.close();
	}

}
