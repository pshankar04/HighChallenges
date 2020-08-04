package HackerRank;

import java.util.Scanner;

public class BalancedArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int total = in.nextInt();
		int[] elements = new int[total];
		for(int i = 0 ; i < total ; i++){
			elements[i] = in.nextInt();
		}
		checkBalancedItem(elements,total/2);
		in.close();
	}

	public static void checkBalancedItem(int[] nums,int mid){
		 
		int leftSum = 0 , rightSum = 0;
		
		for(int i = 0 ; i < mid ; i++){
			leftSum = leftSum + nums[i];
		}
		
		for(int i = mid ; i < nums.length ; i++){
			rightSum = rightSum + nums[i];
		}
		
		System.out.println(Math.abs(rightSum - leftSum));
		
	}
}
