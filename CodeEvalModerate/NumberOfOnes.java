package CodeEvalModerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class NumberOfOnes {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			  
			while ((line = buffer.readLine()) != null) {
				countBinaryOnes(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void countBinaryOnes(String number){
		int num = Integer.parseInt(number);
		String binary = Integer.toBinaryString(num);
		int count = 0;
		for(int i = 0 ; i < binary.length() ; i++){
			if((Character.getNumericValue((binary.charAt(i))) == 1)){
				count++;
			}
		}
		System.out.println(count);
	}

}
