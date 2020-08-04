package HackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class AbundantNumber {
	public static LinkedList<Long> numList = new LinkedList<Long>();
	public static LinkedList<Long> nonNumList = new LinkedList<Long>();
	public static ArrayList<Integer> primeNumberList; 


	public static void main(String[] args) {


		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		long num = 0;
		LinkedList<Long> numbersList = new LinkedList<Long>();
		for(int i = 0 ; i < tc ; i++){
			num = Long.parseLong(input.nextLine()); 
			if(num <= 28123){
				numbersList.add(num);
			}else{
				numbersList.add(Long.valueOf(24));	
			}
		}


		generatePrimes((Collections.max(numbersList)).intValue());
		//fillNonAbundants((Collections.max(numbersList)).intValue());
		fillAbundants((Collections.max(numbersList)).intValue());

		for(Long i : numbersList){
			if(i > 28123){
				System.out.println("YES");
			}else{
				if(formAbundants(numList,i)){
					System.out.println("YES");
				}else{
					System.out.println("NO");
				}
			}
		}
		input.close();
	}

	public static void fillAbundants(int num){

		for(long i = 1 ; i <= num ; i++){
			//if(!primeNumberList.contains(i) && !nonNumList.contains(i) && isAbundant(i)){
			//if(!primeNumberList.contains(i)  && isAbundant(i)){
			if(isAbundant(i)){
				numList.add(i);
			}
		}
	}

	public static void fillNonAbundants(int num){

		for(long i = 1 ; i <= num ; i++){
			if(!primeNumberList.contains(i) && isNonAbundant(i)){
				nonNumList.add(i);
			}
		}
	}

	public static boolean isNonAbundant(long num){

		int sum = 0;
		boolean isNonAbundantNumber = false;
		for(int i = 1 ; i <= num/2 ; i++){
			if((num % i) == 0){
				sum = sum + i;
			}
		}
		if((sum < num) || (sum == num)) {
			isNonAbundantNumber = true;
		}else{
			isNonAbundantNumber = false;
		}
		return isNonAbundantNumber;
	}

	public static boolean isAbundant(long num){

		int sum = 0;
		boolean isAbundantNumber = false;
		for(int i = 1 ; i <= num/2 ; i++){
			if((num % i) == 0){
				sum = sum + i;
			}
		}
		if(sum > num){
			isAbundantNumber = true;
		}else{
			isAbundantNumber = false;
		}
		return isAbundantNumber;
	}


	public static boolean formAbundants(LinkedList<Long> numberList, long number){

		boolean matched = false;

		for(int i = 0 ; i < numberList.size() ; i++){
			if(numberList.contains(number - numberList.get(i))){
				matched = true;
				break;
			}
		}
		return matched;
	}

	public static void generatePrimes(int limit) {
		final int numPrimes = countPrimesUpperBound(limit);
		primeNumberList = new ArrayList<Integer>(numPrimes);
		boolean [] isComposite    = new boolean [limit];   
		final int sqrtLimit       = (int)Math.sqrt(limit); 
		for (int i = 2; i <= sqrtLimit; i++) {
			if (!isComposite [i]) {
				primeNumberList.add(i);
				for (int j = i*i; j < limit; j += i) 
					isComposite [j] = true;
			}
		}
		for (int i = sqrtLimit + 1; i < limit; i++){
			if (!isComposite [i])
				primeNumberList.add(i);
		}

	}

	public static int countPrimesUpperBound(long max) {
		return max > 1 ? (int)(1.25506 * max / Math.log((double)max)) : 0;
	}
}
