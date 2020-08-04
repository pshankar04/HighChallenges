package HackerRank;

import java.util.Scanner;

public class BalancedExpression {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String exp = input.nextLine();
		char[] stackArray = new char[exp.length()];
	    checkBalance(exp.toCharArray() , 6 , stackArray);         
	    input.close();
	}

	
	public static void  checkBalance(char str[ ], int n, char stack [ ])
	{
		int top = -1;
	    for(int i = 0 ; i < n ; i++ )
	    {
	        if (str [ i ] == '('){
	            top = top + 1;
	            stack[ top ] = '(';
	        }
	        if(str[ i ] == ')' )
	        {
	            if(top == -1 )
	            {
	                top = top -1 ;
	                break ;
	             }
	            else
	            {
	                 top = top -1 ;
	            }
	        }
	    }
	    if(top == -1){
	    	System.out.println("String is balanced!");
	    }else{
	        System.out.println("String is unbalanced!");
	    }
	}

}
