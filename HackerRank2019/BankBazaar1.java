package HackerRank;

import java.util.Scanner;

public class BankBazaar1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] nums = new int[4];
		for(int i = 0 ; i < 4 ; i++){
			nums[i] = Integer.parseInt(input.nextLine());
		}
		checkCombinations(nums);
		input.close();
	}

	public static void checkCombinations(int[] nums){
		String secondCoords = "("+nums[2]+","+nums[3]+")";
		if((withBrace(nums[0],nums[1]).equals(secondCoords))){
			System.out.println("Yes");
		}else if(typeOperation(nums[0],nums[1],secondCoords)){
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
	}

	public static boolean typeOperation(int a, int b, String point){
		 
		boolean found = true;
		boolean reached = false;
		int count = 2;
		while(found){
			 
			if((withBrace(sum(a,b),b).equals(point))){
				found = false;
				reached = true;
				 
			}else if((withBrace(a,sum(b,a)).equals(point))){ 
				found = false;
				reached = true;
				
			}else{
				if(areBalanced(a,b,point)){
					if((count % 2) == 0){
						a = sum(a,b);
					}else{
						b = sum(b,a);
					}
				}else{
					found = false;
				}
			}
			count++;
		}
		return reached;
	}

	public static boolean areBalanced(int a , int b , String second){

		int c = Integer.parseInt(second.split(",")[0].replace("(",""));
		int d = Integer.parseInt(second.split(",")[1].replace(")",""));

		if( (a <= c) && (b <= d)){
			return true;
		}else{
			return false;
		}
	}


	public static int sum(int p , int q){
		return (p+q);
	}
	public static String withBrace(int sum , int var){
		return "("+sum+","+var+")";
	}
}
