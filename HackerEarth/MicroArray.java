package HackerEarth;

import java.util.LinkedList;
import java.util.Scanner;

public class MicroArray {
	public static int[] numberArray;
	public static LinkedList<String> queryList;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		int totalNums = Integer.parseInt(line.split(" ")[0]);
		int totalQueries = Integer.parseInt(line.split(" ")[1]);
		numberArray = new int[totalNums];
		queryList = new LinkedList<String>();
		line = input.nextLine();
		for(int i = 0 ; i < totalNums ; i++){
			numberArray[i] = Integer.parseInt(line.split(" ")[i]);
		}
		for(int j = 0 ; j < totalQueries ; j++){
			queryList.add(input.nextLine());
		}

		for(String query : queryList){
			performOperations(query,numberArray);
		}
		input.close();
	}

	public static void performOperations(String query , int[] nums){

		int index = 0;
		int number = 0;
		int count = 0 , negative = -1;
		if(query.contains("O")){
			index = (Integer.parseInt(query.split(" ")[1])) - 1;
			number = Integer.parseInt(query.split(" ")[2]);
			nums[index] = number;
		}else{
			index = Integer.parseInt(query.split(" ")[0]);
			number = Integer.parseInt(query.split(" ")[1]);
			for(int i = 0 ; i < nums.length ; i++){
				if(nums[i] >= number){
					count++;
				}
				if(count == index){
					System.out.println(i+1);
					break;
				} 
			}
			if(count == 0){
				System.out.println(negative);
			}
		}
	}
}
