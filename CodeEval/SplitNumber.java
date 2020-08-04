package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class SplitNumber {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				splitUpOperation(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public static void splitUpOperation(String sequence){
		String number = sequence.split(" ")[0];
		String alphas = sequence.split(" ")[1];
		String positionChars = "";
		String operator = "";
		String operand1,operand2;
		HashMap<String,String> alphaMap = new HashMap<String,String>();

		for(int i = 0 ; i < alphas.length() ; i++){
			if(Character.isAlphabetic(alphas.charAt(i))){
				positionChars = positionChars + alphas.charAt(i);
			}else{
				operator = alphas.charAt(i)+"";
			}
		}

		for(int i = 0 ; i < number.length() ; i++){
			alphaMap.put(positionChars.charAt(i)+"",number.charAt(i)+"");
		}
		operand1 = alphas.substring(0,alphas.indexOf(operator));
		operand2 = alphas.substring(alphas.indexOf(operator)+ 1,alphas.length());
		String realOp1 = "",realOp2 = "";

		for(int i = 0 ; i < operand1.length() ; i++){
			realOp1 = realOp1 + alphaMap.get(operand1.charAt(i)+"");
		}

		for(int k = 0 ; k < operand2.length() ; k++){
			realOp2 = realOp2 + alphaMap.get(operand2.charAt(k)+"");
		}
		 
		
		int result = 0 ;
		if(operator.equals("+")){
			result = Integer.parseInt(realOp1) + Integer.parseInt(realOp2);
		}else if(operator.equals("-")){
			result = Integer.parseInt(realOp1) - Integer.parseInt(realOp2);
		}else if(operator.equals("*")){
			result = Integer.parseInt(realOp1) * Integer.parseInt(realOp2);
		}else if(operator.equals("/")){
			result = Integer.parseInt(realOp1) / Integer.parseInt(realOp2);
		}else if(operator.equals("%")){
			result = Integer.parseInt(realOp1) % Integer.parseInt(realOp2);
		}else if(operator.equals("^")){
			result = Integer.parseInt(realOp1) ^ Integer.parseInt(realOp2);
		}
		System.out.println(result);
	}
}
