package HackerRank;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class SortArraySubSets {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int[] nums = new int[num];
		for(int i = 0 ; i < num ; i++){
			nums[i] = input.nextInt();
		}
		customSort(nums);
		input.close();
	}

	public static void customSort(int[] arr){

		TreeMap<Integer,Integer> numMap = new TreeMap<Integer,Integer>();
		int count = 0 , valueCount = 1 ;

		for(int i = 0 ; i < arr.length ; i++){
			if(numMap.containsKey(arr[i])){
				numMap.put(arr[i],numMap.get(arr[i]) + 1);
			}else{
				numMap.put(arr[i],1);
			}
		}
		while(count < arr.length){
			Set<Map.Entry<Integer,Integer>> entrySet = numMap.entrySet();
			for(Map.Entry<Integer, Integer> entry : entrySet){
				if(entry.getValue().equals(new Integer(valueCount))){
					for(int i = 0 ; i < valueCount ; i++){
						System.out.println(entry.getKey());
						count++;
					}
				}
			}
			valueCount++;
		}
	}
}
