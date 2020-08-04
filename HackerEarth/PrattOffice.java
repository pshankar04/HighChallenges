package HackerEarth;

import java.util.HashMap;
import java.util.HashSet;

public class PrattOffice {

	public static HashSet<String> testCasesSet = new HashSet<String>();
	public static String chars = "abcde";
	public static HashMap<String,Integer> charValueMap = new HashMap<String,Integer>();

	static{
		charValueMap.put("a",1);
		charValueMap.put("b",2);
		charValueMap.put("c",3);
		charValueMap.put("d",4);
		charValueMap.put("e",5);
	}

	public static void main(String[] args) {

		testCasesSet.addAll(generateTwenty());
		testCasesSet.addAll(generateFourty());
		 
		System.out.println(testCasesSet.size());
		for(String testCase : testCasesSet){
			System.out.println(testCase);
		}
	}

	public static HashSet<String> generateTwenty(){
		 
		HashSet<String> testSet1 = new HashSet<String>();
		String temp = "";
		int tempIndex = 0;
		for(int j = 0 ; j< 100 && testSet1.size() < 50 ; j++){
			for(int i = 0 ; i < 5 ; i++){
				tempIndex = 0 + (int)(Math.random() * 4);
				temp = temp + chars.charAt(tempIndex);
			}
			testSet1.add(temp);
			temp = "";
		}
		return testSet1;
	}

	public static HashSet<String> generateFourty(){
		HashSet<String> testSet2 = new HashSet<String>();
		String temp1 = chars + new String(new StringBuffer(chars).reverse());
		String temp2 = "";
		int tempIndex = 0;
		while(testSet2.size() < 50 ){
			for(int i = 0 ; i < temp1.length() ; i++){
				tempIndex = 0 + (int)(Math.random() * 5);
				if(tempIndex >= 0 && tempIndex <= temp1.length()){
					temp2 = temp2 + temp1.charAt(tempIndex);
				}
			}
			temp2 = temp2 + new String(new StringBuffer(temp2).reverse());
			testSet2.add(temp2);
			temp2 = "";
		}
		return testSet2;
	}




}
