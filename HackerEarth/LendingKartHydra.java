package HackerEarth;


import java.util.HashMap;
import java.util.Scanner;

public class LendingKartHydra {
	public static HashMap<String,Long> countMap ; 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		String word = "" , password = "" , line = "";
		for(int i = 0 ; i < tc ; i++){
			line = input.nextLine();
			word = line.split(" ")[0];
			password = line.split(" ")[1];

			if(isMatching(word,password)){
				System.out.println("Possible");
			}else{
				System.out.println("ImPossible");
			}
		}
		input.close();
	}

	public static boolean isMatching(String first , String second){

		if((second.length() % first.length()) == 0){
			countMap = formSubstrings(second,first);
			if(countMap.get(first) == 1){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}

	public static HashMap<String,Long> formSubstrings(String str,String word){

		HashMap<String,Long> wordCountMap = new HashMap<String,Long>();
		long value = 1;
		String sub;
		for( int c = 0 ; c < str.length() ; c++ )
		{
			for( int i = 1 ; i <= str.length() - c ; i++ )
			{
				sub = str.substring(c, c+i);
				if(wordCountMap.containsKey(sub) && sub.contains(word)){
					wordCountMap.put(sub,wordCountMap.get(sub) + 1);
				}else if(sub.contains(word)){
					wordCountMap.put(sub,new Long(value));
				}
			}
			sub = "";
		}
		return wordCountMap;
	}
}
