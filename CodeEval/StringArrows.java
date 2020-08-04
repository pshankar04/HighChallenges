package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class StringArrows {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				searchArrows(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void searchArrows(String sample){
		 
		int arrowLength = 4,arrowCount = 0;
		String arrowString = "";
		for(int i = 0 ; i < sample.length() ; i++){
			if((i + arrowLength) < (sample.length())){
				arrowString = sample.substring(i,(i+arrowLength+1));
				if((arrowString.equals(">>-->")) || (arrowString.equals("<--<<"))){
					arrowCount++;
				}
			}
		}
		System.out.println(arrowCount);
	}
}
