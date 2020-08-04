package HackerRank;

import java.util.HashSet;
import java.util.Scanner;

public class SubStringMatch {

	public static String[] input;
	public static String[] output;
	public static HashSet<String> subStringSet;
	public static void main(String[] args) {
		Scanner intInput = new Scanner(System.in);
		Scanner strInput = new Scanner(System.in);
		int testcases = intInput.nextInt();
		input = new String[testcases];
		output = new String[testcases];
		for(int i = 0 ; i < testcases ; i++){
			input[i] = strInput.nextLine();
			output[i] = strInput.nextLine();
		}
		//System.out.println("SIZE : "+input.length+ " "+output.length);
		if(input.length > 0 && output.length > 0 && (input.length == output.length)){
		checkForSubstrings(input,output);
		}
		else{
			System.out.println("Provide Proper inputs");
		}
		
		strInput.close();
		intInput.close();
	}


	public static void checkForSubstrings(String[] inn,String[] out){
		 
			for(int k = 0 ; k < inn.length ; k++){
				if(formSubStrings(inn[k]).contains(out[k])){
					System.out.println("YES");
				}else{
					System.out.println("NO");
				}
				
			}
		} 
	


	public static HashSet<String> formSubStrings(String str){
		subStringSet = new HashSet<String>();
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

		}
		return subStringSet;
	}

}
