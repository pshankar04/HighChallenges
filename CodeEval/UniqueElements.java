package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.TreeSet;

public class UniqueElements {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				printUniqueElements(line);
			}
			buffer.close();

		}catch(Exception e){
			e.printStackTrace();
		}

	}
	
	public static void printUniqueElements(String numbers){
		String numList = "";
		TreeSet<Integer> numSet = new TreeSet<Integer>();
		String[] items = numbers.split(",");
		for(int i = 0 ; i < items.length ;i++){
			numSet.add(Integer.parseInt(items[i]));
		}
		
		for(Integer num : numSet){
			numList = numList + String.valueOf(num) +",";
		}
		System.out.println(new StringBuilder(numList).deleteCharAt(numList.length()-1));
		
	}

}
