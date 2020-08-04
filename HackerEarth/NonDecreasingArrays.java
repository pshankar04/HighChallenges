package HackerEarth;

import java.util.Arrays;
import java.util.Scanner;

public class NonDecreasingArrays {
	public static long[] numList;


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		int count = 0;

		for(int i = 0 ; i < tc ; i++){
			count = input.nextInt();
			numList = new long[count];

			for(int j = 0 ; j < count ; j++){
				numList[j] = input.nextLong();
			}
			Arrays.sort(numList);

			for(int k = numList.length - 1 ; k >= 0 ; k--){
				System.out.print(numList[k]+" ");
			}
			System.out.println();
		}
		input.close();
	}
}