package HackerEarth;

import java.math.BigInteger;
import java.util.Scanner;

public class SmallFactorials {

	public static int[] numList ;
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		numList = new int[number];
		for(int i = 0 ; i < number ; i++){
			numList[i] = in.nextInt();
		}
		for(int k = 0 ; k < numList.length ; k++)
			System.out.println(factorial(numList[k]));
	}


	public static BigInteger factorial(int num){
		BigInteger fact = BigInteger.valueOf(1);
	    for (int i = 1; i <= num; i++)
	        fact = fact.multiply(BigInteger.valueOf(i));
		return fact;

	}
}
