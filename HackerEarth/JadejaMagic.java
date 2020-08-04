package HackerEarth;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class JadejaMagic {

	public static LinkedList<String> playersList = new LinkedList<String>();
	public static int maxBallCount ;
	static {
		playersList.add("Rohit");
		playersList.add("Dhawan");
		playersList.add("Kohli");
		playersList.add("Yuvraj");
		playersList.add("Raina");
		playersList.add("Dhoni");
		playersList.add("Sir Jadeja");
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		LinkedList<Integer> ballCountList = new LinkedList<Integer>();
		for(int i = 0 ; i < tc ; i++){
			ballCountList.add(Integer.parseInt(input.nextLine()));
		}

		maxBallCount = Collections.max(ballCountList);

		for(Integer ball : ballCountList){
			playMagic(playersList,ball);
		}
		input.close();
	}

	public static void playMagic(LinkedList<String> players,int ballNum){
		LinkedList<String> playerNames = new LinkedList<String>(players);
		int repeatitions = maxBallCount/7;
		int count = 2;
		for(int i = 0 ; i < repeatitions ; i++){
			for(String player : playerNames){
				for(int k = 0 ; k < count ; k++){
					players.add(player);
				}
			}
			count++;
		}
		
		System.out.println(players.get(ballNum -1));
	}

}
