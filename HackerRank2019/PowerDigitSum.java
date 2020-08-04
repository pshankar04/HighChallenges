package HackerRank;

import java.math.BigInteger;
import java.util.Scanner;

public class PowerDigitSum {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine()) , number = 0;
		if(tc >= 1 && tc <= 100){
			int nums[] = new int[tc];
			for(int  i = 0 ; i < tc ; i++){
				number = Integer.parseInt(input.nextLine());
				if(number >= 1 && number <= 10000){
					nums[i] = number;
				}
			}

			for(int i = 0 ; i < tc ; i++){
				findSum(nums[i]);
			}
		}
		input.close();
	}


	public static void findSum(int power){
		BigInteger bi = BigInteger.valueOf(2).pow(power);
		int sum = 0; 
		String digit = bi.toString();
		for(int i = 0 ; i < digit.length() ; i++){
			sum = sum + Integer.parseInt(digit.charAt(i)+"");
		}
		System.out.println(sum);
	}
}
