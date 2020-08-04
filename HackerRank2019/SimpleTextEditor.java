package HackerRank_Domains;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {

	public static Stack<String> opStack = new Stack<String>();
	public static String temp = "";
	public static LinkedList<String> opsList = new LinkedList<String>();

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		opStack.push(temp);
		for(long i = 0 ; i < tc  ; i++){
			performOperation(input.nextLine().trim());
		}
		input.close();
	}	

	public static void performOperation(String str){

		
		if(str.charAt(0) == '1'){
			temp = temp + str.substring(2);
			opStack.push(temp);
		}else if(str.charAt(0) == '2'){
			temp = temp.substring(0,(temp.length() - Integer.parseInt(str.substring(2))));
			opStack.push(temp);
		}else if(str.charAt(0) == '3'){
			System.out.println(temp.charAt(Integer.parseInt(str.substring(2)) - 1));
		}else if(str.charAt(0) == '4'){
			opStack.pop();
			if(!opStack.isEmpty()){
				temp = opStack.peek();
			}
		}
	}
}
