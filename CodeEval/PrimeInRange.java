package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class PrimeInRange {

	public static long sum = 0;
	public static int count = 0;

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				primeNumbers(Integer.parseInt(line));
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void primeNumbers(int number) {

		String primeList = "";
		for(int i = 2 ; i < number ; i++ ){
			if(checkPrimeOrNot(i)){
				primeList = primeList + i + ",";
			}else{
				continue;
			}
		}
		primeList = removeComma(primeList);
		System.out.println(primeList);
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
	
	public static String removeComma(String term){
		return (term.charAt(term.length() -1) == ',') ? new String(new StringBuilder(term).deleteCharAt(term.lastIndexOf(','))) : term;
	}
}

