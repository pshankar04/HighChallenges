package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CustomModulus {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				findModulus(line);
				//System.out.print("\n");
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void findModulus(String number){
		int N = Integer.parseInt(number.split(",")[0]);
		int M = Integer.parseInt(number.split(",")[1]);
		 
		while(N > M){
			N = N - M;
		}
		System.out.println(N);
	}

}
