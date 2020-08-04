package HackerRank;

 
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SubStringPalindromeCount {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		 
		if(input.length() > 0)
			System.out.println(palindrome(input));

		else
			System.out.println(0);

		in.close();
	}

	public static int palindrome(String str){
		LinkedHashSet<String> subStringSet = new LinkedHashSet<String>();
		String sub;
		if(str.length() > 0){
			for( int c = 0 ; c < str.length() ; c++ )
			{
				for( int i = 1 ; i <= str.length() - c ; i++ )
				{
					sub = str.substring(c, c+i);
					if(isPalindrome(sub)){
						subStringSet.add(sub);
					}
				}
				sub = "";
			}
			return subStringSet.size();
		}
		else
			return 0;
	}

	public static boolean isPalindrome(String str){
		String pali = "";
		
		for(int i = str.length()-1 ; i >= 0 ; i--){
			pali = pali + str.charAt(i);
		}
		if(pali.equals(str)){
			return true;
		}else{
			return false;
		}
	}
}

