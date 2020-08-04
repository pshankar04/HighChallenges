package HackerRank_Domains;

import java.util.Scanner;
import java.util.Stack;

public class StackMaxElement {
	public static void check(int toCheck, Stack<Integer> max){
	    if(max.isEmpty()){
	        max.push(toCheck);
	    } else{
	        int top = max.peek();
	        if(toCheck >= top){
	            max.push(toCheck);
	        }else{
	            max.push(top);
	        }
	    }
	}
	public static void main(String[] args){
	    Scanner stdin = new Scanner(System.in);
	    int n = stdin.nextInt();
	    Stack<Integer> mainStack = new Stack<>();
	    Stack<Integer> maxStack = new Stack<>();

	    for (int quer_i = 0; quer_i < n; quer_i++){
	        int query = stdin.nextInt();
	        switch(query){
	            case 1:
	            int num = stdin.nextInt();
	            mainStack.push(num);
	            check(num, maxStack);
	            break;
	            case 2:
	            mainStack.pop();
	            maxStack.pop();
	            break;
	            case 3:
	            System.out.println(maxStack.peek());
	            break;
	        }
	    }
	    stdin.close();
	}

}
