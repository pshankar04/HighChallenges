package HackerEarth;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductSquare {
	public static DecimalFormat df2 = new DecimalFormat("#.######");
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numCount = Integer.parseInt(input.nextLine());
		int[] nums = new int[numCount];
		for(int i = 0 ; i < nums.length ; i++){
			nums[i] = Integer.parseInt(input.nextLine());
		}
		findProbablity(nums);
		input.close();
	}


	public static void findProbablity(int[] numbers){
		ArrayList<Integer> numList = new ArrayList<Integer>();
		double perfectSquaresCount = 0.0d;
		for(int i = 0 ; i < numbers.length ; i++){
			for(int j = 0 ; j < numbers.length ; j++){
				if(i == j) continue;
				numList.add(numbers[i] * numbers[j]);
			}
			perfectSquaresCount = perfectSquaresCount + findPrefectSquares(numList);
			numList = new ArrayList<Integer>();
		}
		perfectSquaresCount =  (Double.valueOf(df2.format(perfectSquaresCount)) / Double.valueOf(df2.format((double)(numbers.length))));
		System.out.println(String.format("%.6f",perfectSquaresCount));
	}

	public static double findPrefectSquares(ArrayList<Integer> numberList){
		int sqrt = 0 , count = 0;
		double prob = 0.0d;
		for(Integer i : numberList){
			sqrt = (int) Math.sqrt(i);
			if(sqrt*sqrt == i) {
				count++;
			} 
		}
		prob = Double.valueOf(df2.format(Double.valueOf(count)/Double.valueOf(numberList.size())));
		return Double.valueOf(String.format( "%.6f", prob));
	}
}