package HackerRank;

import java.util.Scanner;

public class StringToken {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		String[] tokens=str.split(" ");
		
		for(int i = 0 ; i < str.length() ; i++){
			System.out.println(tokens[i]);
		}

	}

}
