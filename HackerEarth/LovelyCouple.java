package HackerEarth;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class LovelyCouple {
	public static LinkedList<String> goodnessValueList ; 
	public static void main(String[] args) {
		goodnessValueList = new LinkedList<String>();
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());

		for(int i = 0 ; i < tc ; i++){
			goodnessValueList.add(input.nextLine());
		}
		input.close();

		verifyLoveliness(goodnessValueList);
	}

	public static void verifyLoveliness(LinkedList<String> valueList){
		int lcm = 0;
		String primeFacs = "";
		LinkedHashSet<String> primeFactors = new LinkedHashSet<String>();
		for(String goodness : valueList){
			lcm = findLCM(Integer.parseInt(goodness.split(" ")[0]), Integer.parseInt(goodness.split(" ")[1]));
			primeFacs = findPrimeFactors(lcm);
			for(int i = 0 ; i < (primeFacs.split(" ")).length ; i++){
				primeFactors.add(primeFacs.split(" ")[i]);
			}
			if(primeFactors.size() < 2){
				System.out.println("No");
			}else{
				System.out.println("Yes");
			}
		}
	}

	public static int findLCM(int a ,int b){
		int max = 0 , min = 0 , mid = 0 , lcm = 0;
		if(a>b){
			max=a; min=b;
		}else{
			max=b; min=a;
		}
		for(int i=1;i<=min;i++){
			mid = max * i;  
			if((mid % min) == 0){
				lcm = mid;  
				break;  
			}
		}
		return lcm;
	}

	public static String findPrimeFactors(int num){
		int i=2;
		String primes = "";

		while(num > 1){
			if((num % i) == 0){
				primes = primes + i + " ";
				num = num / i;
			}else{
				i++;
			}
		}
		return primes;
	}
}


