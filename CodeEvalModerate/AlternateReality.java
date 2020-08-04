package CodeEvalModerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

public class AlternateReality {

	public static int one =  1;
	public static int five = 5;
	public static int ten = 10;
	public static int twentyFive = 25;
	public static int fifty = 50;
	public static int alternateCount = 0;
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


	public static void findAlternates(String currency){
		int curr = Integer.parseInt(currency);
		 
		if(curr < five){
			System.out.println(1);
		}else if(curr >= five && curr < ten){
			System.out.println(2);
		}else if(curr >= ten){
			analyseCurrency(curr);
		} 
		
	}

	public static void analyseCurrency(int amount){
		int OrgAmount = amount;
		int alternateCount = 0 , loopCount = 0 , value = 0 , sum = 0;
		LinkedList<String> changeList = new LinkedList<String>();
		LinkedList<String> duplicateList = new LinkedList<String>();

		for(Integer cent : currencyList){
			if((amount/cent) != 0){
				changeList.add((amount/cent)+","+(cent));
			}
		}
		while((amount/2) != 0){
			amount = amount / 2;
			for(Integer cent : currencyList){
				if((amount/cent) != 0){
					changeList.add((amount/cent)+","+(cent));
				}
			}
		}
		
		for(String s : changeList){
			loopCount = Integer.parseInt(s.split(",")[0]);
			value = Integer.parseInt(s.split(",")[1]);
			
			for(int k = 0 ; k < loopCount ; k++){
				sum = sum + value;
			}
			 
			if(sum == OrgAmount){
				alternateCount++;
			}
			sum = 0;
		}
		
		for(int i = 0 ; i < changeList.size() ; i++){
			for(int k = 0 ; k < changeList.size() ; k++){
				if(i == k) continue;
				if(checkDuplicates(changeList.get(i),changeList.get(k),duplicateList)) continue;
				if(OrgAmount == calculateSum(changeList.get(i),changeList.get(k))){
					alternateCount++;
					duplicateList.add(changeList.get(i));
					duplicateList.add(changeList.get(k));
				}
			}
		}
		System.out.println(alternateCount);
	}
	
	public static boolean checkDuplicates(String st1 , String st2, LinkedList<String> duplicates){
		
		return ((duplicates.contains(st1) && duplicates.contains(st2))) ? true : false;
	}
	
	public static int calculateSum(String op1, String op2){
		int loopCount1 = 0 , value1 = 0 , loopCount2 = 0 , value2 = 0 , sum1 = 0 , sum2 = 0;
		
		loopCount1 = Integer.parseInt(op1.split(",")[0]);
		value1 = Integer.parseInt(op1.split(",")[1]);
		loopCount2 = Integer.parseInt(op2.split(",")[0]);
		value2 = Integer.parseInt(op2.split(",")[1]);
		
		for(int k = 0 ; k < loopCount1 ; k++){
			sum1 = sum1 + value1;
		}
		for(int l = 0 ; l < loopCount2 ; l++){
			sum2 = sum2 + value2;
		}
		
		return (sum1 + sum2) ;
	}
}
