package HackerEarth;

import java.util.Scanner;

public class PrimeProblemSetPoints {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int total = input.nextInt();
		long numArray[] = new long[total];
		for(int i = 0 ; i < total ; i++){
			numArray[i] = input.nextInt();
		}
		findMaxScore(numArray);
		input.close();
	}

	public static void findMaxScore(long[] scoreArray){
		long rhezoScore = 0 , countLen = scoreArray.length;
		boolean found = true;
		while(found){
			if(isPrimeNumber(countLen)){
				for(int i = 0 ; i < countLen ; i++){
					rhezoScore = rhezoScore + scoreArray[i];
				}
				found = false;
			}else{
				countLen = countLen - 1;
			}
		}
		 
		System.out.println(rhezoScore);
	}


	public static boolean isPrimeNumber(long number){

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

		return isPrime;
	}
}
