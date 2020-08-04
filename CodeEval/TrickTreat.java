package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class TrickTreat {
	public static HashMap<String,Integer> candieMap = new HashMap<String,Integer>();

	static{
		candieMap.put("Vampire", 3);
		candieMap.put("Zombies", 4);
		candieMap.put("Witches", 5);
	}

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				shareTheTreat(line);
			}
			buffer.close();

		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public static void shareTheTreat(String input){
		 
		int totalCandies = 0;
		int costumeCount = 0;
		int sharePerChild = 0;
		int numberOfHouses = 1;
		String[] costumeValues = input.split(",");
		for(int i = 0 ; i < costumeValues.length ; i++){
			String costume = (costumeValues[i].trim()).split(": ")[0];
			int value = Integer.parseInt((costumeValues[i].trim()).split(": ")[1]);
			if(costume.equals("Vampires")){
				totalCandies = totalCandies + value * candieMap.get("Vampire");
				costumeCount = costumeCount + value;
			}else if(costume.equals("Zombies")){
				totalCandies = totalCandies + value * candieMap.get("Zombies");
				costumeCount = costumeCount + value;
			}else if(costume.equals("Witches")){
				totalCandies = totalCandies + value * candieMap.get("Witches");
				costumeCount = costumeCount + value;
			}else if(costume.equals("Houses")){
				numberOfHouses = value;
			}
		}
		 
		sharePerChild = (totalCandies * numberOfHouses ) / costumeCount;
		System.out.println(sharePerChild);
		 
	}

}
