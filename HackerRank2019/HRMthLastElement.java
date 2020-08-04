package HackerRank;

import java.util.Scanner;

public class HRMthLastElement {

	public static void main(String[] args) {
		Scanner numInput = new Scanner(System.in);
		Scanner strInput = new Scanner(System.in);
		
		int position = numInput.nextInt();
		String strNumbers = strInput.nextLine();
		String[] numbers = strNumbers.split(" ");
		 
		if( numbers.length < position){
			System.out.println("NIL");
		}
		int count = 1;
		for(int k = (numbers.length - 1) ; k >= 0 ; k--){
			if(count == position){
				System.out.println(numbers[k]);
				break;
			}else{
				count++;
			}
		}

	}

}
