package HackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LargePrimes {

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
				System.out.println(primeFactors(numbers[i]));
			}
		}
		input.close();

	}
	
	public static long primeFactors(long n) {
		ArrayList<Long> factors = new ArrayList<Long>();
		while (n % 2 == 0 && n > 0) {
			factors.add(2L);
			n /= 2;
		}

		for (long i = 3; i * i <= n; i+=2) {
			while (n % i == 0) {
				factors.add(i);
				n /= i;
			}
		}
		if (n > 1){
			factors.add(n);
		}

		return Collections.max(factors);
	}
}
