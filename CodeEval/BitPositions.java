package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class BitPositions {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				bitComparision(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void bitComparision(String number){
		int num = Integer.parseInt(number.split(",")[0]);	 
		int pos1 = Integer.parseInt(number.split(",")[1]);
		int pos2 = Integer.parseInt(number.split(",")[2]);

		if(num > 2 && pos1 >= 1 && pos2 >= 1){
			String bits = reverseNow(Integer.toString(num,2));
			if(bits.length() >= 2 && (pos1 <= bits.length()) && (pos2 <= bits.length())){
				char[] bitArray = bits.toCharArray();
				if(((pos1 - 1) >= 0) && ((pos2 - 1) >= 0)){
					if(bitArray[pos1 - 1] == bitArray[pos2 - 1]){
						System.out.println("true");
					}else{
						System.out.println("false");
					}
				}
			}
		}
	}
	
	public static String reverseNow(String str){
		
		return new String(new StringBuilder(str).reverse());
	}
}

