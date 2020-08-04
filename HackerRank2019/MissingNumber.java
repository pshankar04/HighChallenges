package HackerRank;

import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MissingNumber {

	public static TreeMap<Integer,Integer> list_A_Map = new TreeMap<Integer,Integer>();
	public static TreeMap<Integer,Integer> list_B_Map = new TreeMap<Integer,Integer>();
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int list_A_count = in.nextInt();
		int numberA;
		for(int i = 0 ; i < list_A_count ; i++){
			numberA = in.nextInt();
			if(list_A_Map.containsKey(numberA)){
				list_A_Map.put(numberA,list_A_Map.get(numberA) + 1);
			}else{
				list_A_Map.put(numberA,1);
			}
		}
		int list_B_count = in.nextInt();
		int numberB;
		for(int i = 0 ; i < list_B_count ; i++){
			numberB = in.nextInt();
			if(list_B_Map.containsKey(numberB)){
				list_B_Map.put(numberB,list_B_Map.get(numberB) + 1);
			}else{
				list_B_Map.put(numberB,1);
			}
		}
		in.close();
		System.out.println(list_A_Map);
		System.out.println(list_B_Map);
		getMissingNumber(list_A_Map,list_B_Map);
	}
	
	public static void getMissingNumber(TreeMap<Integer,Integer> AMap,TreeMap<Integer,Integer> BMap){
		int keyNumber;
		LinkedList<Integer> missingNumberList = new LinkedList<Integer>();
		for (Map.Entry<Integer, Integer> entry : AMap.entrySet()) {
			keyNumber = entry.getKey();
			 if(BMap.containsKey(keyNumber) && (BMap.get(keyNumber) > AMap.get(keyNumber))){
				 missingNumberList.add(keyNumber);
			 }
		}
		
		for(Integer num : missingNumberList){
			System.out.print(num+" ");
		}
	}

}
