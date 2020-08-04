package Arrays;

import java.util.HashSet;
import java.util.Scanner;

public class PalindromicPartition {

	public static HashSet<String> subStringSet = new HashSet<String>();

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		formSubstrings(str);

		for(int i = 0 ; i < str.length() ;i++){
			System.out.print(str.charAt(i)+" ");
		}
		System.out.println();
		for(String s : subStringSet){
			if(s.length() > 1 && checkPalindrome(s) && (s.length() != str.length())){
				System.out.println(str.substring(0,str.indexOf(s)) + " " + s + " " +str.substring(s.length() + str.indexOf(s)));
			}
		}
		if(checkPalindrome(str)){
			System.out.println(str);
		}
		input.close();
	}

	public static boolean checkPalindrome(String st){

		String temp = new String(new StringBuilder(st).reverse());
		if(st.equals(temp)){
			return true;
		}else{
			return false;
		}

	}

	public static void formSubstrings(String str){

		String sub;
		if(str.length() > 0){
			for( int c = 0 ; c < str.length() ; c++ )
			{
				for( int i = 1 ; i <= str.length() - c ; i++ )
				{
					sub = str.substring(c, c+i);
					subStringSet.add(sub);
				}
				sub = "";
			} 
		} 
	}
}
