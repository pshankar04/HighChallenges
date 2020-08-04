package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class HiddenDigits {
	public static HashMap<String,String> charMap = new HashMap<String,String>();
	static{
		charMap.put("a","0");charMap.put("b","1");charMap.put("c","2");charMap.put("d","3");
		charMap.put("e","4");charMap.put("f","5");charMap.put("g","6");charMap.put("h","7");
		charMap.put("i","8");charMap.put("j","9");

	}
	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				searchHiddenDigits(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void searchHiddenDigits(String word){
		String hiddenDigits = "";
		for(int i = 0 ; i < word.length() ; i++){
			if(charMap.containsKey(word.charAt(i)+"")){
				hiddenDigits = hiddenDigits + charMap.get(word.charAt(i)+"");
			}else if(Character.isDigit(word.charAt(i))){
				hiddenDigits = hiddenDigits + word.charAt(i);
			}
		}
		if(!hiddenDigits.equals("")){
			System.out.println(hiddenDigits);
		}else{
			System.out.println("NONE");
		}
	}

}
