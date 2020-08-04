package HackerEarth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RoysLifeCycle {

	public static String longestStreak = ""; 
	public static ArrayList<Integer> maxCountList = new ArrayList<Integer>();
	public static ArrayList<Integer> continueCountList = new ArrayList<Integer>();
	public static int endCount = 0 , startCount = 0 , lastlineNumber = 0;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int total = Integer.parseInt(input.nextLine());
		for(int i = 0 ; i < total ; i++){
			findMaxStreak(input.nextLine() , i , total);
		}
		System.out.print(Collections.max(maxCountList)+" "+Collections.max(continueCountList));
		 
		input.close();
	}

	public static void findMaxStreak(String codestreak , int lineNumber , int totalLines){
		 
		ArrayList<Integer> countList = new ArrayList<Integer>();
		int index = 0 , count = 0;
		index = codestreak.indexOf('C');
		startCount = index;
		while(index < codestreak.length()){
			while(codestreak.charAt(index) == 'C'){
				count++;
				index++;
				if(index >= codestreak.length()){
					break;
				}
			}
			if(startCount == 0 && lineNumber > 0 && lineNumber < totalLines && ((lineNumber - lastlineNumber) == 0)){
				endCount = endCount + count;
				continueCountList.add(endCount);
				startCount = index;
				endCount = 0;
			}
			countList.add(count);
			if(index == 1440){
				endCount = endCount + count;
			}
			count = 0;
			index++;
		}
		lastlineNumber++;
		maxCountList.add(Collections.max(countList));
	}

	 
}
