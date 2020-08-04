package HackerRank;

import java.util.LinkedList;
import java.util.Scanner;

public class Candies {
	public static LinkedList<Integer> studentsScoresList = new LinkedList<Integer>() ; 
	public static LinkedList<Integer> orderList ; 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int totalStudents = Integer.parseInt(input.nextLine());
		String[] nums = new String[totalStudents];
		for(int k = 0 ; k < totalStudents ; k++){
			nums[k] = input.nextLine();
		}
		for(int i = 0 ; i < nums.length ; i++){
			studentsScoresList.add(Integer.parseInt(nums[i]));
		}
		assignCandies(studentsScoresList);
		input.close();
	}

	public static void assignCandies(LinkedList<Integer> scoreList){
		orderList = new LinkedList<Integer>();
		int sum = 0;
		for(int i =  0 ; i < scoreList.size() ; i++){
			
			if(scoreList.get(i) == 1){
				orderList.add(1);
			}else if((i == scoreList.size()-1) && (scoreList.get(i) == scoreList.get(i - 1))){
				orderList.add(orderList.get(i-1) - 1);
			}else if((i == scoreList.size()-1) && (scoreList.get(i) < scoreList.get(i - 1))){
				orderList.add(1);
			}else if((i == scoreList.size()-1) && (scoreList.get(i) > scoreList.get(i - 1))){
				orderList.add(orderList.get(i-1) + 1);
			}
			else if((i == 0) && ((i+1) <= scoreList.size()) && (scoreList.get(i+1) > scoreList.get(i))){
				orderList.add(1);
			}else if((i == 0) && ((i+1) <= scoreList.size()) && (scoreList.get(i+1) < scoreList.get(i))){
				orderList.add(2);
			}
			else if(((i+1) <= scoreList.size()) && (scoreList.get(i+1) >= scoreList.get(i))){
				if(scoreList.get(i - 1) < scoreList.get(i)){
					orderList.add(orderList.get(i-1) + 1);
				}else{
					orderList.add(orderList.get(i-1) - 1);
				}
			}
			else if((i+1) <= scoreList.size() && scoreList.get(i+1) < scoreList.get(i)){
				if(scoreList.get(i - 1) < scoreList.get(i)){
					orderList.add(orderList.get(i-1) + 1);
				}else if(scoreList.get(i - 1) == scoreList.get(i)){
					orderList.add(orderList.get(i-1) - 1);
				}else{
					orderList.add(1);
				}
			}
		}
		 
		for(Integer j : orderList){
		sum = sum + j;
		}
		System.out.println(sum);
	}
}
