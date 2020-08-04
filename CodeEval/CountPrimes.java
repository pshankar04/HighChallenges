package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CountPrimes {

	public static long sum = 0;
	public static int count = 0;

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				countPrimeNumbers(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void countPrimeNumbers(String number) {
		int count = 0;
		int start = Integer.parseInt(number.split(",")[0]);
		int end = Integer.parseInt(number.split(",")[1]);
		 
		for(int i = start ; i < end +1 ; i++ ){
			if(checkPrimeOrNot(i)){
				count++;
			}else{
				continue;
			}
		}

		System.out.println(count);
	}

	public static boolean checkPrimeOrNot(int number){

		boolean isPrime = true;
		for(int i=2;i<=number/2;i++)
		{
			if(number % i == 0)
			{
				isPrime=false;
				break;
			}
		}

		if(isPrime){
			return true;
		}else{
			return false;
		}
	}	 
}


