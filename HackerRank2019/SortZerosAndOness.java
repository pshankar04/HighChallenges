package HackerRank;

import java.util.Scanner;

public class SortZerosAndOness {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		int[] nums = new int[size];
		for(int i = 0 ; i < size ; i++){
			nums[i] = input.nextInt();
		}
		nums = sortArray(nums);
		for(int i = 0 ; i < nums.length ; i++){
			System.out.print(nums[i]+" ");
		}
		input.close();
	}

	public static int[] sortArray(int[] numbers){
		int zeroCount = 0;
		for(int i = 0 ; i < numbers.length; i++){
			if(numbers[i] == 0){
				zeroCount++;
			}
		}
		for(int j = 0 ; j < numbers.length ; j++){
			if(j < zeroCount){
				numbers[j] = 0;
			}else{
				numbers[j] = 1;
			}
		}
		return numbers;
	}
	
}
