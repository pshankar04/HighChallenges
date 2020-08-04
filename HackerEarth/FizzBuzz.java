package HackerEarth;

import java.util.Scanner;

public class FizzBuzz {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		String rangeCount = "";
		for(int a = 0 ; a < testCases ; a++){
			rangeCount = rangeCount + " " + input.nextInt();
		}
		rangeCount = rangeCount.trim();
		if((testCases != 0) && (rangeCount.length() != 0)){
			printNumber(testCases,rangeCount);
		}

	}

	public static void printNumber(int test, String ranges){
		String[] range = ranges.split(" ");
		for(int i = 0 ; i< range.length ; i++){
			printNow(new Integer(range[i]).intValue());
		}

	}

	public static void printNow(int testSample){

		for(int k = 1 ; k < testSample + 1 ; k++){
			if( (k%3) == 0 || (k%5) == 0 || (((k/3) == 1) && ((k/5) == 1))){
				 if( ((k % 3) == 0) && ( (k % 5) == 0)){
						System.out.println("FizzBuzz");
				}else if( (k % 5) == 0){
					System.out.println("Buzz");
				}else if( (k % 3) == 0){
					System.out.println("Fizz");
				}

			}else{
				System.out.println(k);
			}
		}
	}
}

