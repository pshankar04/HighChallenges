package CodeEvalModerate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DecodePairCount {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		 String strInput = in.nextLine();
		 System.out.println(findPairs(pairCount(strInput)));
		 in.close();

	}

	
	public static ArrayList<String> pairCount(String str){
		String sub = "";
		ArrayList<String> al = new ArrayList<String>();
		
		for( int c = 0 ; c < str.length() ; c++ )
		{
			for( int i = 1 ; i <= str.length() - c ; i++ )
			{
				sub = str.substring(c, c+i);
				al.add(sub);
			}
			sub = "";
		}
		return al;
	}
	
	public static int findPairs(ArrayList<String> strList){
		int digit = 0, count = 0;
		for(String s : strList){
			digit = Integer.parseInt(s);
			System.out.println(digit);
			if(digit <= 26){
				count++;
			}
		}
		return count + 1;
	}
}
