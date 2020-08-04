package Serials;

import java.util.Scanner;

/**
 * 
 * @author puneethshankar
 * class to perform individual operations of player input
 * the inputs which are in the form of 'n*n' will only be processed
 */
public class InputOperations {

	public static void main(String[] args) {

		Scanner strInput = new Scanner(System.in);
		Scanner intInput = new Scanner(System.in);
		// provide n as input for n*n matrix format
		System.out.println("Enter number of squares in a row ; such as \'xxx\' has 3 squares in a row");
		int numberOfSquares = intInput.nextInt();
		// provide comma separated string as input ; if previous input is 3 ,give below input as suggested in the below stdout
		System.out.println("Enter all the squares now ; such as \'xxm,xmx,xxx\' as a single string");
		String userInput = strInput.nextLine();
		MineSweeper player = new MineSweeper(userInput,numberOfSquares);
		PlayerManipulations gamerControl = new PlayerManipulations(player);
		System.out.println("Start playing the game by entering the co-ordinates in \'o(x,y)\' OR \'f(x,y)\' format");
		while(player.isKeepPlaying()){
			String coordinates = strInput.nextLine(); 
			gamerControl.startPlay(coordinates);
		}
		strInput.close();
		intInput.close();

	}
}
