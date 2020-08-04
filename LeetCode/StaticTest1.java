package Serials;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StaticTest1 extends StaticTest{

	public static String Check(){
		 return "Inside StaticTest2222222222";
	 }
	
	public static void main(String[] args) throws IOException {
 
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br1.readLine();
        String line1Cap = capitalize(line1);
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        String line2 = br2.readLine();
        String line2Cap = capitalize(line2);
        
        int number = line1.length() + line2.length();
        System.out.println(number);
        System.out.println(line1Cap+" "+line2Cap);
        
        
	}
	
	public static String capitalize(String text){
		return text.replace(text.charAt(0)+"",((text.charAt(0))+"").toUpperCase());
	}

}
