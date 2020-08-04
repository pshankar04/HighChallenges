package HackerEarth;

import java.util.Scanner;

public class PratheekFriends {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		String data  = "";
		int count = 0, sum = 0;
		long amount = 0;
		boolean found = true , sumFound = false;
		int[] allAmounts ;
		for(int i = 0 ; i < tc ; i++){
			data = input.nextLine();
			count = Integer.parseInt(data.split(" ")[0]);
			amount = Integer.parseInt(data.split(" ")[1]);
			allAmounts = new int[count];
			for(int j = 0 ; j < count ; j++){
				allAmounts[j] = Integer.parseInt(input.nextLine());
			}
			for(int k = 0 ; k < allAmounts.length ; k++){
				if(allAmounts[k] == amount){
					sumFound = true;
					break;
				}
				sum = sum + allAmounts[k];
				if(found){
					for(int p = k + 1 ; p < allAmounts.length ; p++){
						if(k == p){
							continue;
						}else{
							sum = sum + allAmounts[p];
							if(sum > amount){
								sum = 0;
								break;
							}else if(sum == amount){
								sumFound = true;
								found = false;
								break;
							}
						}
					}
					sum = 0;
				}else{
					break;
				}
			}

			if(sumFound){
				System.out.println("YES");
			}else{
				if(allAmounts[allAmounts.length - 1] == amount){
					System.out.println("YES");
				}else{
					System.out.println("NO");
				}
			}
			found = true ;
			sumFound = false;
			sum = 0;
		}
		input.close();
	}
}
