package HackerRank;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class CollatzSequence {
	public static TreeMap<Long,Long> maxSeriesCountsMap = new TreeMap<Long,Long>(); 
	public static long[] numArray = new long[5000000];

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		long number = 1l;
		long[] nums = new long[tc];

		if(tc >= 1 && tc <= 10000){
			for(int i = 0 ; i < tc ; i++){
				number = Integer.parseInt(input.nextLine());
				if(number >= 1 && number <= 5000000){
					nums[i] = number;
				}
			}
			for(int j = 0 ; j < nums.length ; j++){
				findSeriesLength(nums[j]);
				System.out.println(findMaxNumber(nums[j]));
			}
		}
		input.close();	
	}

	public static long findMaxNumber(long number){

		long maxNumber = 0;
		long key = 0, value = 0 , currentValue = 0;
		Set<Map.Entry<Long,Long>> entrySet = maxSeriesCountsMap.entrySet();
		for(Map.Entry<Long, Long> entry : entrySet){
			currentValue = entry.getValue();
			key = entry.getKey();
			if(key > number){
				break;
			}
			if(currentValue >= value){
				value = currentValue;
				maxNumber = key;
			}
		}
		return maxNumber;
	}

	public static void findSeriesLength(long number){

		long count = 0 ; 
		long num = 0;
		int j = 0;

		if(!containsNumber(number,numArray)){
			for(long i = maxNumber(numArray) + 1 ; i <= number ; i++){
				num = i;
				while(num != 1){
					if((num % 2) == 0){
						num = (num / 2);
					}else{
						num = ((3 * (num)) + 1);
					}
					count++;
				}
				maxSeriesCountsMap.put(i,count);
				numArray[j] = i;
				count = 0;
				j++;
			} 
		}
	}

	public static long maxNumber(long[] nums){
		long max = 0;
		int i ;
		for(i = 0 ; i < nums.length ; i++){
			if(nums[i] == 0){
				break;
			}
			if(nums[i] > max){
				max = nums[i];
			}
		}
		 
		if(i == nums.length){
			return 1;
		}else{
			return max;
		}
	}

	public static boolean containsNumber(long num,long[] nums){
		boolean found = false;
		for(int i = 0 ; i < nums.length ; i++){
			if(nums[i] == num){
				found = true;
				return found;
			}
		}
		return found;
	}
}
