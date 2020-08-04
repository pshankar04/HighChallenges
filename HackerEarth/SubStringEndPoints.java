package HackerEarth;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class SubStringEndPoints {
	public static LinkedList<String> queryList;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long tc = Long.parseLong(input.nextLine());
		String word = input.nextLine();
		queryList = new LinkedList<String>();
		int totalQueries = Integer.parseInt(input.nextLine());
		for(int i = 0 ; i < totalQueries ; i++){
			queryList.add(input.nextLine());
		}
		for(String s : queryList){
			System.out.println(formSubstrings(word,s.toCharArray()[0],s.toCharArray()[2]));
		}
		input.close();
	}

	public static long formSubstrings(String str , char first , char second){
		HashSet<String> subStringSet = new HashSet<String>();
		String sub;
		if(str.length() > 0){
			for( int c = 0 ; c < str.length() ; c++)
			{
				for( int i = 1 ; i <= str.length() - c ; i++)
				{
					sub = str.substring(c, c+i);
					if((sub.length() > 1) && ((sub.charAt(0) == first) && (sub.charAt(sub.length() - 1) == second)) || 
							((sub.charAt(0) == second) && (sub.charAt(sub.length() - 1) == first))){
						subStringSet.add(sub);
					}
				}
				sub = "";
			}
			return subStringSet.size();
		}
		else{
			return 0;
		}
	}
}
