package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class LowestUniqueNumber {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				System.out.println(lowestUnique(line));
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static int lowestUnique(String numberList){
		int count = 1;
		int lowestNumber = 0;
		int lowestIndex = 0;
		String[] numbers = numberList.split(" ");
		TreeMap<Integer,Integer> numberMap = new TreeMap<Integer,Integer>();
		for(int  i = 0 ; i < numbers.length ; i++){
			if(numberMap.isEmpty() && numberMap.size() == 0){
				numberMap.put(Integer.parseInt(numbers[i]), count);
			}else if(numberMap.containsKey(Integer.parseInt(numbers[i]))){
				numberMap.put(Integer.parseInt(numbers[i]), numberMap.get(Integer.parseInt(numbers[i])) + 1);
			}else{
				numberMap.put(Integer.parseInt(numbers[i]),count);
			}
		}
		
		lowestNumber = findIndex(numberMap);
		return findLowestIndex(lowestNumber,numbers);


	}

	public static int findIndex(TreeMap<Integer,Integer> numMap){
		Set<Map.Entry<Integer,Integer>> entrySet = numMap.entrySet();
		for(Map.Entry<Integer, Integer> entry : entrySet){
			if(entry.getValue() == 1){
				return entry.getKey();
			}
		}
		return 0;
	}

	public static int findLowestIndex(int num, String[] numbers){

		for(int i = 0 ; i < numbers.length ; i++){
			if(Integer.parseInt(numbers[i]) == num){
				return i+1;
			}
		}
		return 0;
	}

}
