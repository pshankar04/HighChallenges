package TestRun;

import java.util.Scanner;

public class MissingYou {

	public static boolean notSeenIn30Days;
	public static boolean notTalkingToYou;
	
	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		int count = in.nextInt();
		boolean alive;
		for(int i = 0 ; i < count; i++){
			alive = in.nextBoolean();
			notSeenIn30Days = in.nextBoolean();
			notTalkingToYou = in.nextBoolean();
			while(alive){
				System.out.println(missingYou(in));
			}
		}
	}
	
	public static String missingYou(Scanner input){
		
		if(notSeenIn30Days || notTalkingToYou){
			return "Miss You";
		}else{
			return "I'm Happy";
		}
	}

}
