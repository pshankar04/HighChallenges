package HackerEarth;

import java.util.Scanner;

public class LittleDeepuAndArray {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long[] series = new long[(int)input.nextLong()];
		for(int i = 0 ; i < series.length ; i++){
			series[i] = input.nextLong();
		}
		int m = input.nextInt();
		 
		long threshold = 0;
		for(int j = 0 ; j < m ; j++){
			threshold = input.nextLong();
			for(int k = 0 ; k < series.length ; k++){
				if(series[k] > threshold){
					 series[k] = series[k] - 1;
				}
			}
		}
		for(long s : series){
			System.out.print(s+" ");
		}
		input.close();
	}
}
