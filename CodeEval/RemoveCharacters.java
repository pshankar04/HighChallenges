package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;

public class RemoveCharacters {
	public static HashSet<String> charSet ;  
	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				removeChars(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void removeChars(String str){

		String org = str.split(", ")[0];
		String charString = str.split(", ")[1];
		saveToSet(charString);
		String modifiedString = "";
		for(int i = 0 ; i < org.length() ; i++){
			if(!charSet.contains(org.charAt(i)+"")){
				modifiedString = modifiedString + org.charAt(i);
			}
		}
		System.out.println(modifiedString);
	}

	public static void saveToSet(String specialChars){
		charSet = new HashSet<String>();
		for(int  i = 0 ; i< specialChars.length() ;i++){
			charSet.add(specialChars.charAt(i)+"");
		}

	}
}
