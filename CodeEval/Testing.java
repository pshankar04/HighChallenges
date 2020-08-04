package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Testing {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				testTheString(line);
			}
			buffer.close();

		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public static void testTheString(String input){
		int bugCount = 0;
		String result = "";
		String[] testInput = input.split(" \\| ");
		if(testInput[0].length() == testInput[1].length()){
			for(int i = 0 ; i < testInput[0].length() ; i++){
				if(testInput[0].charAt(i) != testInput[1].charAt(i)){
					bugCount++;
				}
			}
			if(bugCount != 0 && bugCount <= 2){
				result = "Low";
			}else if(bugCount > 2 && bugCount <= 4){
				result = "Medium";
			}else if(bugCount > 4 && bugCount <= 6){
				result = "High";
			}else if(bugCount > 6){
				result = "Critical";
			}else if(bugCount == 0){
				result = "Done";
			}
			System.out.println(result);
		}
		
	}

}
