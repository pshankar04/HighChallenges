package HackerRank;

import java.util.Scanner;

public class PrimeNumber {
	public static boolean isPrime=true;
	public static void main(String args[]){		

		Scanner scan= new Scanner(System.in);
		System.out.println("Enter a number of testacases for check:");
		int num=scan.nextInt();
		if(num != 0){
			int[] numbers = new int[num];
			saveNumbers(numbers); 
			for(int i = 0 ; i < numbers.length ; i++){
				checkPrimeOrNot(numbers[i]);
			}
		} 
		scan.close();
	}

	public static void saveNumbers(int[] nums){
		Scanner input = new Scanner(System.in);
		int entry;
		for(int k = 0 ; k < nums.length ; k++){
			entry = input.nextInt();
			if(entry >= 1) {
				nums[k] = entry;
			}else{
				System.out.println("Enter numbers greater than 0");
				break;
			}
		}
		input.close();
	}

	public static void checkPrimeOrNot(int number){

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
			System.out.println("Prime");
		else
			System.out.println("Not Prime");
		isPrime = true;
	}
}


