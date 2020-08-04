package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class DigitalWord {
	public static HashMap<String,String> digiMap = new HashMap<String,String>();
	
	static{
		digiMap.put("zero","0");digiMap.put("one","1");digiMap.put("two","2");
		digiMap.put("three","3");digiMap.put("four","4");digiMap.put("five","5");
		digiMap.put("six","6");digiMap.put("seven","7");digiMap.put("eight","8");
		digiMap.put("nine","9");
	}
	
	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				convertToDigits(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void convertToDigits(String number){
		String word = "";
		String[] words = number.split(";");
		for(int  i = 0 ; i < words.length ; i++){
			word = word + digiMap.get(words[i]);
		}
		
		System.out.println(word);	
	}
}
