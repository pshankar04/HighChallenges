package LeetCode;

import java.util.HashMap;
import java.util.Scanner;

public class Solution13 {

	public static HashMap<String,Integer> romanCatalogue = new HashMap<String,Integer>();
	static{
		romanCatalogue.put("M",1000);
		romanCatalogue.put("D",500);
		romanCatalogue.put("C",100);
		romanCatalogue.put("L",50);
		romanCatalogue.put("X",10);
		romanCatalogue.put("V",5);
		romanCatalogue.put("I",1);
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Number is :"+romanToInt(input.nextLine()));

	}
	
	public static int romanToInt(String str){
		int sum = 0;
		for(int i = str.length() - 1 ; i >= 0 ; i--){
			if((i != str.length() - 1) && (romanCatalogue.get(String.valueOf(str.charAt(i))) < romanCatalogue.get(String.valueOf(str.charAt(i+1))))){
				sum = sum - romanCatalogue.get(String.valueOf(str.charAt(i)));
			}else{
			sum = sum + romanCatalogue.get(String.valueOf(str.charAt(i)));
			}
		}
		return sum;
		
	}
	
	 

}
