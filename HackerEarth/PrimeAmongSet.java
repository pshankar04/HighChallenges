package HackerEarth;

import java.util.LinkedList;
import java.util.Scanner;

public class PrimeAmongSet {
	public static LinkedList<Long> primeList = new LinkedList<Long>();

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		long[] nums = new long[tc];
		int primeCount = 0;
		for(int i = 0 ; i < tc ;i++){
			nums[i] = input.nextLong();
		}
		for(int i = 0 ; i < nums.length ; i++){
			for(int j = 0 ; j < nums.length ;j++){
				if(i == j){
					continue;
				}else{
					if((nums[i] % nums[j]) != 0){
						primeCount++;
					}
				}	
			}
			if(primeCount == nums.length - 1){
				primeList.add(nums[i]);
			}
			primeCount = 0;
		}
		for(long l : primeList){
			System.out.print(l+" ");
		}
		input.close();
	}

}
