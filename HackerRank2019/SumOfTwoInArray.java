package HackerRank;

import java.util.HashSet;
import java.util.Scanner;

public class SumOfTwoInArray {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int target = Integer.parseInt(input.nextLine());
		int total = Integer.parseInt(input.nextLine());
		int[] nums = new int[total];

		for(int i = 0 ; i < total ; i++){
			nums[i] = Integer.parseInt(input.nextLine());
		}

		System.out.println(numberOfPairs(nums,target));
		input.close();
	}


	public static int numberOfPairs(int[] numbers,long target){
		HashSet<String> pairSet = new HashSet<String>();
		for(int i = 0 ; i < numbers.length ; i++){
			for(int j = 0 ; j < numbers.length ; j++){
				if(i == j){
					continue;
				}else{
					if(((numbers[i] + numbers[j]) == target) && !(pairSet.contains(numbers[i]+","+numbers[j])) && !(pairSet.contains(numbers[j]+","+numbers[i]))){
						pairSet.add(numbers[i]+","+numbers[j]);
					}
				}
			}
		}

		return pairSet.size();
	}
}
