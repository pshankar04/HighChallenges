package HackerRank;

import java.util.Scanner;

public class EmmasNotebook {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long t = Long.parseLong(input.nextLine());
		System.out.println(findOnes(t));
		input.close();
	}

	public static long findOnes(long seconds){
		long bitCount = 0 , oddbitCount = 0 , evenbitCount = 0;
		 
		for(long i = 1 ; i <= seconds ; i++){
			if(i == 1){
				oddbitCount = 1;
				bitCount = bitCount + oddbitCount;
			}else if(i == 2){
				evenbitCount = 2;
				bitCount = bitCount + evenbitCount;
			}else{
				if((i % 2) == 0){
					evenbitCount = evenbitCount + 1;
					bitCount = bitCount + evenbitCount;
				}else{
					oddbitCount = oddbitCount + 1;
					bitCount = bitCount + oddbitCount;
				}
			}
			 
		}
		
		return bitCount;
	}
}
