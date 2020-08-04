package HackerRank;

import java.util.LinkedList;
import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ReversePolishNotation {
	public static LinkedList<String> expItemsList = new LinkedList<String>();

	public static void main(String[] args) throws Exception{
		Scanner input = new Scanner(System.in);
		String[] exp = ((input.nextLine()).replaceAll("[\\[\\]']","")).split(",");
		int op1 = 0 , op2 = 0;
		long result = 0 ;
		for(int i = 0 ; i < exp.length ; i++){
			expItemsList.add(exp[i]);
		}
		int j = 0;
		char oper = '0' ;
		while(j < expItemsList.size()){
			
			if(expItemsList.get(j).length() == 1){
				oper = expItemsList.get(j).charAt(0);
			}

			if((oper == '*') || (oper == '+') || (oper == '-') || (oper == '/')){
				result = findExpressionValue(expItemsList.get(j-2),oper,expItemsList.get(j-1));
				System.out.println("j : "+j+"  RES :"+result+" for op1 :"+expItemsList.get(j-2)+" op2 : "+expItemsList.get(j-1));
				expItemsList.remove(j);
				expItemsList.remove(j-1);
				expItemsList.add(j-1,String.valueOf(result));
				expItemsList.remove(j-2);
				j= 0;
				System.out.println(expItemsList);
			} else{
				j++;
			}
			if(expItemsList.size() == 1){
				break;
			}


		}
		input.close();

	}

	public static long findExpressionValue(String op1,char operand,String op2) throws Exception{
		System.out.println("HERE");
		String exp = op1 + operand + op2;
		if(operand == '-' && op2.charAt(0) == '-'){
			exp = op1 + "+" + op2.substring(1);
		}
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		return  (new Double(engine.eval(exp).toString())).longValue();
	}
}
