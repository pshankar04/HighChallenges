package HackerRank;

import java.util.Scanner;

/**
 * code to find the difference between the largest and the smallest number on an integer array
 * @author puneethshankar
 *
 */
public class AbsoluteDifference {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] arrayElements = new String[input.nextInt()];
		for(int j = 0 ;j < arrayElements.length ; j++){
			arrayElements[j] = String.valueOf(input.nextInt());
		}
		System.out.println( findLargest(arrayElements) - findSmallest(arrayElements));
		

	}
	
	public static int findSmallest(String[] strArray){
		
		int small  = Integer.parseInt(strArray[0]);
		int currentItem;
		for(int k = 0 ; k< strArray.length ; k++){
			currentItem = Integer.parseInt(strArray[k]);
			if( currentItem < small){
				small = Integer.parseInt(strArray[k]);
			}else{
				continue;
			}
		}
		return small;
	}

	public static int findLargest(String[] strArray){
		int large = 0 ;
		int currentItem;
		for(int k = 0 ; k< strArray.length ; k++){
			currentItem = Integer.parseInt(strArray[k]);
			if(currentItem > large){
				large = Integer.parseInt(strArray[k]);
			}else{
				continue;
			}
		}
		return large;
	}
}
