package HackerRank;

import java.util.Scanner;

public class DeltaEncoding {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] series = (input.nextLine()).split(" ");
		int[] nums = convertToInt(series);
		int[] finalNums = new int[nums.length];
		finalNums = fillArray(nums,finalNums);
		for(Integer i : finalNums){
			System.out.print(i+" ");
		}
		input.close();
	}

	public static int[] fillArray(int[] org , int[] res){

		for(int i = 0 ; i < org.length ; i++){
			if(i == 0){
				res[i] = org[i];
			}else{
				res[i] = org[i] - org[i - 1];
			}
		}
		return res;
	}

	public static int[] convertToInt(String[] numbers){

		int[] numArray = new int[numbers.length];
		for(int i = 0 ; i < numbers.length ; i++){
			numArray[i] = Integer.parseInt(numbers[i]);
		}
		return numArray;
	}
}
