package HackerEarth;

import java.util.Scanner;

public class MonkEncounterWithPolynomial {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		String dataSet = "";
		int a = 0 , b = 0 , c = 0 , k = 0 ,count = 0;
		boolean found = true;
		for(int i = 0 ; i < tc ; i++){
			dataSet = input.nextLine();
			a = Integer.parseInt(dataSet.split(" ")[0]);
			b = Integer.parseInt(dataSet.split(" ")[1]);
			c = Integer.parseInt(dataSet.split(" ")[2]);
			k = Integer.parseInt(dataSet.split(" ")[3]);
			while(found){
				if(((a * (count * count)) + (b * count) + c) >= k){
					System.out.println(count);
					break;
				}else{
					count++;
				}
			}
			count = 0;
		}
		input.close();
	}

}
