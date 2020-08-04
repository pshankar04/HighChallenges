package Serials;

import java.util.Scanner;

public class Modulo3Strings {
	public static int count = 0;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		String str ;

		for(int i = 0 ; i < tc ; i++){
			str = input.nextLine();
			findCount(str);
			count = 0;
		}
		input.close();
	}

	public static void findCount(String s){

		if(s.length() < 3){
			System.out.println("0");
		}else if(s.length() == 3){
			System.out.println("1");
		}else{
			for(int i = 0 ; i < s.length() ; i += 3){
				if((s.length() - i) >= 3){
					count++;
				}else if((s.length() - i) == 0){
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
