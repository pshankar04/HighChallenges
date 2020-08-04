package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class CompressedSequence {
	public static ArrayList<HashMap<Integer,Integer>> numMapList;
	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				decompress(line);
				System.out.println();
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void decompress(String numberSequence){
		String[] numStrs = numberSequence.split(" ");
		int[] numbers = new int[numStrs.length];
		saveToNumberArray(numStrs,numbers);
		numMapList = saveSeries(numbers);
		printSeries(numMapList);	
	}

	public static int[] saveToNumberArray(String[] strings,int[] nums){
		for(int i = 0 ; i < strings.length ; i++){
			nums[i] = Integer.parseInt(strings[i]);
		}
		return nums;
	}

	public static ArrayList<HashMap<Integer,Integer>> saveSeries(int[] numArray){
		ArrayList<HashMap<Integer,Integer>> countMapList = new ArrayList<HashMap<Integer,Integer>>();
		int count = 1;
		int previousNumber = -1;
		for(int i = 0 ; (i < numArray.length); i++){
			if(numArray[i] != previousNumber){
				HashMap<Integer,Integer> numMap = new HashMap<Integer,Integer>();
				for(int k = i ; k < numArray.length ; k++){
					if(numArray[i] == numArray[k]){
						if(!numMap.containsKey(numArray[i])){
							numMap.put(numArray[i],count);
						}else{
							numMap.put(numArray[i],numMap.get(numArray[i]) +1 );
							previousNumber = numArray[i];
						}
					}else{ 
						if(numMap.containsKey(numArray[i])){
							break;
						}
					}
				}
				countMapList.add(numMap);
			}
		}
		return countMapList;
	}

	public static void printSeries(ArrayList<HashMap<Integer,Integer>> numberMapList){
		Iterator<HashMap<Integer,Integer>> itr = numberMapList.iterator();
		while(itr.hasNext()){ 
			Set<Map.Entry<Integer, Integer>> entrySet = itr.next().entrySet();
			for(Map.Entry<Integer, Integer> entry : entrySet){
				System.out.print(entry.getValue()+ " "+ entry.getKey()+ " ");
			}
		}
	}
}
