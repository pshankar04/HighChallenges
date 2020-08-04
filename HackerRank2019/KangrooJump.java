package HackerRank;

import java.util.Scanner;

public class KangrooJump {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int x1 = input.nextInt();
		int v1 = input.nextInt();
		int x2 = input.nextInt();
		int v2 = input.nextInt();

		if(measureSync(x1,v1,x2,v2)){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
		input.close();
	}

	public static boolean measureSync(int firstPoint,int firstJump,int secondPoint,int secondJump){

				if((((firstPoint - secondPoint)/(secondJump - firstJump))  > 0)){
					return true;
				}

		if((firstPoint < secondPoint) && (Math.abs(firstPoint - firstJump) > Math.abs(secondPoint - secondJump))        ||
				(firstPoint > secondPoint) && (Math.abs(firstPoint - firstJump) < Math.abs(secondPoint - secondJump))){
			return true;
		}
		else{
			return false;
		}
	}
}
