package HackerEarth;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class CoprimeSequence {
	public static LinkedList<Integer> coprimeList = new LinkedList<Integer>();
	public static HashSet<String> sequenceSet = new HashSet<String>();
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int total = input.nextInt();
		int count = 0 , i = 1 , l = 0 , divCount = 0;
		String str = "";
		while(count < total){
			if(isPrime(i)){
				coprimeList.add(i);
				count++;
			}
			i++;
		}
		for(int j = 0 ; j < coprimeList.size() ; j++){
			 while(l < total){
				 str = str + coprimeList.get(l)+" ";
				 l++;
			 }
			 sequenceSet.add(str);
			 l = 0;
			 str = "";
		}
		 
		HashSet<String> tempSet = new HashSet<String>(sequenceSet);
		for(String s : tempSet){
			for(int m = 0 ; m < s.length() - 1 ; m++){
				if((Integer.parseInt(s.split(" ")[m]) / total) == 1){
					divCount++;
				}else{
					break;
				}
			}
			if(divCount == total){
				sequenceSet.remove(s);
			}
			divCount = 0;
		}
		System.out.println(sequenceSet);
		input.close();
	}

	public static boolean isPrime(int number){
		boolean isPrime = true;
		for(int i=2;i<=number/2;i++)
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
