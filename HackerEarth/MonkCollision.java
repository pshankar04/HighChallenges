package HackerEarth;

import java.util.HashSet;
import java.util.Scanner;

public class MonkCollision {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		int total = 0;
		HashSet<Integer> numSet ;
		String[] nums ;
		 for(int i = 0 ; i < tc ; i++){
			 total = Integer.parseInt(input.nextLine());
			 nums = new String[total];
			 numSet = new HashSet<Integer>();
			 nums = input.nextLine().split(" ");
			 for(String k : nums){
				 numSet.add(Integer.parseInt(k) % 10);
			 }
			 System.out.println(total - numSet.size());
		 }
		 input.close();
	}

}
