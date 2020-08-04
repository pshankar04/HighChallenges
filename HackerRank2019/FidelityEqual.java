package HackerRank;

import java.util.Scanner;

public class FidelityEqual {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tcCount = Integer.parseInt(input.nextLine());
		if(tcCount > 0){
			for(int i = 0 ; i < tcCount ; i++){
				String[] numArray = new String[Integer.parseInt(input.nextLine())];
				numArray = (input.nextLine()).split(" ");
				if((numArray.length >= 1) && (numArray.length <= 1000) && (checkForEquality(numArray))){
					System.out.println("1");
				}else{
					System.out.println("0");
				}
			}
		}
		input.close();
	}

	public static boolean checkForEquality(String[] nums){
		if(((nums.length) % 2) != 0){
			return false;
		}else{
			int div = (nums.length) / 2;
			int sum1 = Integer.parseInt(nums[0]);
			for(int i = 1 ; i < div ; i++){
				sum1 = (sum1) ^ (Integer.parseInt(nums[i])); 
			}

			int sum2 = Integer.parseInt(nums[div]);
			for(int i = div+1 ; i < nums.length ; i++){
				sum2 = (sum2) ^ (Integer.parseInt(nums[i])); 
			}
			if(sum1 == sum2){
				return true;
			}else{
				return false;
			}
		}
	}
}
