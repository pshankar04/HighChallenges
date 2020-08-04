package HackerRank;

import java.util.LinkedList;
import java.util.Scanner;

public class SumSquareDifference {

	public static void main(String[] args) {
		long number = 0;
		LinkedList<Long> numList = new LinkedList<Long>();
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		if(tc >= 1 || tc <= 10000){
			for(int i = 0 ; i < tc ; i++){
				number = Long.parseLong(input.nextLine());
				if(number >= 1 || number <= 10000){
					numList.add(number);
				}
			}
			for(Long num : numList){
				findSumDiff(num);
			}
		}
		input.close();
	}


	public static void findSumDiff(long number){
		long diff = 0;
		diff = Math.abs(squareSum(number) - sumSquare(number));
		System.out.println(diff);
	}

	public static long squareSum(long number){

		long sum = 0;
		for(int i = 1 ; i <= number ; i++){
			sum = sum + (i * i);
		}
		return sum;
	}

	public static long sumSquare(long number){

		long sum = 0;
		for(int i = 1 ; i <= number ; i++){
			sum = sum + i;
		}
		return (sum * sum); 
	}

}
