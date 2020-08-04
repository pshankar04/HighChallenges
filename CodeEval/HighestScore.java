package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class HighestScore {
	public static LinkedList<Integer> elementList = null ;
	public static LinkedList<LinkedList<Integer>> scoresList ; 
	public static String maxString = "";
	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				findHighestScore(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void findHighestScore(String str){
		scoresList = new LinkedList<LinkedList<Integer>>();
		int l = 0,cycle = 0;
		String[] scoresSet = str.split(" \\| ");
		int cycleLength = ((str.split(" \\| "))[0].split(" ").length);
		 
		while(cycle < cycleLength){
			elementList = new LinkedList<Integer>();
			for(int i = 0 ; i < scoresSet.length ; i++){
				String[] scores = scoresSet[i].split(" ");
				for(int k = 0 ; k< scores.length ; k++){
					if(k == l){
						elementList.add(Integer.parseInt(scores[k]));
						break;
					}
				}
			}
			scoresList.add(elementList);
			l++;cycle++;
		}
		 
		System.out.println(printMaxScore(scoresList));
		maxString ="";
	}
	
	public static String printMaxScore(LinkedList<LinkedList<Integer>> scoreMax){
		
		Iterator<LinkedList<Integer>> itr = scoreMax.iterator();
		while(itr.hasNext()){
			maxString = maxString + Collections.max((LinkedList<Integer>)itr.next()) + " ";
		}
		return maxString;
	}
}
