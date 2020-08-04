package HackerEarth;

import java.util.LinkedList;
import java.util.Scanner;

public class LuckyStrings {
	public static LinkedList<String> strList ;

	public static void main(String[] args) {
		strList = new LinkedList<String>();
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		for(int i = 0 ; i < tc ; i++){
			strList.add(input.nextLine());
		}
		for(String s : strList){
			findLuck(new StringBuilder(s));
		}
		input.close();
	}

	public static void findLuck(StringBuilder sb){
		int countOfR = 0 , countOfK = 0;
		StringBuilder copyOfSb = new StringBuilder(sb);
		for(int i = 0 ; i < sb.length() ; i++){
			if((i == 0) && (sb.charAt(i) == 'K')){
				copyOfSb.deleteCharAt(i);
			}else if(sb.charAt(i) == 'R'){
				countOfR++;
			}else{
				countOfK++;
			}

			if(countOfR < countOfK){
				copyOfSb.deleteCharAt(i);
			}
		}
		System.out.println(copyOfSb);
	}
}
