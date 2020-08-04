package SPOJ;

import java.util.Scanner;

public class PrimeGenerator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		String data = "";
		long start = 0 , end = 0;
		for(int i = 0 ; i < tc ; i++){
			data = input.nextLine();
			start = Long.parseLong(data.split(" ")[0]);
			end = Long.parseLong(data.split(" ")[1]);
			for(long j = start ; j <= end ; j++){
				if(checkPrimeOrNot(j)){
					System.out.println(j);
				}
			}
			System.out.println();
		}
		input.close();
	}

	public static boolean checkPrimeOrNot(long number){
		boolean isPrime = true;
		if(number == 1){
			return false;
		}
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
			return true;
		else
			return false;
	}
}
