package HackerEarth;

import java.util.LinkedList;
import java.util.Scanner;

public class MillysRankPrediction {

	public static LinkedList<String> rankList ; 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		
		for(int i = 0 ; i < tc ; i++){
			rankList.add(input.nextLine());
		}
		
		predictRanks(rankList);
		rankList = new LinkedList<String>();
		input.close();

	}

	
	public static void predictRanks(LinkedList<String> ranks){
		int totalStudents = 0 , betterStudents = 0 ;
		
		for(String rank : ranks){
			totalStudents = Integer.parseInt(rank.split(" ")[0]);
			betterStudents = Integer.parseInt(rank.split(" ")[1]);
	
			System.out.println(totalStudents - betterStudents);
		}
	}
}
