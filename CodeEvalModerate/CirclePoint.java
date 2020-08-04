package CodeEvalModerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CirclePoint {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;

			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)) {
				findPoint(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public static void findPoint(String series){
		double distance = 0.0d;
		String[] circleData = series.split(";");
		String centre = circleData[0].substring(circleData[0].indexOf("Center:")+8);
		double radius = Double.parseDouble(circleData[1].substring(circleData[1].indexOf("Radius:")+8));
		String point = circleData[2].substring(circleData[2].indexOf("Point:")+7);
		
		distance = findDistance(centre,point);
		if(distance > radius){
			System.out.println("false");
		}else{
			System.out.println("true");
		}
		 
		
	}
	
	public static double findDistance(String c , String p){
		double dist = 0.0d;
		double xc = Double.parseDouble(c.substring(1,c.indexOf(',')));
		double yc = Double.parseDouble(c.substring(c.indexOf(',')+2,c.indexOf(')')));
		double xp = Double.parseDouble(p.substring(1,p.indexOf(',')));
		double yp = Double.parseDouble(p.substring(p.indexOf(',')+2,p.indexOf(')')));
		
		 dist = Math.sqrt(((xp - xc) * (xp - xc)) + ((yp - yc) * (yp - yc)));
		 return dist;
	}
}
