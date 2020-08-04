package HackerRank;

import java.util.Scanner;

public class IsItPossible {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		int d = input.nextInt();

		System.out.println(isitpossible(a,b,c,d));
		input.close();
		
	}


	public static String isitpossible(int p,int q,int r,int s){
		boolean found = false;
		while(!found){
			if((p == r) && (q == s)){
				found = true;
				return "Yes";
			}else{
				if(p < r){
					p = p + q;
				}else if((p == r) && (q < s)){
					q = q + p;
				}else if((p > r) || (q > s)){
					found = true;
					return "No";
				}
			}
		}
		return "No";
	}
}
