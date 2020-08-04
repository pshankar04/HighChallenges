package HackerRank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class ClockHands {

	public static HashMap<Integer,Integer> minuteMap = new HashMap<Integer,Integer>();
	static{

		for(int i = 0 ; i <= 60 ; i++){
			minuteMap.put(i, ((i * 30)/5));
		}
	}
	public static void main(String[] args) {

		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.length() > 0)) {
				System.out.println(computeDegrees(line));
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public static String computeDegrees(String time){
		if(time != null){
			time = time.replace("-","");
			time = time.replace("+","");
			if(time.length() == 3){
				time = "0" + time;
			}
			else if(time.length() == 2){
				time = "00" + time;
			}else if(time.length() == 1){
				time = "000" + time;
			}

			int hour = Integer.parseInt(time.substring(0,2));
			int min = Integer.parseInt(time.substring(2));
			if(hour <= 24 && min < 60){
				int hourInDeg = (min * 30)/60;
				String minDegree = String.valueOf(minuteMap.get(min));
				hour = (hour * 30) + hourInDeg;
				return hour+":"+minDegree;
			}else{
				return "Invalid input:"+time;	
			}
		}
		return null;
	}
}
