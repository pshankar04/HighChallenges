package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class StepwiseWord {

	public static void main(String[] args) {

		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				printStepWise(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void printStepWise(String string){
		String[] words = string.split(" ");
		int longestLength = 0;
		String longWord = "";
		for(int i = 0 ; i < words.length ; i++){
			if(words[i].length() > longestLength){
				longestLength = words[i].length();
				longWord = words[i];
			}
		}
		printWithStars(longWord);
	}
	
	public static void printWithStars(String longest){
		String withStars = "";
		for(int i = 0 ; i< longest.length() ; i++){
			if(i == 0){
				withStars = withStars + longest.charAt(i) + " ";
			}else{
				withStars = starsPrinting(i,withStars);
				withStars = withStars + longest.charAt(i) + " ";
			}
		}
		System.out.println(withStars);
	}
	
	public static String starsPrinting(int index ,String word){
		 int count = 0;
		 while(count < index){
			 word = word +"*";
			 count++;
		 }
		 return word;
	}

}
