package HackerRank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class JumbotailJourneyChallenge {
	public static ArrayList<String> tripList; 

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			int tc = 0;
			if((line = buffer.readLine()) != null){
				tc = Integer.parseInt(line);
				for(int i = 0 ; i < tc ; i++){
					findTrips(buffer.readLine());
				}
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void findTrips(String journey) {

		int tripCount = 0;
		tripList = new ArrayList<String>();
		journey = journey.replace("->","");
		for(int i = 0 ; i < journey.length() ; i++){
			if(tripList.contains(journey.charAt(i)+"")){
				tripCount++;
			}else{
				tripList.add(journey.charAt(i)+"");
			}
		}
		System.out.println(tripCount);

	}
}
