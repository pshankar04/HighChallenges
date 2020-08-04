package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class Details {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			int count = 0;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0) && (line.contains(",")) && (count < 40)){
				countMoves(line);
				count++;
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void countMoves(String points){
		ArrayList<Integer> countList = new ArrayList<Integer>();
		int min = 0;
		boolean invalidFound = false;
		String[] positions = points.split(",");
		if(positions.length >= 2 && positions.length <= 10 ){
			for(int i = 0 ; i < positions.length ; i++){
				if(positions[i].length() >= 2 && positions[i].length() <= 10 && (isValid(positions[i]))){
					for(int k = 0 ; k < positions[i].length() ; k++){
						if(positions[i].charAt(k) == '.'){
							min++;
						} 
					}
					countList.add(min);
					min = 0;
				}else{
					invalidFound = true;
					break;
				}
			}
			if(!invalidFound){
				System.out.println(Collections.min(countList));
			}else{
				System.out.println(0);
			}
		}
	}

	public static boolean isValid(String word){
		if(word.contains(".")){
			String left = word.substring(0,word.indexOf('.'));
			String right = word.substring(word.indexOf('.'));
			if(!left.contains("Y") && (!right.contains("X"))){
				return true;
			}else{
				return false;
			}
		}else{	
			return ((word.lastIndexOf('X')) < (word.indexOf('Y'))) ? true : false;	
		}
	}
}
