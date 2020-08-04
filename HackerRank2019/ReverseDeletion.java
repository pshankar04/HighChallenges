package HackerRank;

import java.util.Scanner;

public class ReverseDeletion {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = Integer.parseInt(in.nextLine());
		String str = in.nextLine();
		str = removeCharAt(str,num);
		System.out.println(str);

	}
	
	public static String removeCharAt(String s,int pos){
		return s.substring(0,pos) + s.substring(pos + 1);
	}

}
