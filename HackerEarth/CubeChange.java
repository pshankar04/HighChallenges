package HackerEarth;

import java.util.Scanner;

public class CubeChange {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = input.nextInt();
		long num = 0 , result = 0;
		for(int i = 0 ; i < tc ; i++){
			num = input.nextLong();
			if(num == 1){
				System.out.println("1");
			}else{
				result = (num * num * num) - ((num - 2) * (num - 2) * (num - 2));
				System.out.println(result);
			}
		}
		input.close();
	}
}
