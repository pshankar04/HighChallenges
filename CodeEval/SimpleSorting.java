package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

public class SimpleSorting {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				sortSimple(line);
				System.out.println();
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void sortSimple(String numbers){
		String number = "";
		ArrayList<Double> numList = new ArrayList<Double>();
		String[] nums = numbers.split(" ");
		if(nums.length > 1){
			for(int i = 0 ; i < nums.length ; i++){
				numList.add(Double.parseDouble(nums[i]));
			}
			Collections.sort(numList);
			for(int  i = 0 ; i < numList.size() ; i++){
				number = String.valueOf(numList.get(i));
				if(((number.substring(number.indexOf(".") + 1)).length()) < 3){
					number = number + "0";
				}
				System.out.print(number+" ");
			}
		}else{
			System.out.print(numbers);
		}
	}
}
