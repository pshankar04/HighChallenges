package HackerEarth;

import java.math.BigInteger;
import java.util.Scanner;

public class TrailingZeroes {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println(findTrailingZeroes(input.nextLine()));
		input.close();
	}

	public static int findTrailingZeroes(String number){
		String fact = factorial(Integer.parseInt(number)).toString();
		System.out.println("FACTORIAL :"+fact);
		int count = 0;
		for(int i = fact.length() - 1 ;i >= 0 ; i--){
			if(fact.charAt(i) == '0'){
				count++;
			}else{
				break;
			}
		}
		return count;

	}

	public static BigInteger factorial(int number) {
		BigInteger factorial = BigInteger.ONE; 
		for (int i = number; i > 0; i--) { 
			factorial = factorial.multiply(BigInteger.valueOf(i)); 
		}
		return factorial;
	}
}
