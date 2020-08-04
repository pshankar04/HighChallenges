package TestRun;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class JohnnysYouth {
	public static LinkedList<Integer> sortList = new LinkedList<Integer>();
	public static int beautyOfString = 0;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int totalStrings = Integer.parseInt(input.nextLine());
		String str = "";
		for(int i = 26 ; i >= 0 ;i--){
			sortList.add(i);
		}
		for(int k = 0 ; k < totalStrings ; k++){
			str =  input.nextLine();
			System.out.println(computeBeautyNess(str));
			beautyOfString = 0;
		}
	}
	
	public static int computeBeautyNess(String str){
		HashMap<String,Integer> countMap = new HashMap<String,Integer>();
		LinkedList<Integer> countSet = new LinkedList<Integer>();
		char[] inputChars = str.toCharArray();
		int k = 0;
		for(int i = 0 ; i < inputChars.length ; i++){
			if(countMap.containsKey(inputChars[i]+"")){
				countMap.put(inputChars[i]+"",countMap.get(inputChars[i]+"") + 1);
			}else{
				countMap.put(inputChars[i]+"",1);
			}
		}
		Iterator it = countMap.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        countSet.add((Integer)pair.getValue());
	    }
	    
	    
	    for(int i = countSet.size() - 1 ; i >= 0 ; i--){
	    	beautyOfString = beautyOfString + sortList.get(k) * i;
	    	System.out.println("Sort NUm"+sortList.get(k)+ ": i "+ i);
	    	k++;
	    }
		
		return beautyOfString;
	}

}
