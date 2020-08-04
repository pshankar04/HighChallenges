package HackerRank;

import java.util.Scanner;

public class LargestPrimeFactor {

	public static void main(String[] args) {
		long number = 0l;
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		if((tc >= 1) && (tc <= 10)){
			long[] numbers = new long[tc];
			for(int i = 0 ; i < numbers.length ;i++){
				number = Long.parseLong(input.nextLine());
				if((number >= 10) && number < (Math.pow(new Double(10), new Double(12)))){
					numbers[i] = number; 
				}
			}
			for(int i = 0 ; i < numbers.length ; i++){
				System.out.println(findLargestPrime(numbers[i]));
			}
		}
		input.close();
	}

	public static boolean checkPrimeOrNot(long number){
		boolean isPrime = true;
		for(int i = 2 ; i <= (number/2) ; i++)
		{
			if(number == 1) break;
			else if(number % i == 0)
			{
				isPrime=false;
				break;
			}
		}

		if(isPrime){
			return true;
		}
		else{
			isPrime = true;
			return false;
		}

	}

	public static long findLargestPrime(long num){
		long number = 0 , orgNum = num;

		for(long i = num ; i >= 0 ; i--){
			if(checkPrimeOrNot(i) && ((orgNum % i) == 0)){
				number = i;
				break;
			}
		}
		return number;
	}

}
