package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ShortestRepetition {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				findPeriods(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void findPeriods(String word){
		String period = "" , repetition = "";
		 
		try{
		for(int i = 0 ; i < word.length() ; i++){
			for(int j  = 0 ; j<word.length() ; j++ ){
				if(i == j) {
					period = period + word.charAt(i);
					continue;
				}
				if(word.charAt(i) != word.charAt(j)){
					period = period + word.charAt(j);
				}else if(word.charAt(i) == word.charAt(j)){
					repetition = word.substring(i,j);
					if(period.equals(repetition)){
						System.out.println(repetition.length());
					}
					break;
				}
			}
			if(period.equals(word)){
				System.out.println(period.length());
			}
		}
		}catch(StringIndexOutOfBoundsException se){
			 
		}
	}
}
