package Serials;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class RepeatChars {

public static HashMap<String,Integer> countMap = new HashMap<String,Integer>();
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		if(str.length() > 0){
			int subStringLength  = lengthOfLongestSubstring(str);
			System.out.println("Length of Non-repeated Character String is :"+subStringLength);
		}

	}

	public static int lengthOfLongestSubstring(String sample){
 
		if(sample.length() > 0){
			for(int i = 0 ; i < sample.length() ; i++){
				for(int k = 0 ; k < sample.length() ; k++){
					if(i == k) continue;
					else if(sample.charAt(i) == sample.charAt(k)){					
						checkForRepetition(i,k,sample);
						break;
					} 
				}
				
			}
			return calculateLongestSubstring(countMap);
		}

		else{ 
			return 0;
		}

	}

	public static void checkForRepetition(int start,int end,String sample){
		String temp = "";
		int eIndex  = end;
		//System.out.println(" Start : "+start+" End : "+end+" sample :"+sample);
		for(int i = start ; i < (eIndex + 1) && (end < sample.length()) ; end++,i++){
			if(sample.charAt(i) == sample.charAt(end)){
				if((temp.length() != 0) && ((temp.charAt(temp.length() - 1) == sample.charAt(i)))) break;
				else{
				temp = temp + sample.charAt(i);
				}
			}else{
				continue;
			}
		}
		countMap.put(temp,temp.length());
		//System.out.println("Repeated Character : "+temp);
	}
	
	public static int calculateLongestSubstring(HashMap<String,Integer> count){
		int maxLength = 1;
		System.out.println("Repeated Elements : "+count);
		 
		 Set<Map.Entry<String, Integer>> setEntry = count.entrySet();
		 for(Map.Entry<String,Integer> entry : setEntry){
			 if(((Integer) entry.getValue()).intValue() > maxLength){
				 maxLength = (Integer)(entry.getValue());
			 }
		 }
			return maxLength;
		
	}

}
