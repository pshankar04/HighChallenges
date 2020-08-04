package CodeEvalModerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReversePalindrome {

	public static void main(String[] args) {

		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.length() > 0)) {
				checkPalindrome(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void checkPalindrome(String number){
		 int count = 0;
		while(!isPalindrome(number) && (count < 100)){
			number = addToReverse(number);
			count++;
		}
		 
		System.out.println(count +" "+number);
	}
	
	public static boolean isPalindrome(String word){
		return (word.equals(new String(new StringBuffer(word).reverse()))) ? true : false;
	}
	
	public static String addToReverse(String num){
		 
		long realNumber = Long.parseLong(num); 
		long revNumber = Long.parseLong(new String(new StringBuffer(num).reverse()));

		return  String.valueOf(realNumber + revNumber);
	}
}
