package HackerEarth;

import java.util.LinkedList;
import java.util.Scanner;

public class PalindromePassword {
	public static LinkedList<String> passwordSet;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		passwordSet = new LinkedList<String>();
		for(int i = 0 ; i < tc ; i++){
			passwordSet.add(input.nextLine());
		}
		findPassword();
		input.close();
	}

	public static void findPassword(){
		 
		boolean found = false;
		for(int i = 0 ; i < passwordSet.size() ; i++){
			if(!found){
				for(int j = 0 ; j < passwordSet.size() ; j++){
					if(i == j) {
						continue;
					}else{
						if(arePalindromes(passwordSet.get(i),passwordSet.get(j))){
							found = true;
							printResult(passwordSet.get(i));
							break;
						}
					}
				}
			}
		}
	}
	
	public static boolean arePalindromes(String s1 , String s2){
		String temp = "";
		temp = new String((new StringBuilder(s2)).reverse());
		if(temp.equals(s1)){
			return true;
		}else{
			return false;
		}
	}
	
	public static void printResult(String s){
		int mid = s.length()/2;
		System.out.println(s.length()+" "+s.charAt(mid));
	}
}
