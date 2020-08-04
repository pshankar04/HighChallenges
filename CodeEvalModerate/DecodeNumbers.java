package CodeEvalModerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class DecodeNumbers {
	public static String readNumber = "";
	public static LinkedHashSet<String> subStringsSet;
	public static LinkedHashMap<String,Integer> charMap = new LinkedHashMap<String,Integer>();
	static{
		char[] chars = new char[26];
		chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

		for(int i = 1 ; i <= chars.length ;i++){
			charMap.put(chars[i-1]+"", i);
		}
	}
	public static void main(String[] args) {
		subStringsSet = new LinkedHashSet<String>();
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			int count = 0;
			while ((line = buffer.readLine()) != null && (line.length() > 0) && (count < 40)) {
				readNumber = line;
				subStringsSet = formSubstrings(line);
				convertNow(subStringsSet);
				count++;
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static LinkedHashSet<String> formSubstrings(String str){
		LinkedHashSet<String> subStringSet = new LinkedHashSet<String>();
		String sub;
		if(str.length() > 0){
			for( int c = 0 ; c < str.length() ; c++ )
			{
				for( int i = 1 ; i <= str.length() - c ; i++ )
				{
					sub = str.substring(c, c+i);
					if(sub.length() <= 2 && Integer.parseInt(sub) <= 26){
						subStringSet.add(sub);
					}
				}
				sub = "";
			}
			return subStringSet;
		}
		else
			return subStringSet;
	}

	public static void convertNow(LinkedHashSet<String> subSet){
		LinkedList<Integer> itemList = new LinkedList<Integer>();
		itemList = saveToList(subSet);
		Collections.sort(itemList);
		System.out.println("SORTED :"+itemList);
		createMatchings(itemList);
	}

	public static LinkedList<Integer> saveToList(LinkedHashSet<String> subSet){
		LinkedList<Integer> numList = new LinkedList<Integer>();
		for(String s : subSet){
			numList.add(Integer.parseInt(s));
		}
		return numList;
	}

	public static void createMatchings(LinkedList<Integer> numberList){
		ArrayList<String> matchList = new ArrayList<String>();
		String[] nums = new String[numberList.size()];
		 for(int i = 0 ; i < numberList.size() ; i++){
			 nums[i] = String.valueOf(numberList.get(i));
		 }
		  
		 for(int i = 0 ; i < nums.length ; i++){
			 for(int j = 0 ; j < nums.length ; j++){
				 if(i == j) continue;
				 if(((nums[i]+nums[j]).length() == readNumber.length()) && isUnique(nums[i]+nums[j]) && isAscending(nums[i]+nums[j])){
					 matchList.add(nums[i]+" "+nums[j]);
				 }
			 }
		 }
		 System.out.println(matchList);
		 System.out.println(matchList.size()+1);
	}	
		
	public static boolean isUnique(String word){
		HashSet<String> hs = new HashSet<String>();
		  for(int i = 0 ; i < word.length() ;i++){
			  hs.add(word.charAt(i)+"");
		  }
		  if(hs.size() == word.length()){
			  return true;
		  }else{
			  return false;
		  }
	}

	
	public static boolean isAscending(String word){
		String orgWord = "";
		ArrayList<String> nList = new ArrayList<String>();
		  for(int i = 0 ; i < word.length() ;i++){
			  nList.add(word.charAt(i)+"");
		  }
		  Collections.sort(nList);
		  
		  for(String s : nList){
			  orgWord = orgWord + s;
		  }
		  
		  if(orgWord.equals(word)){
			  return true;
		  }else{
			  return false;
		  }
	}
}


