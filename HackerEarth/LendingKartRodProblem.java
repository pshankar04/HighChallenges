package HackerEarth;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class LendingKartRodProblem {
	public static long specialLengthCount = 0;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = input.nextInt();
		long rodLength = 0;
		for(int i = 0 ; i < tc ; i++){
			rodLength = input.nextLong();
			findSpecialRods(rodLength);
			specialLengthCount = 0;
		}
		input.close();
	}

	public static void findSpecialRods(long length){

		if(length == 1){
			System.out.println(specialLengthCount);
			return;
		}else if(length % 2 == 0){
			length = length / 2;
			findSpecialRods(length);
		}else if(length % 2 != 0){
			specialLengthCount++;
			System.out.println("ROD NUM : "+length);
			length = findOptimalLength(length);
			findSpecialRods(length);
		}
	}

	public static long findOptimalLength(long len){
		 
		long minLength = len , diffLength = 0 , minRodLength = 0;
		for(long i = 1 ; i < len ; i++){
			for(long j = i + 1 ; j < len ; j++){
				if((i + j) == len){
					diffLength = Math.abs(i - j);
					if(diffLength < minLength){
						minLength = diffLength;
						minRodLength = Math.min(i, j);
					}
				}
			}
		}
		System.out.println("MIN :"+minRodLength);
		return minRodLength;
	}

}
