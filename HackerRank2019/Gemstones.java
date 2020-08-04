package HackerRank;

import java.util.ArrayList;
import java.util.Scanner;

public class Gemstones {
	public static ArrayList<String> gemstoneList = new ArrayList<String>();
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int total = Integer.parseInt(in.nextLine());
		for(int i = 0 ; i < total ; i++){
			gemstoneList.add(in.nextLine());
		}
		captureCommonStones(gemstoneList);
		in.close();

	}

	public static void captureCommonStones(ArrayList<String> al){
		String gems = "",uniqueGems = "";

		String gem = al.get(0);

		for(int i = 0 ; i < gem.length() ; i++){
			if(!uniqueGems.contains(gem.charAt(i)+"")){
				for(int j = 1 ; j < al.size() ; j++){
					if(al.get(j).contains(gem.charAt(i)+"")){
						gems = gems + gem.charAt(i);	
					}
				}
				if(gems.length() == (al.size() - 1)){
					uniqueGems = uniqueGems + gems.charAt(i);
				}

				gems = "";
			}
		}
		System.out.println(uniqueGems.length());
	}
}
