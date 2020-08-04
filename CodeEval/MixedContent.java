package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class MixedContent {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				separateDigits(line);
				System.out.println();
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void separateDigits(String sample){
		String[] items = sample.split(",");
		ArrayList<String> digiList = new ArrayList<String>();
		ArrayList<String> wordList = new ArrayList<String>();
		String words ="", digits = "";

		for(int i = 0 ; i < items.length ; i++){
			if(items[i].matches("[a-zA-Z]+")){
				wordList.add(items[i]);
			}else{
				digiList.add(items[i]);
			}
		}

		for(String word : wordList){
			words = words + word + ",";
		}
		for(String digit : digiList){
			digits = digits + digit + ",";
		}
		
		if(wordList.size() == 0){
			System.out.print(removeComma(digits));
		}else if(digiList.size() == 0){
			System.out.print(removeComma(words));
		}else{
		System.out.print(removeComma(words)+"|"+removeComma(digits));
		}
	}

	public static String  removeComma(String test){
		if(test.length() > 0){
			return new String(new StringBuilder(test).deleteCharAt(test.length() - 1));
		}else{
			return "";
		}
	}
}
