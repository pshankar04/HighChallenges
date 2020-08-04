package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class StringMask {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				maskString(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void maskString(String word){
		String charString = word.split(" ")[0];
		String bitString = word.split(" ")[1];
		String modString = "";
		for(int i = 0 ; i < bitString.length() ; i++){
			if(bitString.charAt(i) == '1'){
				modString = modString + (charString.charAt(i)+"").toUpperCase();
			}else{
				modString = modString + (charString.charAt(i)+"");
			}
		}
		System.out.println(modString);
	}

}
