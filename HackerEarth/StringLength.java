package HackerEarth;

import java.util.Scanner;

public class StringLength {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		for(int i = 0 ; i < tc ; i++){
			System.out.println(input.nextLine().length());
		}
		input.close();
	}

}
