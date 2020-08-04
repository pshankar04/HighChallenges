package Serials;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class StringTest {

	public static void main(String[] args) throws IOException {
		String line1Cap = "";
		String line2Cap = "";
		String line1 = "",line2 = "";
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		line1 = br1.readLine();
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		line2 = br2.readLine();

		line2Cap = capitalize(line2);
		line1Cap = capitalize(line1);
		 
		String b = checkOrder(line1,line2);
		int number = line1.length() + line2.length();
		System.out.println(number);
		System.out.println(b);
		System.out.println(line1Cap+" "+line2Cap);


	}

	public static String capitalize(String text){
		if(text.equals(""))
			return "";
		else{
			String firstChar = (text.charAt(0)+"").toUpperCase();
			 for(int  i = 0 ;i < text.length() ; i++){
				 if(i == 0){
					 continue;
				 }
				 else{
					 firstChar = firstChar + text.charAt(i);
				 }
			 }
			 return firstChar;
		}
	}

	public static String checkOrder(String one,String two){
		if(two.compareTo(one) < 0){
			return "Yes";
		}else{
			return "No";
		}
	}

}
