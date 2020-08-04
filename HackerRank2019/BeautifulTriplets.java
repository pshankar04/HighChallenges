package HackerRank;


import java.util.Scanner;

public class BeautifulTriplets {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		int total = Integer.parseInt(line.split(" ")[0]);
		int difference = Integer.parseInt(line.split(" ")[1]);
		int[] sequence = new int[total];
		for(int i = 0 ; i < total ; i++){
			sequence[i] = input.nextInt();
		}

		generateTriplets(sequence,difference);
		input.close();
	}

	public static void generateTriplets(int[] nums,int diff){

		int count = 0;

		for(int i = 0 ; i < nums.length ; i++){
			for(int j = i+1 ; j < nums.length ; j++){
				if((nums[j] - nums[i]) == diff){
					for(int k = j+1 ; k < nums.length ;k++){
						if((i < j) && (j < k) && ((nums[k] - nums[j]) == diff)){
							count++;
							break;
						}
					}
				} 
			}
		}
		System.out.println(count);
	}
}
