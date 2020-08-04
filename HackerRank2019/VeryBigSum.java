package HackerRank;

import java.math.BigInteger;
import java.util.Scanner;

public class VeryBigSum {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int total = Integer.parseInt(input.nextLine());
		BigInteger largeSum = BigInteger.ZERO;
		String[] nums = (input.nextLine()).split(" ");
		for(int i = 0 ; i < total ; i++){
			 largeSum = largeSum.add(new BigInteger(nums[i]));
		}
		System.out.println(largeSum.toString());
		input.close();
	}

}
