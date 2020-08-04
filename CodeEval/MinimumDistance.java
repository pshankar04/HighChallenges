package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinimumDistance {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				findMinimum(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void findMinimum(String sororityHouses){
		String[] contents = sororityHouses.split(" ");
		int[] houses = new int[contents.length - 1];
		if(Integer.parseInt(contents[0]) == houses.length){
		for(int i = 0 ; i < contents.length ; i++){
			if( i == 0){
				continue;
			}else{
				houses[i-1] = Integer.parseInt(contents[i]);
			}
		}
		Arrays.sort(houses);	
		int maxHouseNumber = houses[houses.length - 1];
		System.out.println(computeMinimumSum(houses,maxHouseNumber));
		}
		
	}
	
	public static int computeMinimumSum(int[] house,int max){
		ArrayList<Integer> distancesList = new ArrayList<Integer>();
		int sum = 0;
		for(int i = 1 ; i <= max ; i++){
			for(int k = 0 ; k < house.length ; k++){
				sum = sum + Math.abs(house[k] - i);
			}
			distancesList.add(sum);
			sum = 0;
		}
		return Collections.min(distancesList);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
