package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ZeroJuggles {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				juggleZeros(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void juggleZeros(String binary){
		String[] binaries = binary.split(" ");
		String binaryNum = "";
		int binaryLength = 0;
		if(binaries.length >= 2){
			for(int i = 0 ; i < binaries.length ; i = i+2){
				if(binaries[i].equals("00")){
					binaryLength = binaries[i+1].length();
					for(int k = 0 ; k < binaryLength ; k++){
						binaryNum = binaryNum + "1";
					}
				}else if(binaries[i].equals("0")){
					binaryLength = binaries[i+1].length();
					for(int k = 0 ; k < binaryLength ; k++){
						binaryNum = binaryNum + "0";
					}
				}
			}
			System.out.println(binaryToInteger(binaryNum));
		}else{
			System.out.println(binaryToInteger(binary));
		}
	}

	public static int binaryToInteger(String binary) {
		char[] numbers = binary.toCharArray();
		int result = 0;
		for(int i=numbers.length - 1; i>=0; i--)
			if(numbers[i]=='1')
				result += Math.pow(2, (numbers.length-i - 1));
		return result;
	}
}
