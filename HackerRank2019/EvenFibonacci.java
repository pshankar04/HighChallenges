package HackerRank;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Scanner;

public class EvenFibonacci {
	public static LinkedList<BigInteger> numList;
	public static LinkedList<BigInteger> fibonacciList;
	public static void main(String[] args) {
		BigInteger number ;
		numList = new LinkedList<BigInteger>();
		Scanner input = new Scanner(System.in);
		long tc = Long.valueOf(input.nextLine());
		if(tc >= 1){
			for(long i = 0 ; i < tc ; i++){
				number = new BigInteger(input.nextLine());
				if((number.compareTo(new BigInteger(String.valueOf(10))) == 0) || (number.compareTo(new BigInteger(String.valueOf(10))) == 1)){
					numList.add(number);
				}
			}
			findEvenFibonacciSum(numList);
		}
		input.close();
	}

	public static void findEvenFibonacciSum(LinkedList<BigInteger> numsList){
		
		for(BigInteger num : numsList){
			findEvenSum(num);
		}
	}

	public static void findEvenSum(BigInteger number){
		fibonacciList = new LinkedList<BigInteger>();
		BigInteger sum = new BigInteger("0");
		 
		for(BigInteger i = new BigInteger("1") ;(i.compareTo(new BigInteger(String.valueOf(number))) == -1) ; i = i.add(new BigInteger("1"))){
			if((i.equals(new BigInteger("1")) || (i.equals(new BigInteger("2"))))){
				fibonacciList.add(new BigInteger(String.valueOf(i)));
			}else{
				fibonacciList.add(sum(fibonacciList.getLast(),fibonacciList.get((fibonacciList.size()-1)-1)));
			}
			 
		}
		 
		for(BigInteger i : fibonacciList){
			if(((i.mod(new BigInteger("2"))).equals(new BigInteger("0"))) && (i.compareTo(new BigInteger(String.valueOf(number))) == -1)){
				sum = sum.add(i);
			}
		}
		System.out.println(sum);
	}

	public static BigInteger sum(BigInteger i , BigInteger k){
		return  i.add(k);
	}
}
