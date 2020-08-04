package HackerEarth;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

public class RiseOfTheWeird {
	public static ArrayList<Integer> evenList = new ArrayList<Integer>();
	public static ArrayList<Integer> oddList = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		 Scanner input = new Scanner(System.in);
		 int tc = input.nextInt();
		 int num = 0 , evenSum = 0 , oddSum = 0;
		 for(int i = 0 ; i < tc ; i++){
			 num = input.nextInt(); 
			 if((num % 2) == 0){
				 evenList.add(num);
				 evenSum = evenSum + num;
			 }else{
				 oddList.add(num);
				 oddSum = oddSum + num;
			 }
		 }
		 Collections.sort(evenList);
		 for(Integer even : evenList){
			 System.out.print(even+" ");
		 }
		 System.out.print(evenSum+" ");
		 
		 Collections.sort(oddList);
		 for(Integer odd : oddList){
			 System.out.print(odd+" ");
		 }
		 System.out.print(oddSum+" ");
		 input.close();
	}

}
