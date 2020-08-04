package HackerRank2019;

import java.util.Scanner;

public class RepeatedString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int n = Integer.parseInt(in.nextLine());
		
		System.out.println("Total Count is :"+repeatedString(s,n));
		in.close();

	}

	static long repeatedString(String s, long n) {
		
		String addendum = "";
		long count = 0, repeatCount = 0, aCount = 0, totalCount = 0;
		long additionalCharacterLength = (n % (s.length()));
		System.out.println(additionalCharacterLength);
		repeatCount = n/s.length();
		for(int i = 0 ; i < s.length() ; i++){
			if(s.charAt(i) == 'a'){
				aCount += 1;
			}
		}
		totalCount = repeatCount * aCount;
		
		
		for(int i = 0 ; i < additionalCharacterLength ; i++){
			addendum = addendum + s.charAt(i);
		}
		for(int i = 0 ; i < addendum.length() ; i++){
			if(addendum.charAt(i) == 'a'){
				count += 1;
			}
		}
		totalCount = totalCount + count;
		return totalCount;
	}

}
