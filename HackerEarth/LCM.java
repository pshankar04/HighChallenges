package HackerEarth;

import java.util.Scanner;

public class LCM {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		int[] nums = new int[number];
		int count = 0 , j = 0;
		while(count <= number){
			nums = new int[number - count];
			for(int i = count ; i < (number - count) ; i++,j++){
				nums[j] = i + 1;
			}
			System.out.println(findLCM(nums));
			count++;
			j = 0;
		}
		input.close();
	}

	public static int findLCM(int[] num){
		int lcm = 0;
		boolean found;
		for(int i = 1; ; i++){
			found=true;
			for(int x=0; x< num.length;x++){
				if(i % num[x] != 0){
					found=false;
					break;
				}
			}
			if(found){
				lcm=i;
				break;
			}
		}
		return lcm;
	}

}
