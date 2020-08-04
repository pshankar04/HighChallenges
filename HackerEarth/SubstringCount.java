package HackerEarth;
import java.util.ArrayList;
import java.util.Scanner;

public class SubstringCount {
	public static ArrayList<String> al = new ArrayList<String>();
	public static ArrayList<String> stringList = new ArrayList<String>();
	public static void main(String[] args) {
		String string = "";
		Scanner integerInput = new Scanner(System.in);
		Scanner strInput = new Scanner(System.in);	
		int testcases = integerInput.nextInt();
		if(testcases != 0){
			for(int i = 0 ; i < testcases ; i++){
				string  = strInput.nextLine().trim();
				 if((string.trim()).length() > 0){
					stringList.add(string);
				}
				string = "";
			}
			 
			if(stringList.size() == testcases){
				for(String s : stringList){
					formSubstrings(s);
				}
			}else{
				System.out.println(0);
			}
		}else{
			System.out.println(0);
		}
		integerInput.close();
		strInput.close();
	}


	public static void formSubstrings(String str){

		String sub;
		for( int c = 0 ; c < str.length() ; c++ )
		{
			for( int i = 1 ; i <= str.length() - c ; i++ )
			{
				sub = str.substring(c, c+i);
				al.add(sub);
			}
			sub = "";
		}
		System.out.println(findIncompleteSubs(al));
		al = new ArrayList<String>();
	}

	public static int findIncompleteSubs(ArrayList<String> al){
		int count = 0;
		for(String str : al){
			if( str.contains("a") && str.contains("b") && str.contains("c")) {
				count++;
			}
		}
		return (al.size() - count);
	}
}
