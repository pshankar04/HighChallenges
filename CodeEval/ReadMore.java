package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadMore{

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0) && ((line.trim().length() <= 300))){
				trimSentence(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void trimSentence(String inputLine){
		 
		if(inputLine.length() <= 55){
			System.out.println(inputLine);
		}else if(inputLine.length() > 55){
			inputLine = inputLine.substring(0,40);
			if(inputLine.contains(" ")){
				inputLine = inputLine.substring(0,(inputLine.lastIndexOf(" ")))+"... <Read More>";
			}else if(!inputLine.contains(" ")){
				inputLine = inputLine + "... <Read More>";
			}
			System.out.println(inputLine);
		}
	}
	

}
