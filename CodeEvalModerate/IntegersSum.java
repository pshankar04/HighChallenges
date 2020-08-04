package CodeEvalModerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class IntegersSum {

	public static ArrayList<Integer> sumList ;
	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			  
			while ((line = buffer.readLine()) != null) {
				findSum(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public static void findSum(String nums){
		String[] numbers = nums.split(",");
		int[] numArray = new int[numbers.length];
		saveNow(numbers,numArray);
		caculateSum(numArray);
	}

	
	public static int[] saveNow(String[] nums,int[] ints){
		for(int i = 0 ; i < nums.length ; i++){
			ints[i] = Integer.parseInt(nums[i]);
		}
		return ints;
	}
	
	public static void caculateSum(int[] nums){
		sumList = new ArrayList<Integer>();
		int boundary = nums.length;
		int sum = 0;
		while(boundary >= 1){
			for(int i = 0 ; i < nums.length ; i++){
				for(int k = (i+1) ; k < boundary ; k++){
					sum = sum + nums[k];
				}
				sum = sum + nums[i];
				sumList.add(sum);
				sum = 0;
			}
			boundary--;
		}
		System.out.println(Collections.max(sumList));
	}
	
}
