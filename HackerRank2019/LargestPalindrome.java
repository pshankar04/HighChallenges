package HackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class LargestPalindrome {

	public static void main(String[] args) {
		long number = 0;
		LinkedList<Long> numberList = new LinkedList<Long>();
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		if(tc >= 1 && tc <= 100){
			for(int i = 0 ; i < tc ; i++){
				number = Long.parseLong(input.nextLine());
				if(number > 101101 && number < 1000000101101l){
					numberList.add(number);
				}
			}
		}
		for(Long l : numberList){
			System.out.println(findLargestPalindrome(l));
		}
		input.close();
	}

	public static long findLargestPalindrome(long number){
		ArrayList<Long> largePalList = new ArrayList<Long>();
		long mul = 1l;
		 
		for(int i = 100 ; i < 1000  ; i++){
			for( int j = 100 ; j < 1000 ;j++){
				mul = (i * j);
				if(mul > number){
					break;
				}else if(mul < number){
					if(isPalindrome(mul)){
						largePalList.add(mul);
					}
				}
			}
		}
		return Collections.max(largePalList);
	}

	public static boolean isPalindrome(long number){
		String num = String.valueOf(number);
		if(String.valueOf(number).equals(new String(new StringBuffer(num).reverse()))){
			return true;
		}else{
			return false;
		}
	}
}
