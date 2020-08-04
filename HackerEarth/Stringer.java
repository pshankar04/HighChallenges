package HackerEarth;


import java.util.Scanner;

class Stringer{

	public static void main(String[] args){
		
		Scanner scInt = new Scanner(System.in);
		Scanner scStr = new Scanner(System.in);
		try{
		int total = scInt.nextInt();
		String[] strs = new String[total];
		String number = "";
		for(int k = 0 ; k < total ; k++){
			strs[k] = scStr.nextLine();
		}
		int[] nums = new int[10];
		int digit = 0;
		for(int i = 0 ; i < total ; i++){
			number = strs[i];
			for(int j = 0 ; j < number.length() ; j++){
				digit = Integer.parseInt(number.charAt(j)+"");
				nums[digit]++;
			}
			for(int l = 0 ; l < nums.length ; l++){
				System.out.print(nums[l]+" ");
			}
			nums = new int[10];
			System.out.println();
		}

		}catch(Exception e){
			e.printStackTrace();
		}
		scInt.close();
		scStr.close();
	}

}
