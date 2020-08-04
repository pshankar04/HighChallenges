package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class OneZeroTwoZero {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				decipherCode(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void decipherCode(String number){
		int zeroCount = Integer.parseInt((number.split(" ")[0]));
		int range = Integer.parseInt((number.split(" ")[1]));
		int count = 0;
		for(int i = 1 ; i <= range ; i++){
			if(countZeroes(i) == zeroCount){
				count++;
			}
		}
		System.out.println(count);
	}
	
	public static int countZeroes(int num){
		String binary = Integer.toBinaryString(num);
		int totalZeroes = 0;
		for(int k = 0 ; k < binary.length() ; k++){
			if(binary.charAt(k) == '0'){
				totalZeroes++;
			}
		}
		return totalZeroes;
	}
}
