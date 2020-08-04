package HackerEarth;

import java.util.Scanner;

public class LifeUniverseEverything {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = 0;
		boolean found = false;
		 
		while(!found){
			num = Integer.parseInt(input.nextLine());
			if(num == 42){
				found = true;
			}else{
				System.out.println(num);
			}
		}
		input.close();
	}

}
