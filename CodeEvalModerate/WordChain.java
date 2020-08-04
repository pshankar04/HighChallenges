package CodeEvalModerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class WordChain {

	public static LinkedHashSet<String> chainSet ;
	public static LinkedList<Integer> totalChainSet ;
	public static LinkedList<LinkedHashSet<String>> standardChainList;
	public static void main(String[] args) {

		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			int count = 0;
			while ((line = buffer.readLine()) != null && (line.length() > 0) && (line.contains(",")) && count < 40) {
				checkChaining(line.toLowerCase());
				count++;
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void checkChaining(String series){

		char lastChar = ' ';
		chainSet = new LinkedHashSet<String>();
		totalChainSet = new LinkedList<Integer>();
		standardChainList = new LinkedList<LinkedHashSet<String>>();
		String[] words = series.split(",");
		if(words[0].length() > 1){
			lastChar = words[0].charAt(words[0].length() - 1);
		}
		boolean notFound = true;
		int i = 0 , maxCount = 0 , k = 0;

		while(i < words.length){
			if(words[i].length() > 1){
				chainSet.add(words[i]);
				while(k < words.length){
					if(notFound){
						lastChar = words[i].charAt(words[i].length() - 1);
					}	
					for(int j = 0 ; j < words.length ; j++){
						if(i == j) continue;
						if((isStandardRepetition(lastChar,words[i])) && !chainSet.contains(words[j])){
							chainSet.addAll(returnStandardChain(lastChar,words[i]));
							lastChar = getLastCharacter(chainSet);
							notFound = false;
							k+=words.length;
							break;
						}
						else if((lastChar == words[j].charAt(0)) && !chainSet.contains(words[j])){
							chainSet.add(words[j]);
							lastChar = words[j].charAt(words[j].length() - 1);
							notFound = false;
							continue;
						}
					}
					k++;
				}
				//System.out.println(i+" : "+chainSet);
				standardChainList.add(chainSet);
				
				if(chainSet.size() == 1){
					totalChainSet.add(0);
				}else{
					totalChainSet.add(chainSet.size());
				}
				i++;
				chainSet = new LinkedHashSet<String>();
				notFound = true;
				k = 0;
			}
		}
		
		  
		maxCount = Collections.max(totalChainSet);
		if(maxCount == 0){
			System.out.println("None");
		}else{
			System.out.println(maxCount);
		}
	}
	
	public static char getLastCharacter(LinkedHashSet<String> wordsSet){
		char last = 'a';
		for(String s : wordsSet){
			last = s.charAt(s.length() -1);
		}
		return last;
	}

	public static boolean isStandardRepetition(char last,String word){
		for(LinkedHashSet<String> set : standardChainList){
			if(last == getFirstWord(set).charAt(0) && !set.contains(word)){
				return true;
			}
		}
		return false;
	}


	public static LinkedList<String> returnStandardChain(char lastChar,String word){
		for(LinkedHashSet<String> set : standardChainList){
			if(lastChar == getFirstWord(set).charAt(0) && (!set.contains(word))){
				return standardExtension(set);
			}
		}
		return new LinkedList<String>();
	}	

	public static LinkedList<String> standardExtension(LinkedHashSet<String> stdList){
		boolean listFound = false;
		LinkedList<String> tempList = new LinkedList<String>();
		LinkedList<String> tempCharList = new LinkedList<String>();
		for(String s : stdList){
			if((!tempCharList.contains(s.charAt(0)+"")) && (!listFound) ){
				tempList.add(s);
				tempCharList.add(s.charAt(0)+"");
				for(LinkedHashSet<String> set : standardChainList){
					if((s.charAt(s.length() - 1) == getFirstWord(set).charAt(0)) && (!tempList.contains(getFirstWord(set)))){
						tempList.addAll(set);
						listFound = true;
						break;
					}
				}
			}else{
				break;
			}
		}
		 
		return tempList;
	}

	public static String getFirstWord(LinkedHashSet<String> wordsSet){
		String firstWord = "";
		for(String s : wordsSet){
			firstWord = s;
			break;
		}
		return firstWord;
	}
	
	public static boolean isPresent(String word,LinkedList<String> tempoList){
		for(String st : tempoList){
			if(st.charAt(0) == word.charAt(0)){
				return false;
			}
		}
		return true;
	}
}
