package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class SwapCase {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				swapCaseLetters(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void swapCaseLetters(String string){
		String swappedString = "";
		
		for(int i = 0 ; i < string.length() ; i++){
			 if(((int) string.charAt(i) > 96) && ((int) string.charAt(i) < 123)){
				 swappedString = swappedString + (string.charAt(i)+"").toUpperCase();
			 }else if(((int) string.charAt(i) > 64) && ((int) string.charAt(i) < 96)){
				 swappedString = swappedString + (string.charAt(i)+"").toLowerCase();
			 }else{
				 swappedString = swappedString + string.charAt(i)+"";
			 }
		}
		System.out.println(swappedString);
	}
}
