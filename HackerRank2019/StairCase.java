package HackerRank;

import java.util.Scanner;

public class StairCase {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		printStairCase(input);
		 
	}

	public static void printStairCase(int input) {
		for(int i = 1 ; i < (input+1) ; i++){
			printNow(i,input);
			System.out.println();
		}
	}
	public static void printNow(int line,int total){

		int spaces = total - line;
		for(int j = 1 ; j <= spaces ; j++ )
			System.out.print(" ");
		for(int a = 0 ; a < line ;a++)
			System.out.print("#");
	}

}
