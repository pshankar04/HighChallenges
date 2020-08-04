package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
 

public class WriterFinder {

	public static void main(String[] args) {

		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				System.out.println(findWriter(line));
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static String findWriter(String str){
		String authorString = "";
		int index = 0;
		char[] characters = (str.split("\\| ")[0]).toCharArray();
		String[] indexes = ((str.trim()).split("\\| ")[1]).split(" ");
		for(int i = 0 ; i < indexes.length ; i++){
			index = (new Integer(indexes[i])).intValue();
			authorString = authorString + characters[index-1]+"";
		}
		return authorString;
		 
	}
}
