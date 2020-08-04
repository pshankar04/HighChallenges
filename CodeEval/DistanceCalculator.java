package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class DistanceCalculator {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				System.out.println(measureDistance(line));
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static int measureDistance(String points){
		String startPoint = points.substring(0,points.indexOf(')') + 1);
		String endPoint = points.replace(startPoint,"").trim();
		return (int)findDistance(startPoint,endPoint);
	}
	
	public static int findDistance(String start,String end){
		int x1 = 0 , x2 = 0 , y1 = 0 , y2 = 0;
		start = start.replace("(",""); start = start.replace(")","");
		end = end.replace("(",""); end = end.replace(")","");
		x1 = Integer.parseInt(start.split(", ")[0]);
		y1 = Integer.parseInt(start.split(", ")[1]);
		x2 = Integer.parseInt(end.split(", ")[0]);
		y2 = Integer.parseInt(end.split(", ")[1]);
		return (int)(Math.sqrt(((x2 - x1) * (x2 - x1)) + (y2 - y1) * (y2 - y1)));
	}

}
