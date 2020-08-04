package HackerEarth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AvoidBoredom {
	public static long goodValue = 0;
	public static LinkedHashMap<String,Long> finalValueMap; 

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		for(int j = 0 ; j < tc ; j++){
			String data = (input.nextLine());
			int n = Integer.parseInt(data.split(" ")[0]);
			int m = Integer.parseInt(data.split(" ")[1]);
			String[] subjectInterests = input.nextLine().split(" ");
			long[] interests = new long[n];
			for(int i = 0 ; i < n ; i++){
				interests[i] = Long.parseLong(subjectInterests[i]);
			}
			finalValueMap = new LinkedHashMap<String,Long>();
			findStudyGroup(interests,m);
			goodValue = 0;
		}
		input.close();
	}

	public static void findStudyGroup(long[] subGroup , int subCount){
		int k = 0 , count  = 0;
		String keyValue = "";
		ArrayList<Long> diffList = new ArrayList<Long>();

		LinkedHashMap<String,Long> diffMap  = new LinkedHashMap<String,Long>(); 
		for(int i = 0 ; i < subGroup.length ; i++){
			for(int j = i + 1 ; j < subGroup.length ; j++){
				diffMap.put(subGroup[i]+","+subGroup[j],Math.abs(subGroup[i] - subGroup[j]));
				diffList.add(Math.abs(subGroup[i] - subGroup[j]));
			}
		}
		Collections.sort(diffList);
		//System.out.println(diffMap);
		k = diffList.size() - 1;
		while(count < subCount - 1){
			Set<Map.Entry<String,Long>> entrySet = diffMap.entrySet();
			for(Map.Entry<String, Long> entry : entrySet){
				keyValue = entry.getKey();
				if((entry.getValue().equals(diffList.get(k))) && (isInGroup(keyValue,diffMap))){
					count++;
					break;
				}
			}
			k--;
			if(k < 0){
				break;
			}
		}
		System.out.println(findMaxGroup(finalValueMap));
	}

	public static long findMaxGroup(LinkedHashMap<String,Long> diffValueMap){
		long maxValue = 0 , currMaxValue = 0;
		String maxKey = "";
		Set<Map.Entry<String,Long>> entrySet = diffValueMap.entrySet();
		for(Map.Entry<String, Long> entry : entrySet){
			currMaxValue = entry.getValue();
			 if(currMaxValue > maxValue){
				 maxValue = currMaxValue;
				 maxKey = entry.getKey();
			 }
		}
		//System.out.println(maxKey);
		return maxValue;
	}

	public static boolean isInGroup(String key , LinkedHashMap<String,Long> hmap){
		
		String keyValue = "";
		Set<Map.Entry<String,Long>> entrySet = hmap.entrySet();
		for(Map.Entry<String, Long> entry : entrySet){
			keyValue = entry.getKey();
			if(keyValue.substring(0, keyValue.indexOf(",")).equals(key.substring(key.indexOf(',')+1))){
				goodValue = entry.getValue();
				finalValueMap.put(key+","+keyValue, hmap.get(key) + goodValue);
				return true;
			}
		}
		return false;
	}
}
