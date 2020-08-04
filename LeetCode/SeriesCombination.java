package TestRun;

import java.util.Scanner;

public class SeriesCombination {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int totalNumber = in.nextInt();
		int[] num = new int[totalNumber];
		for(int a = 0 ; a < totalNumber ; a++){
			num[a] = in.nextInt();
		}
		String str ="";
		for(int i = 0,j = 1,k = 2; i < num.length & j<num.length & k<num.length;i++,j++,k++){
			if(k > 4 && j > 3){
				break;
			}else{
				str = num[i]+","+num[j]+","+num[k];
				System.out.println(str);
			}
		}
in.close();
	}

}
