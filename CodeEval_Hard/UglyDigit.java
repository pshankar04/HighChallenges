package CodeEval_Hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashSet;

public class UglyDigit {

	public static LinkedHashSet<String> expressionsSet ;
	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;

			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				checkUgliness(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void checkUgliness(String series){
		expressionsSet = new LinkedHashSet<String>();
		int count = 0 ,position = 0;  
		String expression = "" , minus = "-" , plus = "+";
		if(series.length() == 1){
			int number = Integer.parseInt(series);
			if((Math.pow(Double.valueOf(3),((series.length()) - 1))) == 1){
				if(((number % 2) == 0) || ((number % 3) == 0) || ((number % 5) == 0) || ((number % 7) == 0)){
					count++;
				}
			} 
		}else{
			for(int i = 1 ; i < series.length() ; i++){
				expression = expression + series.charAt(position) + minus + series.substring(position + 1);
				expressionsSet.add(expression);
				if(i > 1){
					expression = series.charAt(0)+"";
				}else{
					expression = "";
				}
				expression = expression + series.charAt(position) + plus + series.substring(position + 1);
				expressionsSet.add(expression);
				expression = series.charAt(0)+"";
				position++;
			}
		}
		System.out.println(expressionsSet);
	}
}
