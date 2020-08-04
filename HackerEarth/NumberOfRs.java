package HackerEarth;

import java.util.Scanner;

public class NumberOfRs {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		String str = "" , temp = "";
		int start = 0 , end = 0 , count = 0;
		for(int i = 0 ; i < tc ; i++){
			str = input.nextLine();
			if(str.contains("K")){
				start = str.indexOf('K');
				end = str.lastIndexOf('K');

				temp = str.substring(0,start);
				for(int k = start ; k < end + 1 ; k++){
					if(str.charAt(k) == 'K'){
						temp = temp + 'R';
					}else if(str.charAt(k) == 'R'){
						temp = temp + 'K';
					}
				}

				//temp = temp + str.substring(end);
				for(int j = 0 ; j < temp.length() ; j++){
					if(temp.charAt(j) == 'R'){
						count++;
					}
				}
				System.out.println(count);
				count = 0;
			}else{
				System.out.println(str.length());
			}
		}
		input.close();
	}

}
