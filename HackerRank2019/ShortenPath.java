package HackerRank;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class ShortenPath {

	public static LinkedList<String> finalPathSet;
	public static LinkedHashMap<String,Integer> pathCounteMap ;

	public static void main(String[] args) {
		finalPathSet = new LinkedList<String>();
		Scanner input = new Scanner(System.in);
		String directions = input.nextLine();

		for(int i = 0 ; i < directions.length() ; i++){
			finalPathSet.add(directions.charAt(i)+"");
		}
		System.out.println(countPaths(finalPathSet));
		input.close();
	}

	public static String countPaths(LinkedList<String> pathSet){
		pathCounteMap = new LinkedHashMap<String,Integer>();
		int count = 1;
		for(String path : pathSet){
			if(path.equals("E")){
				if(pathCounteMap.containsKey("E")){
					pathCounteMap.put("E", pathCounteMap.get("E") + 1);
				}else{
					pathCounteMap.put("E",count);
				}
			}else  if(path.equals("W")){
				if(pathCounteMap.containsKey("W")){
					pathCounteMap.put("W", pathCounteMap.get("W") + 1);
				}else{
					pathCounteMap.put("W",count);
				}
			}else  if(path.equals("N")){
				if(pathCounteMap.containsKey("N")){
					pathCounteMap.put("N", pathCounteMap.get("N") + 1);
				}else{
					pathCounteMap.put("N",count);
				}
			}else  if(path.equals("S")){
				if(pathCounteMap.containsKey("S")){
					pathCounteMap.put("S", pathCounteMap.get("S") + 1);
				}else{
					pathCounteMap.put("S",count);
				}
			}
		}
		return resolvePaths(pathCounteMap);
	}

	public static String resolvePaths(LinkedHashMap<String,Integer> pathMap){
		LinkedList<String> pathList = new LinkedList<String>();
		int southCount = 0 , northCount = 0 , eastCount = 0 , westCount = 0 , count = 0;
		String eastWestPath = "" , southNorthPath = "" ,finalPath = "";

		if(pathMap.containsKey("S")){
			southCount = pathMap.get("S");
		}
		if(pathMap.containsKey("N")){
			northCount = pathMap.get("N");
		}
		if(pathMap.containsKey("E")){
			eastCount  =  pathMap.get("E");
		}

		if(pathMap.containsKey("W")){
			westCount  =  pathMap.get("W");
		}

		if(westCount >= eastCount){
			count = westCount - eastCount;
			for(int i = 0 ; i < count ; i++){
				eastWestPath = eastWestPath + "W";
			}
			count = 0;
		}if(eastCount >= westCount){
			count =  eastCount - westCount;
			for(int i = 0 ; i < count ; i++){
				eastWestPath = eastWestPath + "E";
			}
			count = 0;
		}if(northCount >= southCount){
			count =  northCount - southCount;
			for(int i = 0 ; i < count ; i++){
				southNorthPath = southNorthPath + "N";
			}
			count = 0;
		}if(southCount >= northCount){
			count =  southCount - northCount;
			for(int i = 0 ; i < count ; i++){
				southNorthPath = southNorthPath + "S";
			}
			count = 0;
		}
		finalPath = eastWestPath + southNorthPath;

		for(int i = 0 ; i < finalPath.length() ; i++){
			pathList.add(finalPath.charAt(i)+"");
		}
		 
		Collections.sort(pathList);
		finalPath = "";

		for(String pa : pathList){
			finalPath = finalPath + pa;
		}
		return finalPath;
	}
}
