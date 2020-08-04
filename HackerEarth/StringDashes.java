package HackerEarth;

import java.util.HashMap;
import java.util.Scanner;

public class StringDashes {
	public static HashMap<String,Integer> charCountMap = new HashMap<String,Integer>();
	
	static{
		charCountMap.put("0", 6);
		charCountMap.put("1", 2);
		charCountMap.put("2", 5);
		charCountMap.put("3", 5);
		charCountMap.put("4", 4);
		charCountMap.put("5", 5);
		charCountMap.put("6", 6);
		charCountMap.put("7", 3);
		charCountMap.put("8", 7);
		charCountMap.put("9", 6);
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String number = input.nextLine();
		int count = 0;
		for(int i = 0 ; i < number.length() ; i++){
			count = count + charCountMap.get(number.charAt(i)+"");
		}
		System.out.println(count);
		input.close();
	}

}
