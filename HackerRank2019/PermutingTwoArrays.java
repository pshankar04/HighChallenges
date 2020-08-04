package HackerRank2019;

import java.util.TreeMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class PermutingTwoArrays {

	public static void main(String[] args) {
		int[] firstArray;
		int totalArrayLength = 0;
		int[] secondArray;
		int relationValue = 0;
		String inputLine = "";
		String arrayElementsLine = "";
		Scanner in = new Scanner(System.in);
		int numberOfQueries = Integer.parseInt(in.nextLine());
		for(int i = 0 ; i < numberOfQueries ; i++){
			inputLine = in.nextLine();
			totalArrayLength = Integer.parseInt(inputLine.split(" ")[0]);
			relationValue = Integer.parseInt(inputLine.split(" ")[1]);
			firstArray = new int[totalArrayLength];
			secondArray = new int[totalArrayLength];
			arrayElementsLine = in.nextLine();
			for(int j = 0 ; j < totalArrayLength ; j++){
				firstArray[j] = Integer.parseInt(arrayElementsLine.split(" ")[j]);
			}
			arrayElementsLine = in.nextLine();
			for(int j = 0 ; j < totalArrayLength ; j++){
				secondArray[j] = Integer.parseInt(arrayElementsLine.split(" ")[j]);
			}
			System.out.println(twoArrays(relationValue,firstArray,secondArray));
		}
		in.close();
	}

	public static String twoArrays(int k, int[] A, int[] B) {
		int key = 0 , value = 0 , diff = 0;
		String numberExists = "NO";
		TreeMap<Integer,Integer> numberMapForFirstArray = new TreeMap<Integer,Integer>();
		TreeMap<Integer,Integer> numberMapForSecondArray = new TreeMap<Integer,Integer>();

		for(int i = 0 ; i < A.length ; i++){
			if(numberMapForFirstArray.containsKey(A[i])){
				numberMapForFirstArray.put(A[i],numberMapForFirstArray.get(A[i]) + 1);
			}else{
				numberMapForFirstArray.put(A[i],1);
			}
		}

		for(int i = 0 ; i < B.length ; i++){
			if(numberMapForSecondArray.containsKey(B[i])){
				numberMapForSecondArray.put(B[i],numberMapForSecondArray.get(B[i]) + 1);
			}else{
				numberMapForSecondArray.put(B[i],1);
			}
		}

		System.out.println("First Map Elements: "+numberMapForFirstArray);
		System.out.println("Second Map Elements: "+numberMapForSecondArray);

		Iterator it1 = numberMapForFirstArray.entrySet().iterator();

		while (it1.hasNext()) {
			Map.Entry pair = (Map.Entry)it1.next();
			key = (Integer) pair.getKey();
			value = (Integer) pair.getValue();
			diff = k - key;
			if(isNumberExistsInSecondArray(diff,value,numberMapForSecondArray)){
				numberExists = "YES";
			}else{
				numberExists = "NO";
				break;
			}

		}

		return numberExists;
	}

	public static boolean isNumberExistsInSecondArray(int diffNum, int actualCount, TreeMap<Integer,Integer> numMap){
		System.out.println("HERE: "+diffNum+"  "+actualCount);
		boolean exists = false;
		int currentCount = 0;
		Iterator it2 = numMap.entrySet().iterator();
		int k = 0 , key = 0, value = 0;
		while (it2.hasNext()) {
			Map.Entry pair = (Map.Entry)it2.next();
			key = (Integer) pair.getKey();
			value = (Integer) pair.getValue();
			if(key >= diffNum){
				if(value >= actualCount || currentCount >= actualCount){
					exists = true;
					break;
				}else{
					currentCount = currentCount + value;
				}
			}else{
				continue;
			}
		}
		if(currentCount >= actualCount){
			exists = true;
		}
		System.out.println("Exists :"+exists);
		return exists;
	}


}
