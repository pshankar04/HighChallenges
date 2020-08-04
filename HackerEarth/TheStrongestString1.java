package HackerEarth;

import java.util.ArrayList;
import java.util.Scanner;

public class TheStrongestString1 {
	public static ArrayList<String> subList = new ArrayList<String>();
	public static char bigChar ;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int len = Integer.parseInt(input.nextLine());
		String word = input.nextLine();
		System.out.println(findLargeCharacter(word));
		input.close();
	}

	public static String findLargeCharacter(String s){
		int ch = 26 , index = 0 , i = 0;
		String temp = "";
		while(index < s.length()){
			for(i = index ; i < s.length() ; i++){
				if(((int)s.charAt(i)) == ch){
					index = i + 1;
					temp = temp + s.charAt(i)+"";
					ch--;
					break;
				}else{
					while(index < s.length()){
						if(((int)(s.charAt(i))) == ch){
							index = i + 1;
							temp = temp + s.charAt(i)+"";
							ch--;
							break;
						}else{
							break;
						}
					}
				}
			}
			ch--;
			if(ch == 0){
				break;
			}
		}
		return temp;
	}
}
