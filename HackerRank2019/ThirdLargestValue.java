package HackerRank;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class ThirdLargestValue {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int totalNumbers = Integer.parseInt(input.nextLine());
		int[] numArray = new int[totalNumbers];

		for(int i = 0 ; i < totalNumbers ; i++){
			numArray[i] = Integer.parseInt(input.nextLine());
		}
		System.out.println(ThirdLargest(numArray));
		input.close();
	}

	public static int ThirdLargest(int[] arr){

		LinkedList<Integer> numsList = new LinkedList<Integer>();
		for(int i = 0 ; i < arr.length ; i++){

			if(!numsList.contains(arr[i])){
				numsList.add(arr[i]);
			}
		}
		Collections.sort(numsList);
		return numsList.get(numsList.size() - 3);
	}
}
