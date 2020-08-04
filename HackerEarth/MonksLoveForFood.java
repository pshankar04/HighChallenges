package HackerEarth;

import java.util.Scanner;
import java.util.Stack;

public class MonksLoveForFood {
	public static Stack<Long> foodStack = new Stack<Long>();
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long tc = input.nextLong();
		long nextInput = 0;
		for(long i = 0 ; i < tc ; i++){
			nextInput = input.nextLong();
			if(nextInput == 1){
				if(!foodStack.isEmpty()){
					System.out.println(foodStack.pop());
				}else{
					System.out.println("No Food");
				}
			}else if(nextInput == 2){
				foodStack.push(input.nextLong());
			}
		}
		input.close();
	}

}
