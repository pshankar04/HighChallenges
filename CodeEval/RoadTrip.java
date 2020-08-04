package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class RoadTrip {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				cleverTrip(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void cleverTrip(String tripRoute){
		String[] tripPoints = tripRoute.split(";");
		String[] distances = new String[tripPoints.length];
		TreeSet<Integer> distancePointsSet = new TreeSet<Integer>();

		for(int i = 0 ; i < tripPoints.length ; i++){
			distances[i] = tripPoints[i].trim().split(",")[1];
			distancePointsSet.add(Integer.parseInt(distances[i]));
		}

		printDistance(distancePointsSet);
	}

	public static void printDistance(TreeSet<Integer> distanceSet){
		int previousDistance = 0;
		int distance = 0;
		String routes = "";
		Iterator<Integer> itr = distanceSet.iterator();
		while(itr.hasNext()){
			distance = (itr.next()).intValue();
			routes = routes + (distance - previousDistance)+",";
			previousDistance = distance;
		}
		System.out.println(removeComma(routes));
	}

	public static String removeComma(String str){
		return new String(new StringBuilder(str).deleteCharAt(str.length() - 1));
	}

}
