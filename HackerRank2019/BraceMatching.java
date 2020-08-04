package HackerRank;

import java.util.Scanner;
import java.util.Stack;

public class BraceMatching {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		if(check(input.nextLine())){
			System.out.println("True");
		}else{
			System.out.println("False");
		}
		input.close();
	}

	public static boolean check(String str) {
		Stack<String> braceStack = new Stack<String>();

		for(int i = 0 ; i < str.length() ; i++){
			if(str.charAt(i) == '(' || str.charAt(i) == '['){
				braceStack.push(str.charAt(i)+"");
			}else if(str.charAt(i) == ')' || str.charAt(i) == ']'){
				if(str.charAt(i) == ')' && braceStack.peek().equals("(")){
					braceStack.pop();
				}else if(str.charAt(i) == ']' && braceStack.peek().equals("[")){
					braceStack.pop();
				}   
			}
		}
//		if(braceStack.size() == 0){
//			return true;
//		}else{
//			return false;
//		}
		return (braceStack.size() == 0) ? true : false;
	}
}
