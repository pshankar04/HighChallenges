package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class SumOfIntegers {

	public static int sum = 0;
	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				sum = sum + Integer.parseInt(line);
			}
			System.out.println(sum);
			buffer.close();

		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
