package HackerEarth;

import java.util.LinkedList;
import java.util.Scanner;

public class Shootout {
	public static LinkedList<LinkedList<String>> coordinatesList;

	public static void main(String[] args) {
		coordinatesList = new LinkedList<LinkedList<String>>();
		LinkedList<String> cList ;
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		if(tc >= 1 && tc <= 10000){
			for(int i = 0 ; i < tc ; i++){
				cList = new LinkedList<String>();
				cList.add(input.nextLine());
				cList.add(input.nextLine());
				cList.add(input.nextLine());
				cList.add(input.nextLine());
				coordinatesList.add(cList);
			}

			for(LinkedList<String> list: coordinatesList){
				processBulletPaths(list);
			}
		}
		input.close();
	}

	public static void processBulletPaths(LinkedList<String> coordsList){
		String a = "", b = "" , c = "" , d = "";
		boolean bulletPath1 = false , bulletPath2 = false , bulletPath3 = false , bulletPath4 = false , bulletPath5 = false , bulletPath6 = false;
		for(int i = 0 ; i < coordsList.size() ; i++){
			if( i == 0){
				a = coordsList.get(i);
			}else if (i == 1){
				b = coordsList.get(i);
			}else if (i == 2){
				c = coordsList.get(i);
			}else if (i == 3){
				d = coordsList.get(i);
			}
		}	
		if(!checkPath(a,b,c)){
			//System.out.println("abc");
			bulletPath1 = true;
		}if(!checkPath(a,d,c)){
			//System.out.println("adc");
			bulletPath2 = true;
		}if(!checkPath(b,a,d)){
			//System.out.println("bad");
			bulletPath3 = true;
		}if(!checkPath(b,c,d)){
			//System.out.println("bcd");
			bulletPath4 = true;
		}if(checkPath(a,c,d)){
			//System.out.println("acd");
			bulletPath5 = true;
		}if(checkPath(a,b,d)){
			//System.out.println("abd");
			bulletPath6 = true;
		}	
		
		if(bulletPath5 && bulletPath6){
			System.out.println("Yes");
			return;
		}
		if(bulletPath1 || bulletPath2 || bulletPath3 || bulletPath4){ 
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
	}

	public static boolean checkPath(String point1 ,String point2 ,String point3){

		int x1 = Integer.parseInt(point1.split(" ")[0]);
		int y1 = Integer.parseInt(point1.split(" ")[1]);
		int x2 = Integer.parseInt(point2.split(" ")[0]);
		int y2 = Integer.parseInt(point2.split(" ")[1]);
		int x3 = Integer.parseInt(point3.split(" ")[0]);
		int y3 = Integer.parseInt(point3.split(" ")[1]);

		try{
			if(((y2 - y1)/(x2 - x1)) == ((y3 - y2)/(x3 - x2))){
				return true;
			}else{
				return false;
			}
		}catch(ArithmeticException ae){
			if((y2 - y1) == (y3 - y2)){
				return true;
			}else{
				return false;
			}

		}

	}
}
