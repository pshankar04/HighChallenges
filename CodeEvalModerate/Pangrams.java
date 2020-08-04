package CodeEvalModerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Pangrams {

	public static ArrayList<String> alphaList = new ArrayList<String>();
	public static ArrayList<String> sentCharList;

	static {
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();

		for(int j = 0 ; j < chars.length ; j++){
			alphaList.add(chars[j]+"");
		}
	}

	public static void main(String[] args) {

		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.length() > 0)) {
				isItPanagram(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

	public static void isItPanagram(String sentence){
		sentCharList = new ArrayList<String>();
		String sent = sentence.toLowerCase();
		String missingChars = "";

		for(int i = 0 ; i < sentence.length() ; i++){
			sentCharList.add(sent.charAt(i)+"");
		}

		for(String ch : alphaList){
			if(!sentCharList.contains(ch)){
				missingChars = missingChars + ch; 
			}
		}
		if(missingChars.length() == 0){
			System.out.println("NULL");
		}else{
			System.out.println(missingChars);
		}

	}
}
