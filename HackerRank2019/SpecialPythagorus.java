package HackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class SpecialPythagorus {

	public static void main(String[] args) {
		int number = 0;
		LinkedList<Integer> numList = new LinkedList<Integer>();
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		if(tc >= 1 || tc <= 3000){
			for(int i = 0 ; i < tc ; i++){
				number = Integer.parseInt(input.nextLine());
				if(number >= 1 || number <= 3000){
					numList.add(number);
				}
			}
			for(Integer num : numList){
				findMaxTriplets(num);
			}
		}
		input.close();
	}

	public static void findMaxTriplets(int number){
		ArrayList<Integer> productList = new ArrayList<Integer>();

		for(int k = number ; k >= 1; k--){
			for(int j = number - 1 ; j >= 1 ; j--){
					if((k >= (number/3)) && (k <= (number/2))  && (sum((number-(k+j)),j,k) == number) && (isTriplet((number-(k+j)),j,k))){
						productList.add((number-(k+j)) * j * k);
				}
			}
		}
		if(productList.size() > 0){
			System.out.println(Collections.max(productList));
		}else{
			System.out.println("-1");
		}
	}
	public static int sum(int a , int b ,int c){
		return (a+b+c);
	}

	public static boolean isTriplet(int a , int b , int c){
		if((c * c) == ((a * a) + (b * b))){
			return true;
		}else{
			return false;
		}
	}
}
