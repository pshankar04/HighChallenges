package HackerRank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class PrimesSummation {

	public static void main(String[] args) {
		int number = 0;
		LinkedList<Integer> numList = new LinkedList<Integer>();
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		if(tc >= 1 || tc <= 10000){
			for(int i = 0 ; i < tc ; i++){
				number = Integer.parseInt(input.nextLine());
				if(number >= 1 || number <= 1000000){
					numList.add(number);
				}
			}
			for(Integer num : numList){
				primesSum(num);
			}
		}
		input.close();
	}
	
//	public static void findSum(int number){
//		 
//		long sum = 0;
//		for(int i = 2 ; i <= number ; i++){
//			if(checkPrimeOrNot(i)){
//				sum = sum + i;
//			}
//		}
//		System.out.println(sum);
//	}
//	public static boolean checkPrimeOrNot(int number){
//		boolean isPrime = true;
//		for(int i=2;i<=number/2;i++)
//		{
//			if(number == 1) break;
//			else if(number % i == 0)
//			{
//				isPrime=false;
//				break;
//			}
//		}
//
//		return isPrime;
//	}
	
	public static void primesSum(int number){
		
		boolean[] a = new boolean[number];
		int mul = 0;
		long sum = 0;
		for(int i = 2 ; i < a.length ; i++){
			a[i] = true;
		}
		
		for(int i = 2 ; i < Math.sqrt((double)number); i++){
			if(a[i] == true){
				for(int j = (i * i) ; j < number ; j = ((i * i) + ((mul) * i))){
					a[j] = false;
					mul++;
				}
			}
		}
		
		for(int i = 2 ; i < number ; i++){
			if(a[i] == true){
				sum = sum + i;
			}
		}
		System.out.println(sum);
	}

}
