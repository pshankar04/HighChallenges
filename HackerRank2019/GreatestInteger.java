package HackerRank;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class GreatestInteger {

	public static TreeSet<Integer> numSet  = new TreeSet<Integer>();
	public static TreeSet<Integer> finalNumSet ;  
	public static void main(String[] args) {

		Scanner numInput = new Scanner(System.in);
		Scanner setInput = new Scanner(System.in);
		int totalNums = Integer.parseInt(numInput.nextLine());
		if(totalNums >= 2){
			for(int i = 0 ; i < totalNums ; i++){
				numSet.add(Integer.parseInt(setInput.next()));
			}
			int largestIndex = numInput.nextInt();
			finalNumSet = performOperation(numSet);
			if(largestIndex >= 1){
				System.out.println(findLargestNumber(largestIndex));
			}
		}
		numInput.close();
		setInput.close();
	}


	public static TreeSet<Integer> performOperation(TreeSet<Integer> numberSet){
		finalNumSet = new TreeSet<Integer>(numberSet);
		int sum = 0;
		int[] numArray = new int[finalNumSet.size()];
		numArray = pushToArray(finalNumSet);
		for(int  i = 0 ; i < numArray.length ; i++){
			for(int j = 0 ; j < numArray.length ; j++){
				if(i == j){
					continue;
				}else{
					sum = Math.abs(numArray[i] - numArray[j]);
					finalNumSet.add(sum);
					sum = 0;
				}
			}
		}

		return finalNumSet;
	}

	public static int[] pushToArray(TreeSet<Integer> setNum){
		int[] nums = new int[setNum.size()];
		int i = 0;
		for(Integer number : setNum){
			nums[i] = number;
			i++;
		}
		return nums;
	}

	public static int findLargestNumber(int index){

		int maxNumber = Collections.max(finalNumSet);
		finalNumSet.remove(maxNumber);

		return Collections.max(finalNumSet);
	}
}
