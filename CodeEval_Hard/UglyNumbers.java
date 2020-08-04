package CodeEval_Hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;

public class UglyNumbers {

	public static HashSet<String> expressionsSet ;
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
		expressionsSet = new HashSet<String>();
		int count = 0 , signCount = 1 , position = 0; 
		String minus = "-" , plus = "+" , sign = minus;
		String expression = "" , middleOp = "";
		
		if(series.length() == 1){
			int number = Integer.parseInt(series);
			if((Math.pow(Double.valueOf(3),((series.length()) - 1))) == 1){
				if(((number % 2) == 0) || ((number % 3) == 0) || ((number % 5) == 0) || ((number % 7) == 0)){
					count++;
				}
			} 
		}else{
			while(signCount < series.length()){
				for(int i = 1 ; i < series.length() ; i++){
					expression = series.charAt(position) + sign + middleOp + series.substring(signCount - position);
					expressionsSet.add(expression);
					sign = plus;
				}
				sign = minus;
				middleOp = series.charAt(signCount)+"";
				signCount++;
			}
		}
		System.out.println(count);
	}
}
