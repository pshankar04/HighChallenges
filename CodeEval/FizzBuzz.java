package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FizzBuzz {

	public static void main(String[] args) {

		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				printNumber(line);
			}
			buffer.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void printNumber(String numbers){

		String[] series = numbers.split(" ");
		printNow(Integer.parseInt(series[0]),Integer.parseInt(series[1]),Integer.parseInt(series[2]));
		System.out.println();

	}

	public static void printNow(int firstDiv,int secondDiv,int range){

		if(firstDiv >= 1 && firstDiv <= 20 && secondDiv >= 1 && secondDiv <= 20 && range >= 21 && range <= 100){
			for(int k = 1 ; k < range + 1 ; k++){
				if( ((k % firstDiv) == 0) && ( (k % secondDiv) == 0)){
					System.out.print("FB ");
				}else if( (k % secondDiv) == 0){
					System.out.print("B ");
				}else if( (k % firstDiv) == 0){
					System.out.print("F ");
				}else{
					System.out.print(k+" ");
				}
			}
		}
	}
}


