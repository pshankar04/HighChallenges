package HackerRank;

import java.util.ArrayList;
import java.util.Scanner;

public class BeautifulWord {

	 
	public static ArrayList<String> al = new ArrayList<String>();
	static{
		al.add("a"); al.add("e"); al.add("i"); al.add("o"); al.add("u"); al.add("y"); 
	}
	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		 String input = in.nextLine();
		  
		 if(checkString(input)){
			 System.out.println("Yes");
		 }else{
			 System.out.println("No");
		 }
		 in.close();
	}

	public static boolean checkString(String str){
		 
		for(int i = 1 ; i < str.length() ; i++){
			if(str.charAt(i) == str.charAt(i - 1)){
				return false;
			}else if(al.contains(str.charAt(i)+"") && al.contains(str.charAt(i - 1)+"")){
				return false;
			}
		}
		return true;
	}
}
