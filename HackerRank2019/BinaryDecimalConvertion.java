package HackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BinaryDecimalConvertion {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int total = Integer.parseInt(input.nextLine());
		long[] nums = new long[total];
		for(int i = 0 ; i < total ; i++){
			nums[i] = Long.parseLong(input.nextLine());
		}
		findOrder(nums);
		input.close();
	}

	public static void findOrder(long[] numbers){
		LinkedHashMap<Long,Integer> countMap = new LinkedHashMap<Long,Integer>();
		LinkedList<Long> medianSet; 
		String binary = "";

		for(int i = 0 ; i< numbers.length ; i++){
			binary = Long.toBinaryString(numbers[i]);
			countMap.put(numbers[i], countOnes(binary));
		}
		medianSet = orderMap(countMap);
		for(Long l : medianSet){
			System.out.println(l);
		}

	}

	public static LinkedList<Long> orderMap(LinkedHashMap<Long,Integer> orgMap){
		int max = Collections.max(orgMap.values());
		long key = 0;
		int value = 0 , dupCount = 0;
		LinkedList<Long> numSet = new LinkedList<Long>();
		LinkedList<Long> numDuplicateSet = new LinkedList<Long>();
		LinkedList<Long> decreasingSet = new LinkedList<Long>();
		boolean found = false;
		int index = 0;
		while(!found){
			Set<Map.Entry<Long,Integer>> entrySet = orgMap.entrySet();
			for(Map.Entry<Long, Integer> entry : entrySet){
				value = entry.getValue();
				key = entry.getKey();
				if(value == max){
					numSet.add(key);
					dupCount++;
				}
			}
			if(dupCount > 1){
				for(int i = 0 ; i < dupCount ; i++){
					numDuplicateSet.add(numSet.get(index));
					index++;
				}
				numSet.removeAll(numDuplicateSet);
				decreasingSet = formDecOrder(numDuplicateSet);
				numSet.addAll(decreasingSet);
			}
			if(numSet.size() == orgMap.size()){
				found = true;
			}
			max--;
			dupCount = 0;
			index++;
		}

		return numSet;
	}

	public static LinkedList<Long> formDecOrder(LinkedList<Long> numSet){
		LinkedList<Long> numberSet = new LinkedList<Long>();
		numSet = sortSet(numSet);
		for(int j = numSet.size() - 1 ; j >= 0 ; j--){
			numberSet.add(numSet.get(j));
		}
		
		return numberSet;
	}
	
	public static LinkedList<Long> sortSet(LinkedList<Long> numsSet){
		ArrayList<Long> numList = new ArrayList<Long>();
		for(Long l : numsSet){
			numList.add(l);
		}
		Collections.sort(numList);
		return new LinkedList<Long>(numList);
	}
	
	public static int countOnes(String s){
		int count = 0;
		for(int i = 0 ; i < s.length() ; i++){
			if(s.charAt(i) == '1'){
				count++;
			}
		}
		return count;
	}
}
