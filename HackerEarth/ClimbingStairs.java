package HackerEarth;

import java.util.Scanner;

public class ClimbingStairs {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long daySteps = input.nextLong();
		long nightSteps = input.nextLong();
		long total = input.nextLong();
		long dayCount = 0; 
		long totalStepCount = 0;

		while(totalStepCount < total){
			totalStepCount = totalStepCount + daySteps;
			if(totalStepCount == total){
				dayCount++;
				break;
			}if(totalStepCount > total){
				dayCount++;
				break;
			}else{
				dayCount++; 
				totalStepCount = totalStepCount - nightSteps;
			}
		}
		System.out.println(dayCount);
		input.close();
	}

}
