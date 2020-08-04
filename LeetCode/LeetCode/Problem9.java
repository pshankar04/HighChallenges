package LeetCode;

import java.util.Scanner;

public class Problem9 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//String tmp = input.nextLine();
		int sample = input.nextInt();
		System.out.println("Number is a Palindrome : "+isPalindrome(sample));
		
	}
	
	public 	static boolean isPalindrome(int x){
		String tmp = String.valueOf(x);
		String chars  = "";
		for(int i = (tmp.length() - 1) ; i >= 0 ; i--){
			chars = chars + tmp.charAt(i);
		}
		
		if(tmp.equals(chars))
			return true;
		
		else{
			return false;
		}
		 
	}

}
