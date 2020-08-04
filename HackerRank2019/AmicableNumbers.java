package HackerRank;

 
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class AmicableNumbers {
	public static LinkedList<Integer> numList = new LinkedList<Integer>();

	static{
		String[] nums = ("220,284,1184,1210,2620,2924,5020,5564,6232,6368,10744,10856,12285,14595,17296,18416,63020,"
				+ "66928,66992,67095,69615,71145,76084,79750,87633,88730").split(",");
		
		for(int i = 0 ; i < nums.length ; i++){
			numList.add(Integer.parseInt(nums[i]));	
		}
		Collections.sort(numList);
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = 0 , sum = 0;
		int tc = Integer.parseInt(input.nextLine());
		if(tc >= 1 && tc <= 1000){
			for(int i = 0 ; i < tc ; i++){
				num = Integer.parseInt(input.nextLine());
				if(num >= 1 && num <= 100000){
					for(Integer l : numList){
						if(l < num){
							sum = sum + l;
						}else{
							break;
						}
					}
					System.out.println(sum);
					sum = 0;
				}
			}
		}
		input.close();
	}

//	public static void findAmicability(int number){
//		
//		int sum = 0, amicableSum = 0,finalSum = 0;
//		
//		for(int i = number-1 ; i >= 2 ; i--){  
//			for(int j = 1 ; j < i ; j++){
//				if((i % j) == 0){
//					sum = sum + j;
//				}
//			}	 
//			for(int l = 1 ; l < sum - 1 ; l++){
//				if((sum % l) == 0){
//					amicableSum = amicableSum + l;
//				}
//			}	 
//			if((amicableSum == i) && (amicableSum != sum) && (!numList.contains(sum)) && (!numList.contains(amicableSum))){
//				numList.add(sum);
//				numList.add(amicableSum);
//			}
//			sum = 0 ; amicableSum = 0;	
//		}
//		Collections.sort(numList);
//		System.out.println(numList);
//		for(Integer i : numList){
//			finalSum = finalSum + i;
//		}
//		
//		System.out.println(finalSum);
//	}
	
}
