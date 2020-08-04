package HackerRank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SockMerchant {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count = Integer.parseInt(in.next());
		int[] sockColors = new int[count];
		for(int i = 0 ; i < count ; i++){
			sockColors[i] = in.nextInt();
		}
		System.out.println(sockMerchant(count, sockColors));

	}
	
	public static int sockMerchant(int n, int[] ar){
	
		int pairCount = 0;
		HashMap<String,Integer> sockMap = new HashMap<String,Integer>();
		
		for(int i = 0 ; i < ar.length ; i++){
			if(sockMap.containsKey(ar[i]+"")){
				sockMap.put(ar[i]+"",(sockMap.get(ar[i]+"")) +1);
			}else{
				sockMap.put(ar[i]+"", 1);
			}
		}
		
		for (Map.Entry<String,Integer> entry : sockMap.entrySet())  {
             if(((entry.getValue() - 1) > 0) && ((entry.getValue() - 1) % 2) == 0){
            	 pairCount = pairCount + ((entry.getValue() - 1)/2);
             }
             if(entry.getValue() % 2 == 0){
            	 pairCount = pairCount + (entry.getValue()/2);
             }
		} 
		
		return pairCount;
	}
	//System.out.println("HERE"+sockMap);
}
