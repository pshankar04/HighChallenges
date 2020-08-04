package HackerEarth;

import java.util.Scanner;

public class IntelligentGirl {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String series = input.nextLine();
		int count = 0 , index = 0;
		while(index < series.length()){
			for(int i = index ; i < series.length() ; i++){
				if(((Integer.parseInt(series.charAt(i)+"")) % 2) == 0){
					count++;
				}
			}
			System.out.print(count+" ");
			count = 0;
			index++;
		}
		input.close();
	}

}
