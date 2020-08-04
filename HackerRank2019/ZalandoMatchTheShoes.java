package HackerRank;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.TreeMap;

public class ZalandoMatchTheShoes {

	public static TreeMap<Integer,Integer> shoeMap = new TreeMap<Integer,Integer>();
	public static TreeSet<Integer> orderSet ;
	public static LinkedList<Integer> orderList ;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int highestOrder = input.nextInt();
		int totalShoeTypes = input.nextInt();
		int totalOrders = input.nextInt();
		int shoeType = 0 , count = 0 , treeSize = 0;
		for(int i = 0 ; i < totalOrders ; i++){
			shoeType = input.nextInt();
			if(shoeMap.containsKey(shoeType)){
				shoeMap.put(shoeType,shoeMap.get(shoeType) + 1);
			}else{
				shoeMap.put(shoeType,1);
			}
		}
		orderSet =   new TreeSet<Integer>(shoeMap.values());
		orderList = new LinkedList<Integer>(orderSet);
		treeSize = orderSet.size() - 1;
		
		while(count < highestOrder){
			Set<Map.Entry<Integer,Integer>> entrySet = shoeMap.entrySet();
			for(Map.Entry<Integer, Integer> entry : entrySet){
				if((orderList.get(treeSize)).equals(entry.getValue())){
					System.out.println(entry.getKey());
					count++;
					if(count >= highestOrder){
						break;
					}
				}
			}
			treeSize--;
		}
		input.close();
	}

}
