package HackerEarth;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class QuintypeChallenge {

	public static int totalUsers = 0;
	public static int totalTaxis = 0;
	public static HashSet<Integer> taxiDataSet = new HashSet<Integer>();
	public static HashSet<Integer> userJourneySet = new HashSet<Integer>();
	public static LinkedHashMap<Integer,Integer> taxiDataMap = new LinkedHashMap<Integer,Integer>();

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		totalUsers = input.nextInt();
		totalTaxis = input.nextInt();
		fillTaxiData(totalUsers);
		
		for(int i = 1 ; i <= totalUsers ; i++){
			manageTaxis(i,input.nextLine());
		}
		input.close();
	}


	public static void manageTaxis(int userId,String bookingData){
		int startTime = Integer.parseInt(bookingData.split(" ")[0]);
		int journeyDuration = Integer.parseInt(bookingData.split(" ")[1]);
		
		if(!taxiDataSet.isEmpty()){
			taxiDataSet.remove(new Integer(userId));
			taxiDataMap.put(userId, (userId * 100) + journeyDuration);
		}

	}

	public static void fillTaxiData(int taxiCount){

		for(int i = 1 ; i <= taxiCount ; i++){
			taxiDataSet.add(i);
		}
	}
}
