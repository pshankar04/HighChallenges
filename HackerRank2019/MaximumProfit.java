package HackerRank;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MaximumProfit {

	public static int maxProfit = 0;
	public static LinkedHashSet<Integer> coinSet;
	public static LinkedHashSet<String> coinCombinationSet;
	public static LinkedHashMap<Integer,Integer> profitMap;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		int coinValue = 0;
		coinSet = new LinkedHashSet<Integer>();
		for(int i = 0 ; i < tc ; i++){
			coinValue = Integer.parseInt(input.nextLine());
			coinSet.add(coinValue);
		}
		for(Integer coin : coinSet){
			coinCombinationSet = new LinkedHashSet<String>();
			if(isLucrative(coin)){
				//System.out.println(profitMap);
				System.out.println(returMaxProfit(profitMap));
			}else{
				System.out.println("0");
			}
		}
		input.close();
	}

	public static int returMaxProfit(LinkedHashMap<Integer,Integer> profitCountMap){
		int sum = 0;
		Set<Map.Entry<Integer,Integer>> entrySet = profitCountMap.entrySet();
		for(Map.Entry<Integer,Integer> entry : entrySet){
			sum = sum + entry.getValue();
		}
		return sum;	
	}


	public static boolean isLucrative(int coin){
		profitMap = new LinkedHashMap<Integer,Integer>();
		
		int c1 = 0 , c2 = 0 , c3 = 0 , i = 0;
		
		if(coin >= 4){
			c1 = (coin / 2);
			c2 = (coin / 3);
			c3 = (coin / 4);
			//coinCombinationSet(coin+","+c1+","+c2+","+c3);
			 
		}

		return (maxProfit > 0) ? true : false;
	}
}
