package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class MaximumRange {

	public static void main(String[] args) {

		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				findMaxRange(line);
				System.out.print("\n");
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void findMaxRange(String numbers){
		ArrayList<Integer> maxNumList = new ArrayList<Integer>();
		int totalSumDays = Integer.parseInt(numbers.split(";")[0]);
		String[] dayValues = (numbers.split(";")[1]).split(" ");
		int sum = 0;
		boolean itemsAdded = false;
		 
		for(int i = 0 ;i < dayValues.length ; i++){
			for(int k = i ; (k < (totalSumDays + i) && (totalSumDays + i) <= dayValues.length) ; k++){
				sum = sum + Integer.parseInt(dayValues[k]);
				itemsAdded = true;
			}
			if(itemsAdded){
				maxNumList.add(sum);
				sum = 0;
				itemsAdded = false;
			}

		}
		  
		if((maxNumList.size() != 0) && (Collections.max(maxNumList) > 0))
			System.out.print(Collections.max(maxNumList));
		else
			System.out.print(0);	
	}
}

