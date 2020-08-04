package HackerRank;

import java.util.LinkedList;
import java.util.Scanner;

public class SmallestMultiple {

	public static void main(String[] args) {
		int number = 0;
		LinkedList<Integer> numList = new LinkedList<Integer>();
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		if(tc >= 1 && tc <= 10){
			for(int i = 0 ; i < tc ; i++){
				number = Integer.parseInt(input.nextLine());
				if(number >=1 && number <= 40){
					numList.add(number);
				}
			}
			for(Integer num : numList){
				findSmallestMultiple(num);
			}
		}
		input.close();
	}


	public static void findSmallestMultiple(int number){
		long itemNum = (long)number;
		long orgNum = itemNum;
		boolean found = false;
		long num = itemNum;
		while(!found){
			if((number % num) == 0){
				num--;
				if(num == 0){
					found = true;
				}
			}else{
				number++;
				num = orgNum;
			}
		}
		System.out.println(number);
	}
}
