package CodeEvalModerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CarRace {

	public static String[] track ;
	public static ArrayList<String> racerList  = new ArrayList<String>();
	public static ArrayList<Double> lapTimeList ;
	public static TreeMap<Double,Integer> racerTimeMap = new TreeMap<Double,Integer>();

	public static void main(String[] args) {

		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			int count = 0;
			while ((line = buffer.readLine()) != null && (line.length() > 0)) {
				if(count == 0){
					track = line.split(" ");
				}else{
					racerList.add(line);
				}
				count++;
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}

		for(String racer : racerList){
			computeLapTime(racer);
		}
		printLapTimings(racerTimeMap);
	}

	public static void printLapTimings(TreeMap<Double,Integer> raceLapMap){

		Set<Map.Entry<Double,Integer>> entrySet = raceLapMap.entrySet();
		for(Map.Entry<Double, Integer> entry : entrySet){
			System.out.println(entry.getValue()+" "+entry.getKey());
		}
	}

	public static double RoundTo2Decimals(double val) {
		DecimalFormat df2 = new DecimalFormat("###.##");
		return Double.valueOf(df2.format(val));
	}

	public static void computeLapTime(String racer){
		double starightMileTime = 0 ;
		double angleCurveTime = 0 ;
		lapTimeList = new ArrayList<Double>();
		int angle = 0;
		int speed = Integer.parseInt(racer.split(" ")[1]);
		double totalLapTime = 0.0;
		double topSpeedDropTime = Double.parseDouble(racer.split(" ")[3]);

		for(int i = 0 , j = i+1 ; i < track.length && j < track.length ; i+=2,j+=2){

			starightMileTime = Double.parseDouble(track[i]);
			starightMileTime = RoundTo2Decimals((starightMileTime * 3600)/speed) ;
			lapTimeList.add(starightMileTime);
			
			angle = Integer.parseInt(track[j]);
			angleCurveTime = RoundTo2Decimals(((angle * angle * topSpeedDropTime)/(180 * 180)));
			lapTimeList.add(angleCurveTime);
			//System.out.println(starightMileTime+" "+angleCurveTime);
			 	
		}

		for(Double d : lapTimeList){
			totalLapTime = totalLapTime + d ; 
		}
		racerTimeMap.put(RoundTo2Decimals(totalLapTime), Integer.parseInt(racer.split(" ")[0]));
	}
}
