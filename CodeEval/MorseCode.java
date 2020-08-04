package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MorseCode {
	public static HashMap<String,String> morseCodeMap = new HashMap<String,String>();

	static{
		morseCodeMap.put("A", ".-");morseCodeMap.put("B", "-...");morseCodeMap.put("C", "-.-.");morseCodeMap.put("D", "-..");morseCodeMap.put("E", ".");
		morseCodeMap.put("F", "..-.");morseCodeMap.put("G", "--.");morseCodeMap.put("H", "....");morseCodeMap.put("I", "..");morseCodeMap.put("J", ".---");
		morseCodeMap.put("K", "-.-");morseCodeMap.put("L", ".-..");morseCodeMap.put("M", "--");morseCodeMap.put("N", "-.");morseCodeMap.put("O", "---");
		morseCodeMap.put("P", ".--.");morseCodeMap.put("Q", "--.-");morseCodeMap.put("R", ".-.");morseCodeMap.put("S", "...");morseCodeMap.put("T", "-");
		morseCodeMap.put("U", "..-");morseCodeMap.put("V", "...-");morseCodeMap.put("W", ".--");morseCodeMap.put("X", "-..-");morseCodeMap.put("Y", "-.--");
		morseCodeMap.put("Z", "--..");morseCodeMap.put("0", "-----");morseCodeMap.put("1", ".----");morseCodeMap.put("2", "..---");morseCodeMap.put("3", "...--");
		morseCodeMap.put("4", "....-");morseCodeMap.put("5", ".....");morseCodeMap.put("6", "-....");morseCodeMap.put("7", "--...");morseCodeMap.put("8", "---..");
		morseCodeMap.put("9", "----.");
	}

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				decryptMessage(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public static void decryptMessage(String msg){
		String text = "";
		String[] words = msg.split("  ");
		for(int i = 0 ; i < words.length ; i++){
			String[] chars = words[i].split(" ");
			for(int k = 0 ; k < chars.length ; k++){
				text = text + findCharacter(chars[k]);
			}
			text = text + " ";
		}
		System.out.println(text);
	}
	
	public static String findCharacter(String letter){
		Set<Map.Entry<String,String>> entrySet = morseCodeMap.entrySet();
		for(Map.Entry<String, String> entry : entrySet){
			if(letter.equals(entry.getValue())){
				return entry.getKey();
			}
		}
		return "";
	}

}
