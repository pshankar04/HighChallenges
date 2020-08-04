package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class RollerCoaster {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				changeCase(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void changeCase(String sentence){
		String modString = "";
		int count = 1;
		for(int i = 0 ; i < sentence.length() ; i++){
			if((sentence.charAt(i)+"").matches("[a-zA-Z]+")){
				 if(i == 0){
					modString = modString + (sentence.charAt(i)+"").toUpperCase();
					count++;
				}else if( ((count) % 2) == 0 ){
					modString = modString + (sentence.charAt(i)+"").toLowerCase();
					count++;
				}else{
					modString = modString + (sentence.charAt(i)+"").toUpperCase();
					count++;
				}
			}
			else{
				modString = modString + sentence.charAt(i);
			}
		}
		System.out.println(modString);
	}
}
