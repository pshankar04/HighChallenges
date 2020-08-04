package CodeEvalModerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

public class ReverseGroups {
	public static LinkedList<String> numList;
	public static LinkedList<String> newNumList;
	public static void main(String[] args) {

		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.length() > 0) && (line.contains(";"))) {
				reverseNow(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void reverseNow(String str){
		newNumList = new LinkedList<String>();
		numList = new LinkedList<String>();
		int count = Integer.parseInt(str.split(";")[1]);
		String[] num = (str.split(";")[0]).split(",");
		numList = createWord(num);
		int totalSwap = (numList.size() / count) ;
		int swapCount = 0 ;
		int eCount = count;
		while(swapCount < totalSwap){
			int i = 0;
			while(i < count){
				newNumList.add(numList.get(eCount - 1));
				numList.remove(eCount - 1);
				i++;
				eCount--;
			}
			swapCount++;
			eCount = count;
		}
		newNumList.addAll(numList);
		System.out.println(addCommas(newNumList));
	}

	public static LinkedList<String> createWord(String[] word){
		LinkedList<String> numsList = new LinkedList<String>();

		for(int i = 0 ; i < word.length ; i++){
			numsList.add(word[i]);
		}
		return numsList;
	}

	public static String addCommas(LinkedList<String> nList){
		String temp = "";
		for(int i = 0 ; i < nList.size() ; i++){
			if(i == nList.size() - 1){
				temp = temp + nList.get(i);
			}else{
				temp = temp + nList.get(i) + "," ;
			}
		}
		return temp;
	}
}
