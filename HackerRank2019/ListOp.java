package HackerRank;

import java.util.ArrayList;
import java.util.Scanner;

public class ListOp {

	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		ArrayList<Integer> L= new ArrayList<Integer>();
		while(n>0) {
			int val= sc.nextInt();
			L.add(val);
		}
		int Q= sc.nextInt();
		while(Q-- >0) {
			sc.nextLine();
			String op= sc.next();
			if(op.equalsIgnoreCase("Insert")) {
				int x= sc.nextInt();
				int y= sc.nextInt();
				L.add(x,y);
			}
			else if(op.equalsIgnoreCase("Delete")) {
				int x= sc.nextInt();
				L.remove(x);
			}
		}

		System.out.println(L.toString().replace("[", "").replace("]", ""));

	}
}

