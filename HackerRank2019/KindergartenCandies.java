package HackerRank;

import java.util.LinkedList;
import java.util.Scanner;

public class KindergartenCandies {

	public static LinkedList<Integer> studentsScoresList = new LinkedList<Integer>() ; 
	public static LinkedList<Integer> orderList ; 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int totalStudents = Integer.parseInt(input.nextLine());
		int[] nums = new int[totalStudents];
		for(int k = 0 ; k < totalStudents ; k++){
			nums[k] = Integer.parseInt(input.nextLine());
		}

		System.out.println(distributeCandy(nums));
		input.close();
	}

	public static int distributeCandy(int[] scoreList){
		LinkedList<Integer> orderList = new LinkedList<Integer>();
		int sum = 0;

		for(int i =  0 ; i < scoreList.length ; i++){
			if(scoreList[i] == 1){
				orderList.add(1);
			}else if((i == scoreList.length-1) && (scoreList[i] == scoreList[i-1])){
				orderList.add(safeAdd(orderList.get(i-1) - 1));
			}else if((i == scoreList.length-1) && (scoreList[i] < scoreList[i-1])){
				orderList.add(1);
			}else if((i == scoreList.length-1) && (scoreList[i] > scoreList[i-1])){
				orderList.add(safeAdd(orderList.get(i-1) + 1));
			}
			else if((i == 0) && ((i+1) <= scoreList.length) && (scoreList[i+1] > scoreList[i])){
				orderList.add(1);
			}else if((i == 0) && ((i+1) <= scoreList.length) && (scoreList[i+1] <= scoreList[i])){
				orderList.add(2);
			}else if(((i+1) == scoreList.length)){
				if(scoreList[i-1] < scoreList[i]){
					orderList.add(safeAdd(orderList.get(i-1) + 1));
				}else{
					orderList.add(safeAdd(orderList.get(i-1) - 1));
				}
			}
			else if(((i+1) <= scoreList.length) && (scoreList[i+1] >= scoreList[i])){
				if(scoreList[i-1] < scoreList[i]){
					orderList.add(safeAdd(orderList.get(i-1) + 1));
				}else if(scoreList[i-1] == scoreList[i]){
					orderList.add(safeAdd(orderList.get(i-1) - 1));
				}else if(scoreList[i-1] > scoreList[i] && (scoreList[i] > 1)){
					if(i == scoreList.length - 2){
						orderList.add(2);
					}else if(scoreList[i] >= 2){
						orderList.add(1);
					}else{
						orderList.add(safeAdd(orderList.get(i-1) - 1));
					}
				}else{
					orderList.add(1);
				}
			}
			else if((i+1) <= scoreList.length && scoreList[i+1] < scoreList[i]){
				if(scoreList[i-1] < scoreList[i]){
					orderList.add(safeAdd(orderList.get(i-1) + 1));
				}else if(scoreList[i-1] == scoreList[i]){
					orderList.add(safeAdd(orderList.get(i-1) - 1));
				}else if(scoreList[i-1] > scoreList[i] && (scoreList[i] > 1)){
					if(i == scoreList.length - 2){
						orderList.add(2);
					}else{
						orderList.add(safeAdd(orderList.get(i-1) - 1));
					}
				}else{
					orderList.add(1);
				}
			}
		}
		System.out.println(orderList);

		for(Integer j : orderList){
			sum = sum + j;
		}
		return sum;
	}

	public static int safeAdd(int num){
		int number = 1;
		if(num <= 0){
			number = 1;
		}else{
			number = num;
		}
		return number;
	}
}

