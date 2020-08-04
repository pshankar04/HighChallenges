package CodeEvalModerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FlaviousJosephus {

	public static void main(String[] args) {

		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.length() > 0)) {
				printDeathIndex(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void printDeathIndex(String series){
		
		int totalJews = Integer.parseInt(series.split(",")[0]);
		int killIndex = Integer.parseInt(series.split(",")[1]);
		
		
	}
}
