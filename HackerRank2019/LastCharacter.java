package HackerRank;

import java.util.Scanner;

public class LastCharacter {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String word = input.nextLine();
		lastLetter(word);
		input.close();
	}

	public static void lastLetter(String word){
		System.out.print(word.charAt(word.length() - 1)+" "+word.charAt(word.length() - 2));
	}
}
