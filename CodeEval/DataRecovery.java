package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.TreeMap;

public class DataRecovery {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				recoverData(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void recoverData(String string){
		TreeMap<String,String> wordMap = new TreeMap<String,String>();
		String[] words = (string.split(";")[0]).split(" ");
		String[] number = (string.split(";")[1]).split(" ");
		int missingNum = findMissingNumber(number);
		for(int i = 0 ; i < number.length ; i++){
			wordMap.put(number[i],words[i]);
		}
		wordMap.put(String.valueOf(missingNum),words[words.length - 1]);
		formString(new TreeMap<String,String>(wordMap));
	}

	public static int findMissingNumber(String[] nums){
		 
		ArrayList<Integer> numList1 = new ArrayList<Integer>();
		ArrayList<Integer> numList2 = new ArrayList<Integer>();
		for(int i = 0 ; i < nums.length ;i++){
			numList1.add(Integer.parseInt(nums[i]));
		}
		for(int k = 1 ; k <= numList1.size() + 1 ; k++){
			numList2.add(k);
		}
		numList2.removeAll(numList1);
		return numList2.get(0);
	}
	
	public static void formString(TreeMap<String,String> items){
		 
		int count = 1;
		String recoveredString = "";
		for(int i = 0 ; i < items.size() ; i++ , count++){
			recoveredString = recoveredString + items.get(String.valueOf(count)) + " ";
		}
		System.out.println(recoveredString);
	}

}
