package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LetterCaseRatio {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				computeRatio(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void computeRatio(String chars){
		double lowerCaseCount = 0.00,upperCaseCount = 0.00;
		for(int i = 0 ; i < chars.length() ; i++){
			if(((int)chars.charAt(i)) > 96 && ((int)chars.charAt(i)) < 124){
				lowerCaseCount++;
			}else if(((int)chars.charAt(i)) > 64 && ((int)chars.charAt(i)) < 97){
				upperCaseCount++;
			}
		} 
		computeRatio((double)(lowerCaseCount/chars.length()) ,(double)(upperCaseCount/chars.length()));
	}
	
	public static void computeRatio(double lCount, double uCount){
		System.out.println("lowercase: "+String.format("%.2f", (lCount*100))+" "+"uppercase: "+String.format("%.2f", (uCount*100)));
	}

}
