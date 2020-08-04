package HackerRank;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BestHotelReviews {
	public static LinkedHashMap<Integer,Integer> hotelWordCountMap = new LinkedHashMap<Integer,Integer>();
	public static String[] words ;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		words = (input.nextLine()).split(" ");
		int id = 0 ;
		String review = "";
		int totalReviews = Integer.parseInt(input.nextLine());
		for(int i = 0 ; i < totalReviews ; i++){
			id = Integer.parseInt(input.nextLine());
			review = input.nextLine();
			findCount(id,review);
		}
		printOrder(hotelWordCountMap);
		input.close();
	}

	public static void printOrder(LinkedHashMap<Integer,Integer> hotelWordCountMap){
		int maxCount = Collections.max(hotelWordCountMap.values());
		int valueItem = 0 ,countSet = 0, hotelCount = hotelWordCountMap.size();

		while(countSet < hotelCount){
			Set<Map.Entry<Integer,Integer>> entry = hotelWordCountMap.entrySet();
			for(Map.Entry<Integer, Integer> en : entry){
				valueItem = en.getValue(); 
				if(valueItem == maxCount){
					System.out.print(en.getKey()+" ");
					countSet++;
					maxCount--;
					break;
				}
			}
		}
	}

	public static void findCount(int idNum, String feedback){
		int count = 0;
		String[] review = feedback.split(" ");
		for(int i = 0 ; i < words.length ; i++){
			for(int j = 0 ; j < review.length ; j++){
				if(words[i].equals(review[j])){
					count = count + 1;
				}
			}
		}
		if(!hotelWordCountMap.containsKey(idNum)){
			hotelWordCountMap.put(idNum,count);
		}else{
			hotelWordCountMap.put(idNum,(hotelWordCountMap.get(idNum)) + count); 
		}
	}
}
