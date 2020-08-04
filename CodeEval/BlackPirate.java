package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;

public class BlackPirate {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while (((line = buffer.readLine()) != null) && (line.trim().length() > 0) ) {
				line = line.trim();
				findWinner(line);
			}
			buffer.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public static void findWinner(String elements){
		LinkedList<String> playerOriginal = new LinkedList<String>();
		LinkedList<String> playerDuplicate = new LinkedList<String>();
		String[] players = ((elements.trim()).split(" \\| ")[0]).split(" ");
		int target = Integer.parseInt((elements.trim()).split(" \\| ")[1]);
		if(players.length >= 3 && players.length <= 10 && target >= 3 && target <= 15){
			playerOriginal.addAll(Arrays.asList(players));
			playerDuplicate.addAll(Arrays.asList(players));

			if(players.length < target){
				while(playerDuplicate.size() < target){
					playerDuplicate.addAll(Arrays.asList(players));
				}

				while(true){ 

					playerDuplicate.remove(target-1);
					if(playerDuplicate.size() == (playerOriginal.size() + 1)){
						break;
					}
					target--;
				}
				System.out.println(playerDuplicate.get(playerOriginal.size()));
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
				System.out.println(playerDuplicate.get(playerOriginal.size()));
			}

			else if(players.length == target){
				while(playerOriginal.size() != (target-1)){
					playerOriginal.remove(target-1);
				}
				playerDuplicate.addAll(playerOriginal); 

				while(true){ 
					if(playerDuplicate.size() == (playerOriginal.size() + 1)){
						break;
					}else{
						playerDuplicate.remove(target - 1);
						target--;
					}
				}
				System.out.println(playerDuplicate.get(playerOriginal.size() - 1));
			}
		}
	}
}
