package HackerEarth;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class CrazyKangroo {
	public static HashMap<Long,Long> secondHopMap = new HashMap<Long,Long>();
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long tc = Long.parseLong(input.nextLine());
		long start = 0 , end = 0 ,hopCount = 0 ;
		long firstHops = 0 ,secondHops = 0;
		String hopStats = "";
		for(long i = 0 ; i < tc ; i++){
			hopStats = input.nextLine();
			start = Long.parseLong(hopStats.split(" ")[0]);
			end = Long.parseLong(hopStats.split(" ")[1]);
			hopCount = Long.parseLong(hopStats.split(" ")[2]);
			if (hopCount > end){
				System.out.println(firstHops);
				break;
			}else if ((end - start) < hopCount){
				System.out.println(firstHops);
				break;
			}else if((end - start) >= hopCount){
				for(long j = start ; j <= end ; j++){
					if((j % hopCount) == 0){
						firstHops++;
					}
				}
//				if(secondHopMap.containsKey(start)){
//					secondHops = secondHopMap.get(start);
//				}else{
//					for(long k = 0 ; k < start ; k++){
//						if((k % hopCount) == 0){
//							secondHops++;
//						}
//					}
//					secondHopMap.put(start,secondHops);
//				}
				System.out.println(firstHops);
				//System.out.println(Math.abs(firstHops - secondHops));
			}
			firstHops = 0;
			secondHops = 0; 
		}
		input.close();
	}

}
