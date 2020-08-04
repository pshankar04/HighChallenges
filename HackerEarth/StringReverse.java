package HackerEarth;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class StringReverse {
	public static LinkedHashSet<String> stringSet ;
	
	public static void main(String[] args) {
		 Scanner input = new Scanner(System.in);
		 int tc = Integer.parseInt(input.nextLine());
		 stringSet = new LinkedHashSet<String>();
		 for(int i = 0 ; i < tc ; i++){
			 stringSet.add(input.nextLine());
		 }
		 for(String s : stringSet){
			 System.out.println(reverseNow(s));
		 }
		 input.close();
	}

	public static String reverseNow(String s){
		String temp = "";
		for(int i = s.length() - 1 ; i >= 0 ; i--){
			temp = temp + s.charAt(i);
		}
		return temp;
	}
}
