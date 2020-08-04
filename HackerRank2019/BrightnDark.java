package HackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class BrightnDark {
	public static LinkedList<String> darkAreas;
	public static LinkedList<String[]> pointList;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int params = Integer.parseInt(input.nextLine());
		pointList = new LinkedList<String[]>();
		for(int i = 0 ; i< params ; i++){
			String[] nums = input.nextLine().split(" ");
			pointList.add(nums);
		}
		calculateLargeArea(pointList);
		input.close();
	}

	public static void calculateLargeArea(LinkedList<String[]> points){
		darkAreas = new LinkedList<String>();
		String areaIndex = "" ,areas = ""; 
		int sumArea = 0 , percentDark = 0;
		double maxArea = 0.0 , totalArea = 0.0;
		LinkedList<String> pointSet = new LinkedList<String>();
		ArrayList<Integer> pointsArea = new ArrayList<Integer>();
		
		for(String[] num : points){
			for(int i = 0 ; i < num.length ; i++){
				if(num[i].equals("0")){
					areaIndex = areaIndex + i;
				}
			}
			darkAreas.add(areaIndex);
			areaIndex = "";
		}
		
		String[] areaInDark = saveToArray(darkAreas);
		for(int i = 0 ; i < areaInDark.length ; i++){
			sumArea =  areaInDark[i].length();
			for(int j = 0 ; j < areaInDark.length ; j++){
				if(i == j) continue;
				if(areaInDark[i].equals(areaInDark[j]) && !(pointSet.contains(areaInDark[i]))){
					sumArea = sumArea + areaInDark[i].length(); 
				}
			} 
			pointsArea.add(sumArea);
			pointSet.add(areaInDark[i]);
		}
		 
		for(String[] s : pointList){
			totalArea = totalArea + s.length;
		}
		 
		maxArea = Collections.max(pointsArea);
		percentDark = (int)((double)((maxArea/totalArea) * 100));
		System.out.println(maxArea+" "+(percentDark));
		
	}
	
	public static String[] saveToArray(LinkedList<String> dAreas){
		String[] da = new String[dAreas.size()];
		
		for(int i = 0 ; i < dAreas.size() ; i++){
			da[i] = dAreas.get(i);
		}
		return da;
	}

}
