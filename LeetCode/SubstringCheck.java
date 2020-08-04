package SPOJ;


import java.util.HashSet;
import java.util.Scanner;

public class SubstringCheck {
	public static HashSet<String> subStringSet ; 

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String data = "";
		for(int i = 0 ; i < 2 ; i++){
			data = input.nextLine();
			//			subStringSet = new HashSet<String>();
			//			subStringSet = formSubstrings(data.split(" ")[0]);
			//			if(subStringSet.contains(data.split(" ")[1])){
			//				System.out.println(1);
			//			}else{
			//				System.out.println(0);
			//			}
			if(data.split(" ")[0].contains(data.split(" ")[1])){
				System.out.println(1);
			}else{
				System.out.println(0);
			}
		}
		input.close();
	}

	public static HashSet<String> formSubstrings(String str){
		HashSet<String> subSet = new HashSet<String>();
		String sub;
		for( int c = 0 ; c < str.length() ; c++ )
		{
			for( int i = 1 ; i <= str.length() - c ; i++ )
			{
				sub = str.substring(c, c+i);
				subSet.add(sub);
			}
			sub = "";
		}
		return subSet;
	}

}
