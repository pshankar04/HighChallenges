package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class SortFrequencies {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int[] nums = new int[num];
		for(int i = 0 ; i < num ; i++){
			nums[i] = input.nextInt();
		}
		customSort(nums);
	}

	public static void customSort(int[] arr){

		TreeMap<Integer,Integer> numsMap = new TreeMap<Integer,Integer>();
		int key = 0 , value = 0;
		ArrayList<Integer> numsList = new ArrayList<Integer>();
		ArrayList<Integer> finalNumsList = new ArrayList<Integer>();
		for(int i = 0 ; i < arr.length ; i++){
			numsList.add(arr[i]);
		}

		for(Integer num : numsList){
			if(numsMap.containsKey(num)){
				numsMap.put(num,numsMap.get(num) + 1);
				if(finalNumsList.contains(num)){
					finalNumsList.remove(new Integer(num));
				}
			}else{
				numsMap.put(num,1);
				finalNumsList.add(num);
			}
		}
		Collections.sort(finalNumsList);
		for(Integer k : finalNumsList){
			System.out.println(k);
		}
		Set<Map.Entry<Integer,Integer>> entrySet = numsMap.entrySet();
		for(Map.Entry<Integer, Integer> entry : entrySet){
			key = entry.getKey();
			value = entry.getValue();
			for(int i = 0 ; i < value ; i++){
				if(value >= 2){
					System.out.println(key);
				}
			}
		}

	}
}
