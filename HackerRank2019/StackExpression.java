package HackerRank;

import java.util.Scanner;
import java.util.Stack;

public class StackExpression {
	public static String[] inputExp ; 
	public static String[] result ; 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		inputExp = new String[tc];
		result = new String[tc];

		for(int i = 0 ; i < tc ; i++){
			inputExp[i] = input.nextLine();
		}
		result = Braces(inputExp);
		for(String s : result){
			System.out.println(s);
		}

		input.close();
	}

	public static String[] Braces(String[] expressions){
		String exp = "";
		Stack<String> st; 
		int smallOpen = 0 , smallClose = 0, bigOpen = 0 , bigClose = 0, flowerOpen = 0,flowerClose = 0;
		String[] outPutArray = new String[expressions.length];
		for(int j = 0 ; j < expressions.length ; j++){
			exp = expressions[j];
			st = new Stack<String>();
			 
			for(int i = 0 ; i < exp.length() ; i++){
				if((exp.charAt(i)+"").equals("(")){
					st.push("(");
					smallOpen++;
				}else if((exp.charAt(i)+"").equals("{")){
					st.push("{");
					flowerOpen++;
				}else if((exp.charAt(i)+"").equals("[")){
					st.push("[");
					bigOpen++;
				}else if((exp.charAt(i)+"").equals(")")){
					if((st.size() > 0) && st.peek().equals("(")){
						st.pop();
						smallClose++;
					}else{
						smallClose++;
					}
				}else if((exp.charAt(i)+"").equals("]")){
					if((st.size() > 0) && st.peek().equals("[")){
						st.pop();
						bigClose++;
					}else{
						bigClose++;
					}
				}else if((exp.charAt(i)+"").equals("}")){
					if((st.size() > 0) && st.peek().equals("{")){
						st.pop();
						flowerClose++;
					}else{
						flowerClose++;
					}
				} 
			}
			if((st.size() == 0) && (smallOpen == smallClose) && (bigOpen == bigClose) && (flowerOpen == flowerClose)){
				outPutArray[j] = "YES";
			}else{
				outPutArray[j] = "NO";
			}
			smallOpen = 0 ;
			smallClose = 0;
			bigOpen = 0; 
			bigClose = 0; 
			flowerOpen = 0;
			flowerClose = 0;
		}
		return outPutArray;
	}
}

