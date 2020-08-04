package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ArmstrongNumber {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				System.out.println(isItArmStrong(line));
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	
	public static String isItArmStrong(String number){
		int power = number.length();
		int org = Integer.parseInt(number);
		int sum = 0,product = 1,count = 0;
		for( int i = 0 ; i < number.length() ; i++){
			while(count < power){
				product = product * (Character.getNumericValue(number.charAt(i)));
				count++;
			}
			sum = sum + product;
			product = 1;
			count = 0;
		}
		return (org == sum) ? "True" : "False" ;
	}

}
