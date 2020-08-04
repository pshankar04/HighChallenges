package HackerRank;

import java.util.HashSet;
import java.util.Scanner;

public class StringDifference {

	public static HashSet<String> stringSet;
	public static void main(String[] args) {
		stringSet = new HashSet<String>();
		Scanner input = new Scanner(System.in);
		String series = input.nextLine();
		String str1 = series.split(" ")[0];
		String str2 = series.split(" ")[1];
		if(str1.length() > 0 && str2.length() > 0){
			stringSet = formSubStrings(str1,str2.length());
			System.out.println(findDiffStringCount(stringSet,str2));
		}
		input.close();

	}


	public static HashSet<String> formSubStrings(String str,int len){
		HashSet<String> subStringSet = new HashSet<String>();
		String sub;
		if(str.length() > 0){
			for( int c = 0 ; c < str.length() ; c++ )
			{
				for( int i = 1 ; i <= str.length() - c ; i++ )
				{
					sub = str.substring(c, c+i);
					if(sub.length() == len){
						subStringSet.add(sub);
					}
				}
				sub = "";
			}
		}
		return subStringSet;
	}

	public static int findDiffStringCount(HashSet<String> strSet , String str){
		 
		int count = 0;
		int diffCount = 0;
		for(String s : strSet){
			for(int i = 0 ; i < s.length() ; i++){
				if(s.charAt(i) != str.charAt(i)){
					count++;
				}
			}
			 
			if(count == 1){
				diffCount++;
			}
			count = 0;
		}
		return diffCount;
	}

}
