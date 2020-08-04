package CodeEvalModerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

public class AlternateChange {

	public static int one =  1;
	public static int five = 5;
	public static int ten = 10;
	public static int twentyFive = 25;
	public static int fifty = 50;
	public static int alternateCount = 0;
	public static LinkedList<Integer> dividedList ;
	public static LinkedList<Integer> currencyList = new LinkedList<Integer>();
	static{
		currencyList.add(one);
		currencyList.add(five);
		currencyList.add(ten);
		currencyList.add(twentyFive);
		currencyList.add(fifty);
	}
	public static void main(String[] args) {

		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.length() > 0)) {
				findAlternates(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static LinkedList<Integer> computeDivisions(int amount){
		LinkedList<Integer> divList = new LinkedList<Integer>();
		while((amount / 2) != 0){
			amount = amount / 2;
			divList.add(amount);
		}
		return divList;
	}
	public static void findAlternates(String currency){
		int curr = Integer.parseInt(currency);
		dividedList = new LinkedList<Integer>();
		dividedList.add(curr);
		dividedList.addAll(computeDivisions(curr));
//		System.out.println(dividedList);
		int orgSum = curr;
		boolean isFirst = true;
		int sum = 0 ;
		for(Integer money: dividedList){
			for(Integer cent : currencyList){
				for(int i = 0 ; i < money && cent <= money ; i+=cent){
					sum = sum + cent;
					if(sum >= money){
						if((isFirst) && (sum == money)){
							alternateCount++;
							sum = 0;
							break;
						}else{
							if(sum == orgSum){
								alternateCount++;
								break;
							}else{
								continue;
							}
						}
					} 
				}
			}
			isFirst = false;
		}
		System.out.println(alternateCount);
		alternateCount = 0;
	}
}
