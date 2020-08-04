package CodeEvalModerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;

public class SquareLocation {

	public static void main(String[] args) {

		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.length() > 0)) {
				findSquares(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public static void findSquares(String series){
		String[] points = series.split(", ");	
		if(!areUnique(points)){
			System.out.println("false");
		}else{
			if(points.length == 4){
				if((distanceBetween(points[0].trim(),points[1].trim())) == (distanceBetween(points[2].trim(),points[3].trim())) &&
						(distanceBetween(points[0].trim(),points[2].trim())) == (distanceBetween(points[1].trim(),points[3].trim())) &&
						(distanceBetween(points[0].trim(),points[3].trim())) == (distanceBetween(points[1].trim(),points[2].trim())))
				{
					System.out.println("true");
				}else{
					System.out.println("false");
				}
			}
		}
	}

	public static boolean areUnique(String[] coords){

		HashSet<String> pointsSet = new HashSet<String>();
		for(int i = 0 ; i < coords.length ; i++){
			pointsSet.add(coords[i]);
		}
		return (pointsSet.size() < 4) ? false : true;

	}


	public static double distanceBetween(String point1 , String point2){

		int x1 = Integer.parseInt(point1.substring(point1.indexOf("(")+1,point1.indexOf(")")).trim().split(",")[0]);
		int y1 = Integer.parseInt(point1.substring(point1.indexOf("(")+1,point1.indexOf(")")).trim().split(",")[1]);
		int x2 = Integer.parseInt(point2.substring(point2.indexOf("(")+1,point2.indexOf(")")).trim().split(",")[0]);
		int y2 = Integer.parseInt(point2.substring(point2.indexOf("(")+1,point2.indexOf(")")).trim().split(",")[1]);

		return Math.sqrt(((x2-x1) * (x2-x1)) + ((y2-y1) * (y2-y1)));
	}
}
