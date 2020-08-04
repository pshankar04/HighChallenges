package HackerRank;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Scanner;

public class FactorialDigitSum {
	public static LinkedList<Integer> numList;

	public static void main(String[] args) {
		numList = new LinkedList<Integer>();
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		int num = 0 ;

		if(tc >= 1 && tc <= 100){
			for(int i = 0 ; i < tc ; i++){
				num = Integer.parseInt(input.nextLine());
				if(num >= 0 && num <= 1000){
					numList.add(num);
				}
			}
		}
		for(Integer i : numList){
			findDigitSum(i);
		}
		input.close();
	}

	public static void findDigitSum(int num){
		BigInteger product = new BigInteger("1");
		int sumOfDigits = 0;

		if(num == 0){
			System.out.println(1);
		}else{
			while(num != 0){
				product = product.multiply(new BigInteger(String.valueOf(num)));
				num = num - 1;
			}
			sumOfDigits = findSum(product.toString());
			System.out.println(sumOfDigits);
		}
	}
	public static int findSum(String number){
		int sum = 0;

		for(int i = 0 ; i < number.length() ; i++){
			sum = sum + Integer.parseInt(number.charAt(i)+"");
		}
		return sum;
	}
}
