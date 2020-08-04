package HackerEarth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LuckyNumber {

	public static String[] tc;
	public static int start = 0;
	public static int end = 2;
	public static void main(String[] args) {
		Scanner testcaseCount = new Scanner(System.in);
		int testcases = testcaseCount.nextInt();

		Scanner tcInput = new Scanner(System.in);
		tc = new String[testcases * 2];
		for(int i = 0 ; i < tc.length ; i++)
			tc[i] = tcInput.nextLine();

		for(int j = 0 ; j < testcases ; j++)
			readTestcases(tc,start,end);

		testcaseCount.close();
		tcInput.close();
	}

	public static void readTestcases(String[] testcases,int fromPointer,int toPointer){

		String[] testInputs = testcases[fromPointer].split(" ");
		String divisor = testcases[toPointer - 1];
		findMultiples(testInputs,divisor);

		start += 2; end+= 2;
	}

	public static void findMultiples(String[] caseOne , String div){
		int[] numbers = convertToIntArray(caseOne);

		for(int i = 0 ; i < numbers.length ; i++)
			commonMultiples(numbers,Integer.parseInt(div));
	}

	public static int[] convertToIntArray(String[] str){
		int[] numArray = new int[str.length];
		for(int k = 0 ; k < str.length ; k++){
			numArray[k] = Integer.parseInt(str[k]);
		}
		return numArray;
	}

	public static void commonMultiples(int[] nums,int divi){
		for(int k = 0 ; k < nums.length ; k++){
			 
			if(nums[k] % divi == 0){
				System.out.println(nums[k]+" = "+divi+" * "+(nums[k] / divi));
			}else {
				if(nums[k] % divi != 0){
					//tryCombinations(nums,divi);
				}else{
					System.out.println("Impossible");
				}
			}
		}
	}

	public static void tryCombinations(ArrayList<Integer> items,int divisor){


	}

}





