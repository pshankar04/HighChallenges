package HackerEarth;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class InLoveWithPrimes {
	public static LinkedHashSet<Long> primesSet = new LinkedHashSet<Long>();
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		long max  = 2 , currNum = 0;
		for(int i = 0 ; i < tc ; i++){
			currNum = input.nextLong();

			if(currNum <= max){
				if(primesSet.size() == 0){
					primesSet.add(max);
				}
				findDivision(primesSet,currNum);
			}else if(currNum > max){
				for(long j = max ; j <= currNum ; j++){
					if(checkPrimeOrNot(j)){
						primesSet.add(j);
					}
				}
				findDivision(primesSet,currNum);
				max = currNum;
			}
		}
		input.close();
	}

	public static void findDivision(LinkedHashSet<Long> pset,long num){

		LinkedList<Long> primeList = new LinkedList<Long>(pset);
		boolean found = false;
		int i = 0 , k = 0 , j = 0;
		int index = 0;
		for(j = 0 ; j < primeList.size() ; j++){
			if(primeList.get(j) >= num){
				index = j;
				break;
			}
		}
		if(j == primeList.size()){
			index = j - 1 ;
		}

		for(i = 0 ; i <= index ; i++){
			if(!found){
				for(k = i ; k <= index ; k++){
					if((primeList.get(i) + primeList.get(k)) == num){
						System.out.println("Deepa");
						found = true;
						break;
					}else if((primeList.get(i) >= num) && (primeList.get(k) >= num)){
						System.out.println("Arjit");
						found = true;
						break;
					}
				}
			}else{
				break;
			}
		}
		if((i == primeList.size()) && !found){
			System.out.println("Arjit");
		}
	}

	public static boolean checkPrimeOrNot(long number){
		boolean isPrime = true;
		for(long i=2;i<=number/2;i++)
		{
			if(number == 1) break;
			else if(number % i == 0)
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
