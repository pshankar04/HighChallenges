package HackerEarth;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductDivisors {
	public static ArrayList<Integer> primeFactors = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		long product = 1;
		 
		for(int i = 0 ; i < num ; i++){
			product =  product * input.nextInt();
		}
		System.out.println(product);
		System.out.println(findDivisors(product));
		 
		input.close();
	}

	public static long findDivisors(long x) {
	    long limit = x;
	    long numberOfDivisors = 0;

	    if (x == 1) return 1;

	    for (int i = 1; i < limit; ++i) {
	        if (x % i == 0) {
	            limit = x / i;
	            if (limit != i) {
	                numberOfDivisors++;
	            }
	            numberOfDivisors++;
	        }
	    }

	    return numberOfDivisors;
	}
}
