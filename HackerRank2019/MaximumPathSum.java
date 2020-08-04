package HackerRank;

 
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class MaximumPathSum {
	 
	public static LinkedList<LinkedList<String>> seriesList = new LinkedList<LinkedList<String>>();
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		LinkedList<String> series ;
		 
		int totalLines = 0 ;
		int tc = Integer.parseInt(input.nextLine());
		if(tc >= 1 && tc <= 10){
			for(int i = 0 ; i < tc ;i++){
				totalLines = Integer.parseInt(input.nextLine());
				if(totalLines >= 1 && totalLines <= 15){
					series = new LinkedList<String>();
					for(int j = 0 ; j < totalLines ; j++){
						series.add(input.nextLine());
					}
					seriesList.add(series);
				}
			}
		}
		for(LinkedList<String> list : seriesList){
			for(String s : list){
				System.out.println(s);
			}
		}
		input.close();
	}
	
	public static int findMaxNumber(String[] numbers , int index){
		 
		if(Integer.parseInt(numbers[index + 1]) > Integer.parseInt(numbers[index])){
			return Integer.parseInt(numbers[index + 1]);
		}else{ 
			return Integer.parseInt(numbers[index]);
		}
	}
	
	public static LinkedList<Integer> saveToList(String[] nums){
		
		LinkedList<Integer> numsList = new LinkedList<Integer>();
		for(int i = 0 ; i < nums.length ; i++){
			numsList.add(Integer.parseInt(nums[i]));
		}
		return numsList;
	}
	
	public static int getIndex(int maxNum , String[] nums){
		int index = 0;
		for(int i = 0 ; i < nums.length ; i++){
			if(maxNum == Integer.parseInt(nums[i])){
				index = i;
				break;
			}
		}
		return index;
	}
}

 

