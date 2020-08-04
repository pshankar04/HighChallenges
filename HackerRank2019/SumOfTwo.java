package HackerRank;

import java.util.HashSet;
import java.util.Scanner;

public class SumOfTwo {
	 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int totalNums = Integer.parseInt(input.nextLine());
		int[] nums = new int[totalNums];
		for(int i = 0 ; i< nums.length ; i++){
			nums[i] = Integer.parseInt(input.nextLine());
		}
		int k = Integer.parseInt(input.nextLine());
		System.out.println(NumberOfPairs(nums,k));
		input.close();
	}

	public static int NumberOfPairs(int[] numbers,long target){
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
