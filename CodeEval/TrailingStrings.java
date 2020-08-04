package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TrailingStrings {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			int count = 0;
			while ((line = buffer.readLine()) != null && (line.length() >= 3) && line.contains(",") && (count < 40)) {
				removeTrailingString(line);
				count++;
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void removeTrailingString(String sample){

		String[] items = sample.split(",");
		String[] wordSet1 = items[0].split(" ");
		String[] wordSet2 = items[1].split(" ");
		int diff = 0 , equalCount = 0;
		String result = "0";
		if(wordSet1.length > wordSet2.length){
			diff = wordSet1.length - wordSet2.length;
			for(int i = diff , j = 0 ; i < wordSet1.length && j < wordSet2.length ;i++,j++){
				if(wordSet1[i].equals(wordSet2[j])){
					equalCount++;	 
				}else{
					if((j != 0) && (wordSet1[i].equals(wordSet2[j-1]))){
						equalCount++;
					}
				}
				if((equalCount == wordSet2.length) || ((equalCount ==  1) && (i == (wordSet1.length) - 1))){
					result = "1";
					break;
				}else{
					continue;
				}
			}
		}else if(wordSet1.length == wordSet2.length){
			if(wordSet1[wordSet1.length - 1].equals(wordSet2[0])){
				result = "1";
			}else{
				result = "0";
			}
		}
		System.out.println(result);
	}
}



