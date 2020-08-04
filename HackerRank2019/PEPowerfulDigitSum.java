package HackerRank;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class PEPowerfulDigitSum {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Double num = Double.parseDouble(input.nextLine());
		if(((num.intValue()) >= 5) && (((num.intValue()) <= 200))){
		LinkedList<Long> powerDigits = new LinkedList<Long>();
		for(int i = 2 ; i <= num.intValue() ; i++ ){
			for(int k = 2 ; k <= num.intValue() ; k++ ){
				powerDigits.add((new Double(Math.pow(i, k)).longValue()));
			}
		}
		
		findMaxSum(powerDigits);
		}
		input.close();
	}

	public static void findMaxSum(LinkedList<Long> pd){
		LinkedHashSet<Long> sumDigits = new LinkedHashSet<Long>();
		long sum = 0;
		for(Long i : pd){
			sum = sum + findDigitSum(i);
			sumDigits.add(sum);
			sum = 0;
		}
		System.out.println(Collections.max(sumDigits));
		System.out.println(sumDigits);
	}
	
	public static long findDigitSum(Long number){
		String num = String.valueOf(number);
		long sum = 0 ;
		for(int i = 0 ; i < num.length() ; i++){
			sum = sum + Integer.parseInt(num.charAt(i)+"");
		}
		return sum;
	}
}
