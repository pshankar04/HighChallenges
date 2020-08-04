package HackerRank;

import java.util.Scanner;

public class DivisibleSumPair {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String data = input.nextLine();
		int arraySize = Integer.parseInt(data.split(" ")[0]);
		int k = Integer.parseInt(data.split(" ")[1]);
		String[] numArray = input.nextLine().split(" ");
		int[] nums = new int[arraySize];
		for(int i = 0 ; i < arraySize ; i++){
			nums[i] = Integer.parseInt(numArray[i]);
		}
		findEvenDivisors(nums,k);
		input.close();
	}

	public static void findEvenDivisors(int[] numbers , int num){
		int count = 0;
		for(int i = 0 ; i < numbers.length ; i++){
			for(int j = i + 1; j < numbers.length ;j++){
				if(((numbers[i] + numbers[j]) >= num) && ((numbers[i] + numbers[j]) % num) == 0){
					System.out.println(numbers[i]+" "+numbers[j]);
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
