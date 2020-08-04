package HackerEarth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MillySubArrays {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = input.nextInt();
		int total = 0;  
		int[] items ;
		for(int i = 0 ; i < tc ; i++){
			total = input.nextInt();
			items = new int[total];
			for(int j = 0 ; j < total ; j++){
				items[j] = input.nextInt();
			}
			formSubArrays(items); 
		}
		input.close();
	}

	public static void formSubArrays(int[] nums){ 
		int[] temp;
		String minMax = "";
		ArrayList<String> subArrayList = new ArrayList<String>();
		int from = 0 , to = 1, count = nums.length;
		while(from < nums.length){
			for(int i = from ; i < to && to <= nums.length ; to++){
				temp = Arrays.copyOfRange(nums, from, to);
				Arrays.sort(temp);

				if(temp.length > 1){
					minMax = temp[0]+","+temp[temp.length - 1];
					subArrayList.add(minMax);
				}

			}
			from++;
			to = from + 1;
		}

		for(String numSet : subArrayList){
			if((numSet.split(",")[0]).equals(numSet.split(",")[1])){
				count++;
			}
		}
		System.out.println(count);
	}
}
