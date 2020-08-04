package HackerEarth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ProjectTeam {
	public static ArrayList<Integer> sumList ;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		String numbers = "";
		int total = 0;
		int[] nums ;
		for(int i = 0 ; i < tc ; i++){
			sumList = new ArrayList<Integer>();

			numbers = input.nextLine();
			total = Integer.parseInt(numbers.split(" ")[0]);
			nums = new int[total];
			for(int j = 0 ; j < total ; j++){
				nums[j] = Integer.parseInt(numbers.split(" ")[j + 1]);
			}
			Arrays.sort(nums);
//			for(Integer g : nums){
//				System.out.print(g+" ");
//			}
			for(int k = 0, l = nums.length - 1 ; k < total && l >=0 ; k++,l--){
				if((k > l) && (l < k)){
					break;
				}else{
					sumList.add(nums[k] + nums[l]);
				}
			}
			Collections.sort(sumList);
			System.out.println(Math.abs(sumList.get(sumList.size() - 1) - sumList.get(0)));
			 
		}
		input.close();
	}

}
