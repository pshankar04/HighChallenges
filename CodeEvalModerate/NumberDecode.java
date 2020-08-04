package CodeEvalModerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashSet;

public class NumberDecode {

	public static String readNumber = "";
	public static LinkedHashSet<String> matchSet; 

	public static void main(String[] args) {

		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			int count = 0;
			while ((line = buffer.readLine()) != null && (line.length() > 0) && (count < 40)) {
				readNumber = line;
				decodeNow(line); 
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static String fillSpace(int position,String word){
		String temp = "";
		temp = word.substring(0,position) +" "+word.substring(position);
		return temp;
	}

	public static void decodeNow(String series){
		matchSet = new LinkedHashSet<String>();
		int spacePosition = 1;
		String temp = "";
		while(spacePosition < series.length()){

			temp = fillSpace(spacePosition,series);
			temp = checkValidity(temp.split(" ")[0],temp.split(" ")[1]);
			matchSet.add(temp);
			spacePosition++;
		}
		 System.out.println(matchSet.isEmpty());
		 System.out.println(matchSet.size());
	}

	public static String checkValidity(String part1,String part2){


		String param = "";
		String matchString = "";
		String sample = "";
		int initial = 1;
		int numPart1 = Integer.parseInt(part1);
		int numPart2 = Integer.parseInt(part2);

		while(numPart1 > 26 || numPart2 > 26){
			if(numPart1 <= 26){
				matchString = matchString + numPart1 + " ";
			}else if(numPart1 > 26){
				param = String.valueOf(numPart1);
			}

			if(numPart2 > 26){
				param = String.valueOf(numPart2);
			}else if(numPart2 <= 26){
				matchString = matchString +" "+ numPart2;
			}

			sample = fillSpace(initial,param);
			numPart1 = Integer.parseInt(sample.split(" ")[0]);
			numPart2 = Integer.parseInt(sample.split(" ")[1]);
		}
		if(Integer.parseInt(part1) > 26){
			matchString = numPart1 + " " +numPart2 + matchString;
		}else if(Integer.parseInt(part2) > 26){
			matchString = matchString + numPart1 + " " +numPart2;
		}
		return matchString;
	}

}
