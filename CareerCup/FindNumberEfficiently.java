package CareerCup;

import java.util.Arrays;
import java.util.Scanner;

public class FindNumberEfficiently {
	public static boolean isExist = true;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int len = input.nextInt();
		int[] nums = new int[len];
		for(int i = 0 ; i < len ; i++){
			nums[i] = input.nextInt();
		}
		int searchItem = input.nextInt();
		//		if(exists(nums,searchItem)){
		//			System.out.println("Yes");
		//		}else{
		//			System.out.println("No");
		//		}
		System.out.println(exists(nums,searchItem));
		input.close();
	}

	public static boolean exists(int[] ints, int k) {
		if(ints.length == 0){
			isExist = false;
		}else{

			int mid = ints.length/2;
			if(ints[mid] == k){
				isExist = true;
			}else if(k < ints[mid]){
				ints = Arrays.copyOfRange(ints,0,mid);

				if(ints.length == 1 && ints[0] == k){				 
					isExist = true;

				}else if(ints.length == 1 && ints[0] != k){
					isExist = false;
				}else{				 
					exists(ints,k);
				}
			}else if(k > ints[mid]){
				ints = Arrays.copyOfRange(ints,mid+1,ints.length);	    

				if(ints.length == 1 && ints[0] == k){
					isExist = true;
				}else if(ints.length == 1 && ints[0] != k){
					isExist = false;
				}else{				 
					exists(ints,k);
				}
			} 
		}
		if(isExist){
			return true;
		}else{
			return false;
		}

	}

}
