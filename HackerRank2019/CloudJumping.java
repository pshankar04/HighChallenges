package HackerRank;

import java.util.Scanner;

public class CloudJumping {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		int[] clouds = new int[tc];
		for(int i = 0 ; i < tc ; i++){
			clouds[i] = input.nextInt();
		}
		 
		findMinimumCount(clouds);
		input.close();
	}

	public static void findMinimumCount(int[] cloud){
		
		int count = 0;
		for(int i = 1 ; i < cloud.length ; i++){
			if(((i + 1) < cloud.length) && (cloud[i + 1] == 0)){
				count++;
				i++;
			}else if((cloud[i] == 0)){
				count++;
			} 
		}
		System.out.println(count);
	}
}
