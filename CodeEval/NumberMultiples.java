package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class NumberMultiples {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				multiples(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void multiples(String number){

		int range = Integer.parseInt(number.split(",")[0]);
		int digit = Integer.parseInt(number.split(",")[1]);

		boolean numFound = true;
		int n = 1;
		while(numFound){
			if(range == digit){
				System.out.println(range);
				numFound = false;
			}else if(range > digit){
				if((range - (n * digit)) > 0){
					n++;
				}else if((range - (n * digit)) < 0){
					range++;
				}else if((range - (n * digit)) == 0){
					System.out.println(range);
					numFound = false;
				}
			}
		}
	}
}
