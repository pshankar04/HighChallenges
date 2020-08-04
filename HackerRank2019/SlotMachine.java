package HackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SlotMachine {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int total = Integer.parseInt(input.nextLine());
		String[] spins = new String[total];
		for(int i = 0 ; i < total ; i++){
			spins[i] = input.nextLine();
		}
		diceGame(spins);
		input.close();
	}

	public static void diceGame(String[] series){
		int itemCount = 0 , maxDigit = 0 ,count = 0, k = 0 ,sum = 0;
		int[] maxItems = null; 
		ArrayList<Integer> numList; 
		
		for(int i = 0 ; i < series.length ; i++){
			if(i == 0){
				itemCount = series[i].length();	
				maxItems = new int[itemCount];
			}
			numList = new ArrayList<Integer>();
			for(int j = 0 ; j < series[i].length() ; j++){
				numList.add(Integer.parseInt(series[i].charAt(j)+""));
			}
			 
			while(count < itemCount){
				maxDigit = Collections.max(numList);
				if(maxDigit > maxItems[k]){
					maxItems[k] = maxDigit;
					
				}
				numList.remove(new Integer(maxDigit));
				count++;
				k++;
			}
			count = 0;
			k = 0;
		}
		
		for(Integer i : maxItems){
			sum = sum + i;
		}
		System.out.println(sum);
	}
}
