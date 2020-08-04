package CodeEvalModerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TrailStrings {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			int count = 0;
			while ((line = buffer.readLine()) != null && (line.length() >= 3) && line.contains(",") && (count < 40)) {
				removeTrailingString(line);
				count++;
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
 
	public static void removeTrailingString(String content){
		String word1 = content.split(",")[0];
		String word2 = content.split(",")[1];
		String nextWord = "";
		if(word1.length() >= word2.length()){
			nextWord = word1.substring(word1.length() - word2.length(),word1.length());
			if(word2.equals(nextWord)){
				System.out.println(1);	
			}else{
				System.out.println(0);	
			}
		}else{
			System.out.println(0);
		}
	}
}
