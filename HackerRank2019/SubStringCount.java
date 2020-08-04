package HackerRank;

import java.util.HashSet;
import java.util.Scanner;

public class SubStringCount {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		System.out.println("INPUT LENGTH : "+input.length());
		if(input.length() > 0)
			System.out.println(formSubstrings(input));
		else
			System.out.println(0);

		in.close();
	}



	public static long formSubstrings(String str){
		HashSet<String> subStringSet = new HashSet<String>();
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
			return subStringSet.size();
		}
		else
			return 0;
	}

}
