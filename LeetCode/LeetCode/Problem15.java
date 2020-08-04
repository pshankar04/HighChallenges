package LeetCode;

 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem15 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		int[] intArray = new int[size];
		for(int i = 0 ; i < size ; i++){
			intArray[i] = input.nextInt();
		}

		System.out.println(threeSum(intArray));
		 
		
	}
	
	public static List<ArrayList<Integer>> threeSum(int[] nums) {
		ArrayList<ArrayList<Integer>> numList = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0 ; i < nums.length ; i++){
			for(int j = 0 ; j < nums.length ; j++){
				for(int k = 0 ; k < nums.length ; k++){
					
					if((i == j) && (j == k) && (i == k)) continue;
					else{
						if((nums[i] + nums[j] + nums[k]) == 0){
							ArrayList<Integer> integerList = new ArrayList<Integer>();
							integerList = sortItems(nums[i],nums[j],nums[k]);
							numList.add(integerList);
						}
					}
				}
			}
		}
		return (ArrayList<ArrayList<Integer>>)numList;
	}
	
	public static ArrayList<Integer> sortItems(int p ,int q,int r){
		ArrayList<Integer> sortedList = new ArrayList<Integer>();
		sortedList.add(p);sortedList.add(q);sortedList.add(r);
		Collections.sort(sortedList);
		return sortedList;
	}
	
	

}
