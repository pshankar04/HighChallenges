package HackerRank;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Scanner;

public class LargeSum {

	public static void main(String[] args) {
		BigInteger sum = new BigInteger("0");
		LinkedList<BigInteger> numList = new LinkedList<BigInteger>();
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		if(tc >= 1 || tc <= 1000){
			for(int i = 0 ; i < tc ; i++){
				 	numList.add(new BigInteger(input.nextLine()));
			}
			for(BigInteger num : numList){
				 sum = sum.add(num);
			}
			System.out.println((String.valueOf(sum)).substring(0,10));
		}
		input.close();
	}
	
}
