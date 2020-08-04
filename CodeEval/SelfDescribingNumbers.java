package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
 

public class SelfDescribingNumbers {

	public static HashMap<Integer,Integer> numberMap ; 
	public static HashMap<Integer,Integer> indexMap;
	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim(); 
				describeNumber(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void describeNumber(String number){
		int count = 0;
		indexMap = new HashMap<Integer,Integer>();
		numberMap = new HashMap<Integer,Integer>();
		for(int i = 0 ; i < number.length() ; i++){
			numberMap.put(i,Integer.parseInt(number.charAt(i)+""));  
		}
		for(int k = 0 ; k < number.length() ; k++){
			for(int j = 0 ; j < number.length() ; j++){
				if(Integer.parseInt(number.charAt(j)+"") == k){
					count++;
				}
			}
			indexMap.put(k,count);	
			count = 0;
		}
		System.out.println(measureEquality(indexMap,numberMap));
	}

	public static int measureEquality(HashMap<Integer,Integer> index ,HashMap<Integer,Integer> number){
		boolean areEqual = true;
		for(int i = 0 ; i < number.size() ; i++){
			if(index.get(i) != number.get(i)){
				areEqual = false;
			}
		}
		return areEqual ? 1 : 0;
	}
}
