package HackerEarth;

import java.util.ArrayList;
import java.util.Scanner;

public class MonkInTheLandOfPokemons {
	public static ArrayList<Integer> foodList;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		String data = "";
		int ponds = 0, foodCount = 0;

		for(int i = 0 ; i < tc ; i++){
			foodList = new ArrayList<Integer>();
			ponds = Integer.parseInt(input.nextLine());
			for(long j = 0 ; j < ponds ; j++){
				data = input.nextLine();
				foodList.add(Integer.parseInt(data.split(" ")[0]));
				if(!foodList.contains(Integer.parseInt(data.split(" ")[1]))){
					foodCount++;
				}else if(foodList.contains(Integer.parseInt(data.split(" ")[1]))){
					foodList.remove(new Integer(data.split(" ")[1]));
				}
			}
			System.out.println(foodCount);
			
			foodCount = 0;
		}
		input.close();
	}
}
