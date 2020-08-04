package HackerRank;

import java.util.Scanner;

public class Duplicaation {

	public static String binString = "0";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int queries =  in.nextInt();
		createString();
		for(int i = 0 ; i < queries ; i++){
			System.out.println(duplication(in.nextInt()));
		}
		in.close();
	}

	public static void createString(){
		while(binString.length() <= 1000){
			formString();
		}
	}
	public static String duplication(int x){
		return binString.charAt(x)+"";
	}

	public static void formString(){
		String tStr = "";
		int result = 0 ;

		for(int i = 0 ; i < binString.length() ; i++){
			result = 1 - Integer.parseInt(binString.charAt(i)+"");
			tStr = tStr + String.valueOf(result);
			result = 0;
		}
		binString = binString + tStr;
	}
}
