package HackerEarth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class ChanduAndHisGirlfriendReturns {
	public static ArrayList<Long> firstList ;
	public static ArrayList<Long> secondList ;
	public static LinkedList<Long> resultList ;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = input.nextInt();
		int firstSize = 0 , secondSize = 0;

		for(int i = 0 ; i < tc ; i++){

			firstSize = input.nextInt();
			secondSize = input.nextInt();
			firstList = new ArrayList<Long>(firstSize);
			for(int j = 0 ; j < firstSize ; j++){
				firstList.add(input.nextLong());
			}
			secondList = new ArrayList<Long>(secondSize);
			for(int k = 0 ; k < secondSize ; k++){
				secondList.add(input.nextLong());
			}
			 
			resultList = new LinkedList<Long>();
			resultList.addAll(firstList);
			resultList.addAll(secondList);
			Collections.sort(resultList);
			 
			for(int m = resultList.size() - 1 ; m >= 0 ; m--){
				System.out.print(resultList.get(m)+" ");
			}
			System.out.println();
		}
		input.close();
	}

	 
}
