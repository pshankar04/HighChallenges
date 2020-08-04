package HackerRank;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class NameScores {
	public static LinkedList<String> namesList;
	public static LinkedList<Integer> countList = new LinkedList<Integer>();
	public static HashMap<String,Integer> charMap = new HashMap<String,Integer>();
	
	static{
		charMap.put("A",1);charMap.put("B",2);charMap.put("C",3);charMap.put("D",4);charMap.put("E",5);
		charMap.put("F",6);charMap.put("G",7);charMap.put("H",8);charMap.put("I",9);charMap.put("J",10);
		charMap.put("K",11);charMap.put("L",12);charMap.put("M",13);charMap.put("N",14);charMap.put("O",15);
		charMap.put("P",16);charMap.put("Q",17);charMap.put("R",18);charMap.put("S",19);charMap.put("T",20);
		charMap.put("U",21);charMap.put("V",22);charMap.put("W",23);charMap.put("X",24);charMap.put("Y",25);
		charMap.put("Z",26);
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int totalNames = Integer.parseInt(input.nextLine());
		namesList = new LinkedList<String>();
		for(int i = 0 ; i < totalNames ; i++){
			namesList.add(input.nextLine());
		}
		int queries = Integer.parseInt(input.nextLine());
		Collections.sort(namesList);
		countList = new LinkedList<Integer>();
		for(int j = 0 ; j < queries ; j++){
			countList.add(findStringValue(input.nextLine()));
		}
		for(Integer i : countList){
			System.out.println(i);
		}
		input.close();

	}

	public static int findStringValue(String name){
		
		int sum = 0 , index = 0;
		for(int i = 0 ; i < name.length() ; i++){
			sum = sum + charMap.get(String.valueOf(name.charAt(i)));
		}
		 
		for(int i = 0 ; i < namesList.size() ; i++){
			if(namesList.get(i).equals(name)){
				index = i;
				break;
			}
		}
		 
		return (index + 1) * sum;
	}
}
