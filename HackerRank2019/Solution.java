package HackerRank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.TreeSet;

public class Solution {

	public static TreeSet<Integer> numSet  = new TreeSet<Integer>();
	public static TreeSet<Integer> finalNumSet ;  
	public static void main(String[] args) {

		int totalNums = 0 , largestIndex = 0;
		String[] nums; 
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			int lineNumber = 1;
			while ((line = buffer.readLine()) != null && (line.length() > 0)) {
				if(lineNumber == 1){
					totalNums = Integer.parseInt(line);
				}else if(lineNumber == 2 && totalNums >= 2){
					nums = line.split(" ");
					for(int i = 0 ; i < nums.length ; i++){
						numSet.add(Integer.parseInt(nums[i]));
					}
				}else if(lineNumber == 3){
					largestIndex = Integer.parseInt(line);
				}
				lineNumber++;
			}
			finalNumSet = performOperation(numSet);
			if(largestIndex >= 1){
				System.out.println(findLargestNumber(largestIndex));
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}



	public static TreeSet<Integer> performOperation(TreeSet<Integer> numberSet){
		finalNumSet = new TreeSet<Integer>(numberSet);
		int sum = 0;
		int[] numArray = new int[finalNumSet.size()];
		numArray = pushToArray(finalNumSet);
		for(int  i = 0 ; i < numArray.length ; i++){
			for(int j = 0 ; j < numArray.length ; j++){
				if(i == j){
					continue;
				}else{
					sum = Math.abs(numArray[i] - numArray[j]);
					finalNumSet.add(sum);
					sum = 0;
				}
			}
		}

		return finalNumSet;
	}

	public static int[] pushToArray(TreeSet<Integer> setNum){
		int[] nums = new int[setNum.size()];
		int i = 0;
		for(Integer number : setNum){
			nums[i] = number;
			i++;
		}
		return nums;
	}

	public static int findLargestNumber(int index){

		int maxNumber = Collections.max(finalNumSet);
		finalNumSet.remove(maxNumber);

		return Collections.max(finalNumSet);
	}
}
