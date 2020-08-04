package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;

public class BlackCard {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while (((line = buffer.readLine()) != null) && (line.trim().length() > 0) ) {
				line = line.trim();
				System.out.println(spotTheWinner(line));
			}
			buffer.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static String spotTheWinner(String input){
		LinkedList<String> playerOriginal = new LinkedList<String>();
		LinkedList<String> playerDuplicate = new LinkedList<String>();
		String[] items = input.split("\\|");
		String[] players = items[0].trim().split(" ");
		int target = Integer.parseInt(items[1].trim());
		playerOriginal.addAll(Arrays.asList(players));
		playerDuplicate.addAll(Arrays.asList(players));

		if(players.length < target){	

			playerDuplicate.addAll(Arrays.asList(players));

			while(true){ 
				playerDuplicate.remove(target-1);
				if(playerDuplicate.size() == (playerOriginal.size() + 1)){
					break;
				}
				target--;
			}

			return playerDuplicate.get(playerOriginal.size());
		}
		else if(players.length > target){

			while(playerOriginal.size() != (target-1)){
				playerOriginal.remove(target-1);
			}
			playerDuplicate.addAll(playerOriginal); 

			while(true){ 
				if(playerDuplicate.size() == (playerOriginal.size() + 1)){
					break;
				}else{
					playerDuplicate.remove(target - 1);
				}
			}
			return playerDuplicate.get(playerOriginal.size());
		}
		else if(players.length == target){
			playerDuplicate.addAll(Arrays.asList(players));
			boolean isFound = true;
			while(isFound){
				for(int i = 0 ; i < playerDuplicate.size() ; i++){
					
					if(playerDuplicate.size() == (playerOriginal.size() + 1)){
						return playerDuplicate.get(target - 1);
					}
					if( i == (target - 1)){
						playerDuplicate.remove(i);
						break;
					}
					//isFound = false;
				}
			}
		}
		return "";
	}
}


