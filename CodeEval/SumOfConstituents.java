package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class SumOfConstituents {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				System.out.println(sumOfDigits(line));
			}
			 
			buffer.close();

		}catch(Exception e){
			e.printStackTrace();
		}

	}
	
	public static int sumOfDigits(String number){
		int sum = 0;
		char[] charDigits = number.toCharArray();
		for(int k = 0 ; k < charDigits.length ; k++){
			sum = sum + Character.getNumericValue(charDigits[k]);
		}
		return sum;
	}

}
