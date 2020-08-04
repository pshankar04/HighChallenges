package HackerRank;

import java.util.Scanner;
import java.util.LinkedHashSet;

public class SubsequenceCount {
	public static String[] nums ;
	public static LinkedHashSet<String> numSet;
	public static int cycleCount = 1;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int k = Integer.parseInt(input.nextLine());
		nums = new String[Integer.parseInt(input.nextLine())];
		nums = (input.nextLine()).split(" ");
		int[] sample = new int[nums.length];
		sample = fillSampleArray(nums);
		
		System.out.println(kSub(k,sample));
 
		input.close();

	}

	public static int[] fillSampleArray(String[] numbers){
		int[] num = new int[numbers.length];
		for(int i = 0 ; i < numbers.length ; i++){
			num[i] = Integer.parseInt(numbers[i]);
		}
		return num;
	}

	public static long kSub(int k, int[] nums) {

		numSet = new LinkedHashSet<String>();
		numSet = addSingles(nums,numSet);
		int count = 1 , j = 0;
		String numString = "";
		
		while(cycleCount <= nums.length){
			for(int i = 0 ; i < nums.length ; i++){
				j = i;
				while(count <= cycleCount){
					if(j < nums.length){
						numString = numString + nums[j] + ",";
					}
					count++;
					j++;
				}
				if(isConsecutive(removeComma(numString))){
					numString = removeComma(numString);
					numSet.add(numString);
				}
				
				count = 1;
				numString = "";
			}
			cycleCount++;
		}

		return findSpecificSum(k,numSet);
	}

	public static long findSpecificSum(int kthNumber,LinkedHashSet<String> numberSet){

		long sum = 0 , sumCount = 0;
		for(String s : numberSet){
			sum = findSum(s);
			if((sum % kthNumber) == 0){
				sumCount++;
			}
		}
		return sumCount;
	}

	public static long findSum(String numbers){

		String[] nums = numbers.split(",");
		long addNum = 0;
		for(int i = 0 ; i < nums.length ; i++){
			addNum = addNum + Long.parseLong(nums[i]);
		}
		return addNum;
	}

	public static String removeComma(String str){

		if(str.charAt(str.length() - 1) == ','){
			str = new String((new StringBuffer(str)).deleteCharAt(str.length() - 1));
		}
		return str;
	}

	public static boolean isConsecutive(String consString){

		String[] consNumbers = consString.split(",");
		int diff = 1;
		for(int i = 0 ; i < consNumbers.length ; i++){
			if((i + 1) < consNumbers.length){
				if((Integer.parseInt(consNumbers[i+1]) - Integer.parseInt(consNumbers[i])) != diff){
					return false;
				} 
			}
		}
		return true;
	}


	public static LinkedHashSet<String> addSingles(int[] numbers,LinkedHashSet<String> numberSet){

		for(int i = 0 ; i < numbers.length ; i++){
			numberSet.add(String.valueOf(numbers[i]));
		}
		cycleCount++;
		return numberSet;
	}
}
