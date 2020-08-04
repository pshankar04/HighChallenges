package CareerCup;

import java.util.Arrays;
import java.util.Scanner;

public class FindNumber {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int len = input.nextInt();
		int[] nums = new int[len];
		for(int i = 0 ; i < len ; i++){
			nums[i] = input.nextInt();
		}
		int searchItem = input.nextInt();
		if(exists(nums,searchItem)){
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
		input.close();
	}

	public static boolean exists(int[] ints, int k) {


		int mid = ints.length/2;
		if(ints[mid] == k){
			return true;
		}else if(k < ints[mid]){
			ints = Arrays.copyOfRange(ints,0,mid);
			for(int i = 0 ; i < ints.length ; i++){
				if(ints[i] == k){
					return true;
				}
			}
		}else if(k > ints[mid]){
			ints = Arrays.copyOfRange(ints,mid+1,ints.length);	        	 
			for(int i = 0 ; i < ints.length ; i++){
				if(ints[i] == k){
					return true;
				}
			}
		} 
		return false;
	}
}
