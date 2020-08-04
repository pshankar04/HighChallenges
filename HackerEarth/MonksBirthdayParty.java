package HackerEarth;

import java.util.Scanner;
import java.util.TreeSet;

public class MonksBirthdayParty {
	public static TreeSet<String> nameSet ;


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		long namesCount = 0;
		String name = "";
		for(int i = 0 ; i < tc ; i++){
			namesCount = Long.parseLong(input.nextLine());
			nameSet = new TreeSet<String>();
			for(int j = 0 ; j < namesCount ; j++){
				name = input.nextLine();
				if(!nameSet.contains(name)){
					nameSet.add(name);
				}
			}
			 
			for(String nameValue : nameSet){
				System.out.println(nameValue);
			}
		}
		input.close();
	}

}
