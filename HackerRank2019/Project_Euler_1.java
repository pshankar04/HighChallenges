package HackerRank;

import java.util.LinkedList;
import java.util.Scanner;

public class Project_Euler_1 {

	public static LinkedList<Long> sumList;
	public static LinkedList<Long> numList;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		numList = new LinkedList<Long>();
		long tc =  input.nextLong();
		long number = 0;
		if(tc >= 1){
			for(long i = 0 ; i < tc ; i++){
				number = input.nextLong();
				if(number >= 1){
					numList.add(number);
				}
			}
			for(Long num : numList){
				findSum(num);
			}
		}
		input.close();
	}

	public static void findSum(long num){
		sumList = new LinkedList<Long>();
		long sum = 0;
		long threeMultiples = findlargestDivisor(num,3);
		long fiveMultiples = findlargestDivisor(num,5);
		long fifteenMultiples = findlargestDivisor(num,15);

		long sumOfthrees =   ((threeMultiples) * ((2*3) + (threeMultiples - 1) * 3))/2; 
		long sumOffives =    ((fiveMultiples) *  ((2*5) + (fiveMultiples - 1) * 5))/2;
		long sumOffifteens =  ((fifteenMultiples) * ((2*15) + (fifteenMultiples - 1) * 15))/2;

		sum = sumOfthrees + sumOffives - sumOffifteens;
		System.out.println(sum);
	}

	public static long findlargestDivisor(long number , int div){
		number = number - 1;
		boolean found = true;
		long num = 0;
		while(found){
			if((number % div) == 0){
				num = number;
				found = false;
			}else{
				number = number - 1;
			}
		}
		return (num/div);
	}
}
