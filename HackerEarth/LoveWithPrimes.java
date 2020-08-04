package HackerEarth;

import java.util.Scanner;

public class LoveWithPrimes {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = input.nextInt();
		long num = 0;
		for(int i = 0 ; i < tc ;i++){
			num = input.nextLong();
			if(num == 2){
				System.out.println("Arjit");
			}else{
				System.out.println("Deepa");
			}
		}
		input.close();
	}

}
