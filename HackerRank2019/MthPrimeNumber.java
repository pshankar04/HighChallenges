package HackerRank;

import java.util.LinkedList;
import java.util.Scanner;

public class MthPrimeNumber {

	public static void main(String[] args) {
		long number = 0;
		LinkedList<Long> numList = new LinkedList<Long>();
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		if(tc >= 1 || tc <= 1000){
			for(int i = 0 ; i < tc ; i++){
				number = Long.parseLong(input.nextLine());
				if(number >= 1 || number <= 10000){
					numList.add(number);
				}
			}
			for(Long num : numList){
				System.out.println(nthPrime(num));
			}
		}
		input.close();
	}

	public static int nthPrime(long n) {
	    if (n < 2) return 2;
	    if (n == 2) return 3;
	    int limit, root, count = 1;
	    limit = (int)(n*(Math.log(n) + Math.log(Math.log(n)))) + 3;
	    root = (int)Math.sqrt(limit) + 1;
	    limit = (limit-1)/2;
	    root = root/2 - 1;
	    boolean[] bools = new boolean[limit];
	    for(int i = 0; i < root; ++i) {
	        if (!bools[i]) {
	            ++count;
	            for(int j = 2*i*(i+3)+3, p = 2*i+3; j < limit; j += p) {
	                bools[j] = true;
	            }
	        }
	    }
	    int p;
	    for(p = root; count < n; ++p) {
	        if (!bools[p]) {
	            ++count;
	        }
	    }
	    return 2*p+1;
	}
}
