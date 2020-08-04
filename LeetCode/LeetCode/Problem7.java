package LeetCode;

import java.util.Scanner;

public class Problem7 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long number = input.nextLong();
		System.out.println("Converted String is :"+reverse(number));


	}

	public static long reverse(long x){
		String convertedString = "";
		String number = String.valueOf(x);
		if(number.length() > 1){
			char[] integer = number.toCharArray();
			if(integer[0] == '-' || integer[0] == '+'){
				convertedString = integer[0]+"";
				for(int i = integer.length - 1;i >= 1 ; i--){
					convertedString = convertedString + integer[i];
				}
				return (new Long(convertedString)).longValue();
			} else{
				for(int i = integer.length - 1;i >= 0 ; i--){
					convertedString = convertedString + integer[i];
				}
				return (new Long(convertedString)).longValue();
			}
			 
		}else if(number.length() == 1){
			return new Long(number);
		}return 0;
		
	}
}
