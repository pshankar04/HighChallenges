package Arrays;

import java.util.HashSet;
import java.util.Scanner;

public class PairSumLessThanSum {
	public static HashSet<String> pairSet = new HashSet<String>();
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int target = Integer.parseInt(input.nextLine());
		int total = Integer.parseInt(input.nextLine());
		int[] nums = new int[total];

		for(int i = 0 ; i < total ; i++){
			nums[i] = Integer.parseInt(input.nextLine());
		}

		System.out.println(numberOfPairs(nums,target));
		for(String pair : pairSet){
			System.out.println(pair);
		}
		input.close();
	}


	public static int numberOfPairs(int[] numbers,long target){

		for(int i = 0 ; i < numbers.length - 2 ; i++){
			for(int j = i + 1 ; j < numbers.length - 1 ; j++){
				for(int k = j + 1 ; k < numbers.length ; k++){
					if(((numbers[i] + numbers[j] + numbers[k]) < target) && !(pairSet.contains(numbers[i]+","+numbers[j]+","+numbers[k])) && 
							!(pairSet.contains(numbers[k]+","+numbers[j]+","+numbers[i]))){
						pairSet.add(numbers[i]+","+numbers[j]+","+numbers[k]);
					}

				}
			}
		}

		return pairSet.size();
	}
}



