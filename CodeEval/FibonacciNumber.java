package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FibonacciNumber {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				System.out.println(fibonacciNumber(Integer.parseInt(line)));
			}
			buffer.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static int fibonacciNumber(int number){
		int num ;
		if(number == 0){
			num = 0;
		}else if(number == 1){
			num = 1;
		}else{
			num = fibonacciNumber(number - 1) + fibonacciNumber(number - 2); 
		}
		return num;
	}

}
