package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class HappyNumbers {
	public static boolean isRecursive = false;
	public static String original;
	public static ArrayList<String> cycleItems;
	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				cycleItems = new ArrayList<String>();
				cycleItems.add(line);
				checkHappiness(line);
			}
			buffer.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void checkHappiness(String number){
		int square = 0;
		if(!isRecursive){
			original = number;
		}

		for(int i = 0 ; (i < number.length()) ; i++){
			square = square + Character.getNumericValue(number.charAt(i)) * Character.getNumericValue(number.charAt(i));
		}
		
		if((square != 1) && (!cycleItems.contains(String.valueOf(square))) ){
			isRecursive = true;
			cycleItems.add(String.valueOf(square));
			checkHappiness(String.valueOf(square));
		}else if(square == 1){
			System.out.println(1);
		}else{
			System.out.println(0);
		}
	}
}
