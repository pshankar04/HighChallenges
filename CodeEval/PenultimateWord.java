package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class PenultimateWord {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				System.out.println(line.split(" ")[(line.split(" ").length) -2]);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
