package HackerRank;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class SuperHumbleMatrix {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = Integer.parseInt((input.nextLine()).split(" ")[0]);
		int M = Integer.parseInt((input.nextLine()).split(" ")[1]);
		LinkedHashSet<Integer> matrixItemList = new LinkedHashSet<Integer>();
		int maxElement = N * M;
		for(int  i = 1  ; i <= maxElement ; i++){
			matrixItemList.add(i);
		}
		//int count = countPossibleMatrices(maxElement,matrixItemList,N,M);

	}

//	public static int countPossibleMatrices(int max, LinkedHashSet<Integer> itemSet,int row,int col){
//		int[][] matrix = new int[row][col];
//		for(int i = 0 ; i < row; i++){
//			for(int j = 0 ; j < col ; j++){
//				
//			}
//		}
//	}
}
