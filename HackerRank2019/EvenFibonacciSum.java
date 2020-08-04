package HackerRank;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Scanner;

public class EvenFibonacciSum {

	public static LinkedList<BigInteger> numList = new LinkedList<BigInteger>();

	public static void main(String[] args) {
		BigInteger number ;
		Scanner input = new Scanner(System.in);
		long tc = Long.valueOf(input.nextLine());
		if(tc >= 1){
			for(long i = 0 ; i < tc ; i++){
				number = new BigInteger(input.nextLine());
				if((number.compareTo(new BigInteger(String.valueOf(10))) == 0) || (number.compareTo(new BigInteger(String.valueOf(10))) == 1)){
					findEvenSum(number);
				}
			}
			findEvenFibonacciSum(numList);
		}
		input.close();
	}

	public static void findEvenFibonacciSum(LinkedList<BigInteger> numsList){

		for(BigInteger num : numsList){
			System.out.println(String.valueOf(num));
		}
	}

	public static void findEvenSum(BigInteger number){
		
		BigInteger sum = new BigInteger("0");
		BigInteger numberSum = new BigInteger("0");
		BigInteger lastButOne = new BigInteger("0");
		BigInteger lastOne = new BigInteger("0");

		for(BigInteger i = new BigInteger("1") ;(i.compareTo(new BigInteger(String.valueOf(number))) == -1) ; i = i.add(new BigInteger("1"))){
			if(i.equals(new BigInteger("1"))){
				lastButOne = i;
			}
			else if(i.equals(new BigInteger("2"))){

				if((i.mod(new BigInteger("2"))).equals(new BigInteger("0"))){
					numberSum = numberSum.add(i);
				}
				lastOne = i;
			}else{
				sum = lastOne.add(lastButOne);
				if(((sum.compareTo(number)) == -1) || ((sum.compareTo(number)) == 0)){
					if((sum.mod(new BigInteger("2"))).equals(new BigInteger("0"))){
						numberSum = numberSum.add(sum);
					}
					lastButOne = lastOne;
					lastOne = sum;
				}else if((sum.compareTo(number)) == 1){
					break;
				}
			}
		}
		numList.add(numberSum);
	}

}
