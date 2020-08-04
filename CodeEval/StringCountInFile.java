package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class StringCountInFile {

	public static void main(String[] args) {
		File file = new File(args[0]);
		int wordCount = 0;
		try{
			
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null){
				 String[] strArray = line.split(" ");
				 wordCount = wordCount + strArray.length;
				 strArray = new String[0];
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("wordCount :"+wordCount);
	}

}
