package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class EvenNumbers {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				 if(((Integer.parseInt(line)) % 2) == 0) System.out.println(1);
				 else System.out.println(0);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
