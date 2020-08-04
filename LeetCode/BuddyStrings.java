package TestRun;

import java.util.Scanner;

public class BuddyStrings {

	
	    public static boolean buddyStrings(String A, String B) {
	        if (A.length() != B.length()) return false;
	        if (A.equals(B)) {
	            int[] count = new int[26];
	            for (int i = 0; i < A.length(); ++i)
	                count[A.charAt(i) - 'a']++;

	            for (int c: count)
	                if (c > 1) return true;
	            return false;
	        } else {
	            int first = -1, second = -1;
	            for (int i = 0; i < A.length(); ++i) {
	                if (A.charAt(i) != B.charAt(i)) {
	                    if (first == -1)
	                        first = i;
	                    else if (second == -1)
	                        second = i;
	                    else
	                        return false;
	                }
	            }

	            return (second != -1 && A.charAt(first) == B.charAt(second) &&
	                    A.charAt(second) == B.charAt(first));
	        }
	    }
	

public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	String str1 = in.nextLine();
	String str2 = in.nextLine();
	
	if(buddyStrings(str1,str2)){
		System.out.println("YES");
	}else{
		System.out.println("NO");
	}
}	
}

