package HackerRank;

import java.util.Scanner;

public class FairRations {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int totalSubjects = input.nextInt();
		int[] loaves = new int[totalSubjects];
		for(int i = 0 ; i < totalSubjects ; i++){
			loaves[i] = input.nextInt();
		}
		findRequiredLoaves(loaves);
		input.close();
	}

	public static void findRequiredLoaves(int[] breadLoaves){
		int sum = 0;
		sum = findSum(breadLoaves);
		if((sum % 2) != 0){
			System.out.println("NO");
		}else{
			findCount(breadLoaves);
		}

	}

	public static void findCount(int[] breads){
		int count = 0;
		for(int i = 0 ; i < breads.length ; i++){
			if((breads[i] % 2) != 0){
				breads[i]++;
				count++;
				if((i >= 0) && (i < breads.length)){
					if( (i > 0) && ((breads[i - 1] % 2) != 0)){
						breads[i - 1]++;
					}else if(((breads[i + 1] % 2) != 0)){
						breads[i + 1]++;
						count++;
					}else{
						breads[i + 1]++;
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}


	public static int findSum(int[] breads){
		int sum = 0;
		for(Integer i : breads){
			sum = sum + i;
		}
		return sum;
	}
}
