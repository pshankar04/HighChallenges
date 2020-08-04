package HackerRank;

import java.util.LinkedList;
import java.util.Scanner;

public class NthPrimeNumber {

	public static void main(String[] args) {
		long number = 0;
		LinkedList<Long> numList = new LinkedList<Long>();
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		if(tc >= 1 || tc <= 1000){
			for(int i = 0 ; i < tc ; i++){
				number = Long.parseLong(input.nextLine());
				if(number >= 1 || number <= 10000){
					numList.add(number);
				}
			}
			for(Long num : numList){
				findPrime(num);
			}
		}
		input.close();
	}

	public static void findPrime(long num){
		int count = 0;
		int i = 2;
		
		while(count != num){
			if(checkPrimeOrNot(i)){
				count++;
			} 
			i++;
		}
		System.out.println((i-1));
	}

	public static boolean checkPrimeOrNot(long number){
		boolean isPrime = true;
		for(int i=2;i<=number/2;i++)
		{
			if(number == 1) break;
			else if(number % i == 0)
			{
				isPrime=false;
				break;
			}
		}

		if(isPrime)
			isPrime = true;
		else
			isPrime = false;

		return isPrime;
	}

}
