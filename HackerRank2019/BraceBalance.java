package HackerRank;

import java.util.Scanner;

public class BraceBalance {
	 

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int total = Integer.parseInt(input.nextLine());
		String[] str = new String[total];
		 
		for(int i = 0 ; i < total ; i++){
			str[i] = input.nextLine();
		}
 
		String[] resultArray = Braces(str);
		for(String result : resultArray){
			System.out.println(result);
		}
		input.close();
	}

	public static String[] Braces(String[] values){
		
		String[] balanceArray = new String[values.length];
		int smallBraceOpen = 10 ,smallBraceClose = 10, flowerBraceOpen = 100 ,flowerBraceClose = 100, squareBraceOpen = 1000, braceCount = 0,squareBraceClose = 1000 , j = 0;
		
		for(String test : values){
			for(int i = 0 ; i < test.length() ; i++){
				if((test.charAt(i) == '(') || (test.charAt(i) == '{') || (test.charAt(i) == '[')){
					//System.out.println("OPEN");
					if((test.charAt(i) == '(')){
						braceCount = braceCount + smallBraceOpen;
					}else if((test.charAt(i) == '{')){
						braceCount = braceCount + flowerBraceOpen;
					}else if((test.charAt(i) == '[')){
						braceCount = braceCount + squareBraceOpen;
					}
				}else if((test.charAt(i) == ')') || (test.charAt(i) == '}') || (test.charAt(i) == ']')){
					//System.out.println("CLOSE :"+braceCount);
					if((test.charAt(i) == ')') && (test.charAt(i - 1) == '(')){
						braceCount = braceCount - smallBraceClose;
					}else if((test.charAt(i) == '}') && (test.indexOf('{') < test.indexOf('}')) && indexBetween(test,test.indexOf('}'),test.indexOf('{'),'[',']')){
						braceCount = braceCount - flowerBraceClose;
					}else if((test.charAt(i) == ']') && (test.indexOf('[') < test.indexOf(']'))){
						braceCount = braceCount - squareBraceClose;
					}
				}
			}
			//System.out.println("BRACECOUNT : "+braceCount);
			if(braceCount == 0){
				balanceArray[j] = "YES";
				j++;
			}else{
				balanceArray[j] = "NO";
				j++;
			}
			braceCount = 0;
			 
		}
		return balanceArray;
	}

	public static boolean indexBetween(String str,int last , int first,char s1,char s2){
		boolean target = false;
		String sample = str.substring(first,last+1);
		if(!sample.contains(s1+"") && !sample.contains(s2+"")){
			target = true;
		}
		return target;
	}

	public static String checkBalance(String test){

		int smallBrace = 10 , flowerBrace = 100 , squareBrace = 1000, braceCount = 0;

		for(int i = 0 ; i < test.length() ; i++){
			if((test.charAt(i) == '(') || (test.charAt(i) == '{') || (test.charAt(i) == '[')){
				if((test.charAt(i) == '(')){
					braceCount += smallBrace;
				}else if((test.charAt(i) == '{')){
					braceCount += flowerBrace;
				}else if((test.charAt(i) == '[')){
					braceCount += squareBrace;
				}
			}else if((test.charAt(i) == ')') || (test.charAt(i) == '}') || (test.charAt(i) == ']')){
				if((test.charAt(i) == ')')){
					braceCount -= smallBrace;
				}else if((test.charAt(i) == '}')){
					braceCount -= flowerBrace;
				}else if((test.charAt(i) == ']')){
					braceCount -= squareBrace;
				}
			}
		}
		if(braceCount == 0){
			return "YES"; 
		}else{
			return "NO";
		}
	}
}
