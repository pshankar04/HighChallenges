package HackerRank;

import java.util.ArrayList;
import java.util.Scanner;

public class NumericString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String numString = in.nextLine();
		int subStringLength = in.nextInt();
		int base = in.nextInt();
		int modulus = in.nextInt();

		System.out.println(getMagicNumber(numString,subStringLength,base,modulus));
		in.close();

	}

	public static int getMagicNumber(String s,int k, int b , int m){

		ArrayList<String> al = new ArrayList<String>();
		 
		int sum = 0;
		int toBase = 0 ;
		al = findSubStrings(s,k);
		for(String st : al){
			toBase = Integer.parseInt(st, b);
 			sum = sum + (toBase % m);
		}
		 
		return sum;
	}

	public static ArrayList<String> findSubStrings(String str , int len){
		ArrayList<String> al = new ArrayList<String>();
		String sub;
		
		for( int c = 0 ; c < str.length() ; c++ )
		{
			for( int i = 1 ; i <= str.length() - c ; i++ )
			{
				sub = str.substring(c, c+i);
				if(sub.length() == len){
					al.add(sub);
				}
			}
			sub = "";
		}
		return al;
	}
}
