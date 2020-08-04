package CodeEvalModerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;

public class AromaticNumbers {

	public static HashMap<String,Integer> romanMap = new HashMap<String,Integer>();
	static{
		romanMap.put("M", 1000);
		romanMap.put("D", 500);
		romanMap.put("C", 100);
		romanMap.put("L", 50);
		romanMap.put("X", 10);
		romanMap.put("V", 5);
		romanMap.put("I", 1);
	}
	
	public static void main(String[] args) {
		File file = new File(args[0]);
		try{	
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;

			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)) {
				findValue(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public static void findValue(String num){
		LinkedList<Integer> posInt = new LinkedList<Integer>();
		int value = 0 , previousBase = 0 , currentBase = 0 , removedNum = 0;
		
		for(int i = 0 , index = 0; i < num.length() ; i+=2 , index++){
			currentBase = (romanMap.get(num.charAt(i+1)+"")).intValue();
			value =  Integer.parseInt(num.charAt(i)+"") * currentBase ; 
			if((i != 0) && (currentBase > previousBase)){
				removedNum = posInt.remove(index-1);
				posInt.add(removedNum * -1);
				
			}
			previousBase = currentBase;
			posInt.add(value);
		}
		value = 0;
		 
		for(Integer i : posInt){
			value = value + i;
		}
		System.out.println(value);
	}
}
