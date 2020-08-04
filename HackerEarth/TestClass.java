
package HackerEarth;
import java.util.LinkedList;
import java.util.Scanner;

class TestClass {
	public static LinkedList<String> rankList ; 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		String rankOrder = "";
		int total = 0 , better = 0 , worse = 0;
		if(tc >= 1){
			rankList = new LinkedList<String>();
			for(int i = 0 ; i < tc ; i++){
				rankOrder = input.nextLine();
				System.out.println(rankOrder);
				total = Integer.parseInt(rankOrder.split(" ")[0]);
				better = Integer.parseInt(rankOrder.split(" ")[1]);
				worse = Integer.parseInt(rankOrder.split(" ")[2]);
				if((total == (better + worse + 1)) && (better >= 0) && (worse <= total)){ 
				rankList.add(rankOrder);
				}
			}
			if(rankList.size() >= 1){
				predictRanks(rankList);
			}
			rankList = new LinkedList<String>();
		}
		input.close();

	}


	public static void predictRanks(LinkedList<String> ranks){
		int totalStudents = 0 , betterStudents = 0 ;

		for(String rank : ranks){
			totalStudents = Integer.parseInt(rank.split(" ")[0]);
			betterStudents = Integer.parseInt(rank.split(" ")[1]);

			System.out.println(totalStudents - betterStudents);
		}
	}
}
