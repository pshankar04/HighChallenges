package Serials;

import java.util.Scanner;

public class UserInput {

	public static void main(String[] args) {

		Scanner strInput = new Scanner(System.in);
		Scanner intInput = new Scanner(System.in);
		System.out.println("Enter number of squares in a row ; such as \'xxx\' has 3 squares in a row");
		Testing user = new Testing(intInput.nextInt());
		System.out.println("Enter all the squares now ; such as \'xxm,xmx,xxx\' as a single string");
		String input = strInput.nextLine();
		//user.loadSquares(input);
		user.getMines();
		System.out.println("Start playing the game by entering the co-ordinates in \'o(x,y)\' OR \'f(x,y)\' format");
		while(user.keepPlaying){
			String coordinates = strInput.nextLine(); 
			user.startPlay(coordinates);
		}
		strInput.close();
		intInput.close();

	}

}
