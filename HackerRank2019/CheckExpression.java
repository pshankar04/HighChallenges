package HackerRank;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Stack;

public class CheckExpression {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		LinkedHashSet<String> expSet = new LinkedHashSet<String>();
		 
		for(int i = 0 ; i < tc ; i++){
			expSet.add(input.nextLine());
		}
		for(String ex : expSet){
			if(isBalanced(ex)){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}

		input.close();
	}

	public static boolean isBalanced(String exp){
		Stack<String> st = new Stack<String>();
		for(int i = 0 ; i < exp.length() ; i++){
			if((exp.charAt(i)+"").equals("(")){
				st.push("(");
			}else if((exp.charAt(i)+"").equals("{")){
				st.push("{");
			}else if((exp.charAt(i)+"").equals("[")){
				st.push("[");
			}else if((st.size() > 0) && (exp.charAt(i)+"").equals(")")){
				if(st.peek().equals("(")){
					st.pop();
				}
			}else if((st.size() > 0) && (exp.charAt(i)+"").equals("]")){
				if(st.peek().equals("[")){
					st.pop();
				}
			}else if((st.size() > 0) && (exp.charAt(i)+"").equals("}")){
				if(st.peek().equals("{")){
					st.pop();
				}
			}else{
				return false;
			}
		}
		if(st.size() == 0){
			return true;
		}else{
			return false;
		}
	}
}
