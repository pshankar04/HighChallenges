package HackerEarth;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class PalindromicNumbers {
	public static LinkedHashSet<String> numberSet;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		numberSet = new LinkedHashSet<String>();
		for(int i = 0 ; i < tc ; i++){
			numberSet.add(input.nextLine());
		}
		for(String s : numberSet){
			printPalindromes(s);
		}
		input.close();
	}

	public static void printPalindromes(String series){
		long start = Integer.parseInt(series.split(" ")[0]);
		long end = Integer.parseInt(series.split(" ")[1]);
		int count = 0;
		for(long i = start ; i <= end ; i++){
			if(isPalindrome(i)){
				 count++;
			}
		}
		System.out.println(count);
	}
	
	public static boolean isPalindrome(long num){
		String number = String.valueOf(num);
		String reverseNumber = new String((new StringBuilder(number)).reverse());
		if(number.equals(reverseNumber)){
			return true;
		}else{
			return false;
		}
	}
}
