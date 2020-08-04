package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class SwapWordNumbers {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				swapNumbers(line);
				System.out.println();
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void swapNumbers(String setWords){
		String[] words = setWords.split(" ");
		String first = "",second = "",temp = "";
		
		for(int i = 0 ; i < words.length ; i++){
			first = words[i].charAt(0)+"";
			second = words[i].charAt(words[i].length() - 1)+"";
			temp = words[i].substring(1, words[i].length()-1);
			System.out.print(second+temp+first+" ");
					
		}
	}

}
