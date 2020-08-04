package HackerEarth;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class KangrooHopCount {
	 
	public static HashMap<Long,HashMap<Long,Long>> hopCountMap = new HashMap<Long,HashMap<Long,Long>>();

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long tc = Long.parseLong(input.nextLine());
		long start = 0 , end = 0 ,hopCount = 0 ;
		long totalHops = 0 , max = 0 ; 
		String hopStats = "";
		for(long i = 0 ; i < tc ; i++){
			hopStats = input.nextLine();
			start = Long.parseLong(hopStats.split(" ")[0]);
			end = Long.parseLong(hopStats.split(" ")[1]);
			hopCount = Long.parseLong(hopStats.split(" ")[2]);
			if (hopCount > end){
				System.out.println(totalHops);
				break;
			}else if ((end - start) < hopCount){
				System.out.println(totalHops);
				break;
			}else{
				if(hopCountMap.containsKey(hopCount)){
					max = Collections.max(hopCountMap.get(hopCount).keySet());
					if(end > max){
						for(long j = max ; j <= end ; j++){
							if((j % hopCount) == 0){
								totalHops++;
							}
						}
						System.out.println((hopCountMap.get(hopCount)).get(max) + totalHops);
						(hopCountMap.get(hopCount)).put(end,(hopCountMap.get(hopCount)).get(max) + totalHops);
					}else if(end < max){
						for(long j = start ; j <= end ; j++){
							if((j % hopCount) == 0){
								totalHops++;
							}
						}
						System.out.println(totalHops);
						(hopCountMap.get(hopCount)).put(end,totalHops);
					}else if(end == max){
						for(long j = start ; j <= end ; j++){
							if((j % hopCount) == 0){
								totalHops++;
							}
						}
						System.out.println(totalHops);
					}
					totalHops = 0;
				}else{
					HashMap<Long,Long> tempMap = new HashMap<Long,Long>();
					for(long j = start ; j <= end ; j++){
						if((j % hopCount) == 0){
							totalHops++;
						}
					}
					tempMap.put(end,totalHops);
					hopCountMap.put(new Long(hopCount),tempMap);
					System.out.println(totalHops);
					totalHops = 0;
				}
			}
		}
		input.close();
	}
}
