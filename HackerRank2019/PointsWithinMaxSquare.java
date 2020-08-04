package HackerRank;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class PointsWithinMaxSquare {

	public static HashMap<String,Integer> yMap = new HashMap<String,Integer>() ;
	public static HashMap<String,Integer> xMap = new HashMap<String,Integer>() ;
	 

	public static void main(String[] args) {
		String point = "";
		Scanner input = new Scanner(System.in);
		int totalPoints = Integer.parseInt(input.nextLine());
		int xMax = 0 , yMax = 0 , xMin = 0 , yMin = 0;

		for(int i = 0 ; i < totalPoints ; i++){
			point = input.nextLine();
			yMap.put(point, Integer.parseInt(point.split(",")[1]));
			xMap.put(point, Integer.parseInt(point.split(",")[0]));
			
			yMax = Collections.max(yMap.values());
			xMax = Collections.max(xMap.values());
			xMin = Collections.min(xMap.values());
			yMin = Collections.min(yMap.values());
		}
		yMax += 1; xMax += 1;
		yMin -= 1; xMin -= 1;

		while((yMax - xMax) != (yMin - xMin)){
			yMin--;
		}
		System.out.println(xMax * xMax);
		input.close();
	}

}
