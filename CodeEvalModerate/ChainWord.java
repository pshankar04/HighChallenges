package CodeEvalModerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class ChainWord {

	public static LinkedList<String> chainSet ;
	public static LinkedList<Integer> chainCountList;  
	public static LinkedList<LinkedList<String>> standardChainList;
	public static LinkedList<LinkedList<String>> renewedChainSet ;
	public static LinkedList<LinkedList<String>> finallyRenewedChainSet ;

	public static void main(String[] args) {
		chainCountList = new LinkedList<Integer>();
		finallyRenewedChainSet = new LinkedList<LinkedList<String>>();
		LinkedList<String> optimalList = new LinkedList<String>();
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			int count = 0;
			while ((line = buffer.readLine()) != null && (line.length() > 0) && (line.contains(",")) && count < 40) {
				findChains(line.toLowerCase());
				renewChains(standardChainList);

				for(LinkedList<String> chainList : renewedChainSet){
					optimalList = findOptimalChains(chainList);
					finallyRenewedChainSet.add(optimalList);
				}
 
				for(LinkedList<String> chain : finallyRenewedChainSet){
					chainCountList.add(chain.size());
				}
				if(Collections.max(chainCountList) == 1){
					System.out.println("None");
				}else{
					System.out.println(Collections.max(chainCountList));
				}
				count++;
				chainCountList = new LinkedList<Integer>();
				finallyRenewedChainSet = new LinkedList<LinkedList<String>>();
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void findChains(String series){
		String[] words = series.split(",");
		chainSet = new LinkedList<String>();
		standardChainList = new LinkedList<LinkedList<String>>();
		int i = 0, k = 0;
		char lastChar = 'a';
		while(i < words.length){
			chainSet.add(words[i]);
			lastChar = words[i].charAt(words[i].length()-1);
			while(k < 3){
				for(int j = 0 ; j < words.length ; j++){
					if(i == j){ 
						continue;
					}
					if(lastChar == words[j].charAt(0) && (!chainSet.contains(words[j]))){
						chainSet.add(words[j]);
						lastChar = words[j].charAt(words[j].length()-1);	
					}
				}
				k++;
			}
		
			standardChainList.add(chainSet);
			chainSet = new LinkedList<String>();
			i++;
			k=0;
		}
	}

	public static void renewChains(LinkedList<LinkedList<String>> stdList){
		renewedChainSet = new LinkedList<LinkedList<String>>();
		LinkedList<String> wordsList = new LinkedList<String>();
		LinkedList<String> tempList = new LinkedList<String>();
		String word = "";
		char last = '0';
		for(LinkedList<String> list : stdList){
			word = list.getFirst();
			last = word.charAt(word.length() - 1);
			wordsList = findRightMatch(word,last,stdList);
			if(((wordsList.size()) > (list.size() - 1)) && !(wordsList.contains(word))){
				tempList.add(word);
				tempList.addAll(wordsList);
			}else if((wordsList.size()) <= (list.size() - 1)){
				tempList.addAll(list);
			}
			if(tempList.size() > 0){
				renewedChainSet.add(tempList);
			}
			tempList = new LinkedList<String>();
		}
	}

	public static LinkedList<String> findRightMatch(String searchWord,char lastChar ,LinkedList<LinkedList<String>> sList){
		String firstWord = "";
		HashMap<Integer,LinkedList<String>> chainCountMap = new HashMap<Integer,LinkedList<String>>();
		for(LinkedList<String> list : sList){
			firstWord = list.getFirst();
			if(!firstWord.equals(searchWord) && (lastChar == firstWord.charAt(0)) && !(list.contains(searchWord))){
				chainCountMap.put(list.size(),list);
			}
		}
		if(chainCountMap.size() > 0){
			return findMaxList(chainCountMap);
		}else{
			return new LinkedList<String>();
		}
	}

	public static LinkedList<String> findMaxList(HashMap<Integer,LinkedList<String>> chainCountMap){
		return chainCountMap.get(new Integer(Collections.max(chainCountMap.keySet())));
	}

	public static LinkedList<String> findOptimalChains(LinkedList<String> rList){
		LinkedList<String> tempList = new LinkedList<String>();
		char last = '0';
		String firstWord = "";
		int indexCount = 1;
		HashMap<Integer,LinkedList<String>> optimalMap = new HashMap<Integer,LinkedList<String>>();
		for(String s : rList){
			last = s.charAt(s.length() - 1);
			for(LinkedList<String> list : renewedChainSet){
				firstWord = list.getFirst();
				if(!firstWord.equals(s) && (last == firstWord.charAt(0)) && !(list.contains(s)) && (list.size() > (rList.size() - indexCount))){
					for(int k = 0 ; k < getIndex(s,rList) ; k++){
						tempList.add(rList.get(k));
					}
					tempList.addAll(list);
					optimalMap.put(tempList.size(),tempList);
				}
				tempList = new LinkedList<String>();
			}
			indexCount++;
		}
		if(optimalMap.size() > 0){
			return findMaxList(optimalMap);
		}else{
			return rList;
		}
	}

	public static int getIndex(String word,LinkedList<String> list){

		for(int i = 0 ; i < list.size() ; i++){
			if((list.get(i)).equals(word)){
				return (i+1);
			}
		}
		return 0;
	}
}
