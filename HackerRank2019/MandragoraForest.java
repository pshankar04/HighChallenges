package HackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MandragoraForest {
	public static ArrayList<Integer> healthPoints ;
	public static int maxHealthPoint = 0;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = input.nextInt();
		int totalMandagoras = 0;
		for(int i = 0 ; i < tc ; i++){
			totalMandagoras = input.nextInt();
			healthPoints = new ArrayList<Integer>();
			for(int j = 0 ; j < totalMandagoras ; j++){
				healthPoints.add(input.nextInt());
			}
			Collections.sort(healthPoints);
			findMaxExperiencePoints();
		}
		input.close();
	}

	public static void findMaxExperiencePoints(){
		long expPoints = 0;
		long totalHealthPoints = 0;

		for(Integer i : healthPoints){
			totalHealthPoints = totalHealthPoints + i;
		}
		for (int i = 0; i < healthPoints.size(); i++) {
			expPoints = Math.max(expPoints, (i + 1) * totalHealthPoints);
			totalHealthPoints -= healthPoints.get(i);
		}
		System.out.println(expPoints);
	}
}
