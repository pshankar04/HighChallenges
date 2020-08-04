package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ComparePoints {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				pointsComparison(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void pointsComparison(String coords){
		String[] points = coords.split(" ");
		
		if(points.length == 4){
			int x1 = Integer.parseInt(points[0]);
			int y1 = Integer.parseInt(points[1]);
			int x2 = Integer.parseInt(points[2]);
			int y2 = Integer.parseInt(points[3]);


			if((x2 > x1) && (y2 > y1)){
				System.out.println("NE");
			}else if((x2 > x1) && (y2 < y1)){
				System.out.println("SE");
			}else if((x2 < x1) && (y2 > y1)){
				System.out.println("NW");
			}else if((x2 < x1) && (y2 < y1)){
				System.out.println("SW");
			}else if((x2 == x1) && (y2 > y1)){
				System.out.println("N");
			}else if((x2 == x1) && (y2 < y1)){
				System.out.println("S");
			}else if((x2 > x1) && (y2 == y1)){
				System.out.println("E");
			}else if((x2 < x1) && (y2 == y1)){
				System.out.println("W");
			}else if((x2 == x1) && (y2 == y1)){
				System.out.println("here");
			}
		}
	}
}
