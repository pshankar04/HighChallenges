package HackerEarth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ExpandIt {

	public static String finalString;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String text = input.nextLine();
		int totalInputs = Integer.parseInt(input.nextLine());
		if(totalInputs >= 0 && text.length() >= 2){
			int[] nums = new int[totalInputs];
			nums = saveNumbers(nums,text);
			getCharacterAyIndex(nums,text);
		}
		input.close();
	}

	public static int[] saveNumbers(int[] nums,String str){

		int num ;
		for(int i = 0 ; i < nums.length ; i++){
			num = new Scanner(System.in).nextInt();
			if(num >=1){
				nums[i] = num;
			}else{
				nums[i] = 1;
			}
		}
		return nums;
	}
	public static void getCharacterAyIndex(int[] numbers,String word){
		finalString = new String();
		String number = "";
		ArrayList<String> charPositionList = new ArrayList<String>();
		ArrayList<String> charList = new ArrayList<String>();
		ArrayList<String> numberList = new ArrayList<String>();
		for(int i = 0 ; i <= word.length() ;){
			if(i == word.length()){
				numberList.add(number);
				break;
			}
			if(Character.isAlphabetic(word.charAt(i))){
				charList.add(word.charAt(i)+"");
				i++;
				continue;
			}else if(Character.isDigit(word.charAt(i))){
				while(((i) < word.length()) && (Character.isDigit(word.charAt(i)))){
					number = number + word.charAt(i);
					i++;
				}
				if(i != word.length()){
					numberList.add(number);
					number = "";
				}
			}
		}
		System.out.println(charList);
		System.out.println(numberList);

		Collections.sort(charPositionList);
		finalString = formString(charList,numberList);
		System.out.println("FINAL :"+finalString);
		printCorrespondingChars(finalString,numbers);
	}

	public static String formString(ArrayList<String> charsList,ArrayList<String> numList){
		String temp = "";
		for(int i = 0 ; i < charsList.size() ; i++ ){
			for(int j = 0 ; j < Integer.parseInt(numList.get(i)) ; j++){
				temp = temp + charsList.get(i);
			}
		}
		return temp;
	}

	public static void printCorrespondingChars(String finalWord , int[] numArray){

		for(int i = 0 ; i < numArray.length ; i++){
			if(numArray[i] >= 1 && numArray[i] < finalWord.length()){
				System.out.println(finalWord.charAt(numArray[i] - 1));
			}else{
				System.out.println("-1");
			}
		}
	}

}