package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ElementSwapper {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				swapElements(line);
				System.out.println();
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void swapElements(String set){
		int first = 0,second = 0;
		String temp;
		String[] numbers = (set.split(" : ")[0]).split(" ");
		String condition = set.split(" : ")[1];
		String[] moreConditions = condition.split(", "); 
		
		for(int i = 0 ; i < moreConditions.length ; i++){
			 first = Integer.parseInt(moreConditions[i].split("-")[0]);
			 second = Integer.parseInt(moreConditions[i].split("-")[1]);
			 temp = numbers[first];
			 numbers[first] = numbers[second];
			 numbers[second] = temp;
		}
		
		for(int k = 0 ; k < numbers.length ; k++){
			System.out.print(numbers[k]+" ");
		}
	}

}
