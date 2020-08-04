package CodeEvalModerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;

public class StringRotation {

	public static HashSet<String> cycleSet;
	public static String search = "";
	public static void main(String[] args) {

		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.length() > 0)) {
				rotateString(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void rotateString(String word){
		
		search = word.split(",")[1];
		word = word.split(",")[0];
		cycleSet = new HashSet<String>();
		String temp1 = "" , temp2 = "" , temp = "";
		int count = 0 , start = 1 , begin = 0;
		
		while((count < word.length() - 1) && (start < word.length())){
			temp1 = word.substring(start,word.length());
			temp2 = word.substring(begin,start);
			temp = temp1 + temp2;
			cycleSet.add(temp);
			count++;
			start++;
		}
		
		if(cycleSet.contains(search)){
			System.out.println("True");	
		}else{
			System.out.println("False");
		}
	}
}
