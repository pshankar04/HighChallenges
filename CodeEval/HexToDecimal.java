package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class HexToDecimal {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				decimalConvertion(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void decimalConvertion(String hex){
		Integer decimal = Integer.parseInt(hex, 16);
		System.out.println(decimal);
	}

}
