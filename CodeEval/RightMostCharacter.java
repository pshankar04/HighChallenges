package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class RightMostCharacter {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				printIndex(line);
			}
			buffer.close();

		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public static void printIndex(String sample){
		boolean notFound = true;
		String searchChar = sample.split(",")[1];
		String searchString = sample.split(",")[0];

		if(searchChar !=null && searchString !=null && searchChar.length() > 0 && searchString.length() > 0){
			for(int i = searchString.length() - 1 ; i >= 0 ; i--){
				if(searchChar.equals(searchString.charAt(i)+"")){
					notFound = false;
					System.out.println(i);
					break;
				} 
			}
			if(notFound){
				System.out.println(-1);
			}
		}
	}

}
