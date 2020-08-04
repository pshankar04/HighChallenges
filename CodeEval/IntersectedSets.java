package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class IntersectedSets {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				findIntersectedItems(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void findIntersectedItems(String numbers){
		String numberList = "";
		String[] set1 = (numbers.split(";")[0]).split(",");
		String[] set2 = (numbers.split(";")[1]).split(",");
		ArrayList<String> numList1 = new ArrayList<String>();
		ArrayList<String> numList2 = new ArrayList<String>();
		ArrayList<String> numList3 = new ArrayList<String>();
		
		for(int i = 0 ; i < set1.length ;i++){
			numList1.add(set1[i]);
		}
		for(int i = 0 ; i < set2.length ;i++){
			numList2.add(set2[i]);
		}
		
		for(String item : numList1){
			if(numList2.contains(item)){
				numList3.add(item);
			} 
		}
		 
		if(numList3.size() == 0){
			System.out.println();
		}else{
			for(String element : numList3){
				numberList = numberList + element + ",";
			}
			System.out.println(removeComma(numberList));	
		}
	}

	public static String removeComma(String word){
		return new String(new StringBuilder(word).deleteCharAt(word.length() - 1));
	}
}
