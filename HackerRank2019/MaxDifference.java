package HackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MaxDifference {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int total = input.nextInt();
		int[] totalItems = new int[total];
		for(int  i = 0 ; i < totalItems.length ; i++){
			totalItems[i] = input.nextInt();
		}
		System.out.println(maxDifference(totalItems));
		input.close();
	}

	public static int maxDifference(int[] items){
		if(items != null && items.length > 0){
			int largest = findLargest(items);
			int index = 0;
			int difference = 0;
			for(int k = 0 ; k < items.length ; k++){
				if(items[k] == largest){
					index = k;
					break;
				}
			}
			
			if(index == 0) return -1;
			 
			for(int b = 0 ; b < index ; b++){
				if((items[index] - items[b]) > difference){
					difference = items[index] - items[b];
				}else if((items[index] - items[b]) == difference){
					difference = -1;
				}
			}
			return difference;
		}
		return 0;
	}

	public static int findLargest(int[] elements){
		ArrayList<Integer> numList= new ArrayList<Integer>();
		for(int a = 0 ; a < elements.length ; a++){
			numList.add(elements[a]);
		}
		Collections.sort(numList);
		return numList.get(elements.length -1);
	}

}
