package HackerEarth;

import java.util.Scanner;

public class InfinitePower {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		long num = 0;
		for(int i = 0 ; i < tc ; i++){
			num = Long.parseLong(input.nextLine());
			findPower(num);
		}
		input.close();
	}


	public static void findPower(long number){
		long diff = 0 , count = 0;
		diff = Math.abs(findNextPoweredNumber(number) - number) / Math.abs(number - findPreviousPoweredNumber(number));
		 
		if(diff == 1){
			System.out.println("Unlimited Power");
		}else{
			System.out.println(diff+"/1");
		}
	}

	public static long findPreviousPoweredNumber(long num){
		String digits = "";
		int count = 0;
		for(long j = num - 1 ; j >= 0 ; j--){
			digits = String.valueOf(j);

			for(int i = 0 ; i < digits.length() ; i++){
				if(((Integer.parseInt(digits.charAt(i)+"") == 0) || (Integer.parseInt(digits.charAt(i)+"") >= 2)) 
						&& ((Integer.parseInt(digits.charAt(i)+"")) % 2) == 0){
					count++;
				}
			}
			if(count == digits.length()){
				return Long.parseLong(digits);
			}
			count = 0;
		}

		return Long.parseLong(digits);
	}

	public static long findNextPoweredNumber(long num){
		String digits = "";
		int count = 0;
		for(long j = num + 1 ; j < 10000000; j++){
			digits = String.valueOf(j);
			for(int i = 0 ; i < digits.length() ; i++){
				if(((Integer.parseInt(digits.charAt(i)+"") == 0) || (Integer.parseInt(digits.charAt(i)+"") >= 2)) 
						&& ((Integer.parseInt(digits.charAt(i)+"")) % 2) == 0){
					count++;
				}
			}

			if(count == digits.length()){
				return Long.parseLong(digits);
			}
			count = 0;
		}
		return Long.parseLong(digits);
	}
}
