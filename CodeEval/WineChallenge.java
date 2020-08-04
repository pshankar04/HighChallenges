package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class WineChallenge {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				findWineName(line);
				System.out.println();
			}
			buffer.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void findWineName(String wine){
		String names = wine.split(" \\| ")[0];
		String letters = wine.split(" \\| ")[1];
		String original = "";
		boolean wineFound = false;
		int letterCount = 0;
		String[] wineArray = names.split(" ");
		if( names.length() > letters.length() && letters.length() >= 1 && wineArray.length > 0){
			for(int i = 0 ; i< wineArray.length ; i++){
				original = wineArray[i];
				for(int k = 0 ; k < letters.length() && original.length() >= letters.length(); k++){
					
					if( wineArray[i].contains(letters.charAt(k)+"")){
						wineArray[i] = replaceNow(new StringBuilder(wineArray[i]),letters.charAt(k));
						letterCount++;
					}
					if(letterCount == letters.length()){
						System.out.print(original+" ");
						wineFound = true;
						break;
					}
				}
				letterCount = 0;
			}
			if(!wineFound){
				System.out.print("False");
			}
		}
	}
	
	public static String replaceNow(StringBuilder wineItem , char ch){
		return new String(wineItem.deleteCharAt(wineItem.indexOf(ch+"")));
	}
}
