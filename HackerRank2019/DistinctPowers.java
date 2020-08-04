package HackerRank;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.HashSet;

public class DistinctPowers {
	public static HashSet<BigInteger> productList;
	
	public static void main(String[] args) {
		productList = new HashSet<BigInteger>();
		Scanner input = new Scanner(System.in);
		int number = Integer.parseInt(input.nextLine());
		BigInteger product = new BigInteger("1");
		for(long i = 2 ; i <= number ; i++){
			for(long j = 2 ; j <= number ; j++){
				//product = new BigInteger(String.valueOf(i)).pow(j);
				product = new BigInteger(String.valueOf(expo(new BigInteger(String.valueOf(i)),new BigInteger(String.valueOf(j)))));
				productList.add(product);
			}
		}
		System.out.println(productList.size());
		input.close();
	}

	public static BigInteger expo(BigInteger a, BigInteger b){
	    if (b.intValue() == 1)
	        return new BigInteger(String.valueOf(a));
	    if (b.intValue() == 2)
	    	return  a.multiply(b);

	    if ((b.mod(new BigInteger("2"))).intValue() == 0){
	            return expo(expo(a,b.divide(new BigInteger("2"))),new BigInteger("2"));
	    }
	    else{
	        return a.multiply(expo(expo(a,((b.subtract(new BigInteger("1")))).divide(new BigInteger("2"))),new BigInteger("2")));
	    }
	}
}
