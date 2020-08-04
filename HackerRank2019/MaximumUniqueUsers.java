package HackerRank;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MaximumUniqueUsers {


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		String[] userPoints = new String[tc];
		for(int i = 0 ; i < tc ; i++){
			userPoints[i] = input.nextLine();
		}
		for(String s :unique_users(userPoints)){
			try{
				if(!s.equals(null)){
					System.out.println(s);
				}
			}catch(NullPointerException ne){

			}
		}

		input.close();
	}

	public static String[] unique_users(String[] arr){
		HashMap<String,Integer> pointsMap = new HashMap<String,Integer>();
		double latitude = 0, longitude = 0;
		int minValue = 0 , count = 0;
		String[] results = new String[arr.length];
		for(int i = 0 ; i < arr.length ; i++){
			latitude = Double.parseDouble(arr[i].split(",")[1]);
			longitude = Double.parseDouble(arr[i].split(",")[2]);
			if((latitude + longitude) <= 200d){
				if(pointsMap.containsKey(latitude+","+longitude)){
					pointsMap.put((latitude+","+longitude), pointsMap.get(latitude+","+longitude) + 1);
				}else{
					pointsMap.put((latitude+","+longitude),1);
				}
			}
		}
		minValue = Collections.max(pointsMap.values());
		Set<Map.Entry<String,Integer>> entrySet = pointsMap.entrySet();
		for(Map.Entry<String,Integer> entry : entrySet){
			if(entry.getValue() == minValue){
				results[count] = entry.getKey();
				count++;
			}
		}
		return results;
	}
}
