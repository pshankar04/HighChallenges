package HackerRank;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SuperFunctionalStrings {
	public static LinkedHashSet<String> subStringSet;
	public static LinkedHashSet<String> stringSet = new LinkedHashSet<String>();

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		long sum = 0;
		
		if(tc <= 100){
			for(int i = 0 ; i < tc ; i++){
				stringSet.add(input.nextLine());	
			}
			for(String s : stringSet){
				subStringSet = formSubstrings(s);
				for(String sub : subStringSet){
					sum = sum + summation(sub);
				}
				System.out.println(sum);
				sum = 0;
			}
		}
		
		input.close();
	}

	public static long summation(String subStr){

		double value = Math.pow(Double.valueOf(subStr.length()), Double.valueOf(distinctCharItems(subStr)));
		return (((new Double(value)).longValue()) % 1000000007);

	}

	public static int distinctCharItems(String s){
		HashSet<String> uniqueCharsSet = new HashSet<String>();
		for(int i = 0 ; i < s.length() ; i++){
			uniqueCharsSet.add(s.charAt(i)+"");
		}
		return uniqueCharsSet.size();
	}


	public static LinkedHashSet<String> formSubstrings(String str){
		LinkedHashSet<String> stringSet = new LinkedHashSet<String>();
		String sub;
		if(str.length() > 0){
			for( int c = 0 ; c < str.length() ; c++ )
			{
				for( int i = 1 ; i <= str.length() - c ; i++ )
				{
					sub = str.substring(c, c+i);
					stringSet.add(sub);
				}
				sub = "";
			}
			return stringSet;
		}
		else
			return stringSet;
	}
}
