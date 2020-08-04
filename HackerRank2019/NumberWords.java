package HackerRank;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class NumberWords {
	public static String convertedWord = "";
	public static LinkedHashMap<String,Integer> positionsMap;
	public static LinkedHashMap<Integer,String> unitsMap = new LinkedHashMap<Integer,String>();
	public static LinkedHashMap<Integer,String> tenTwentyMap = new LinkedHashMap<Integer,String>();
	public static LinkedHashMap<Integer,String> tensMap = new LinkedHashMap<Integer,String>();

	static{
		unitsMap.put(0,"Zero");
		unitsMap.put(1,"One");
		unitsMap.put(2,"Two");
		unitsMap.put(3,"Three");
		unitsMap.put(4,"Four");
		unitsMap.put(5,"Five");
		unitsMap.put(6,"Six");
		unitsMap.put(7,"Seven");
		unitsMap.put(8,"Eight");
		unitsMap.put(9,"Nine");

		tenTwentyMap.put(10,"Ten");
		tenTwentyMap.put(11,"Eleven");
		tenTwentyMap.put(12,"Twelve");
		tenTwentyMap.put(13,"Thirteen");
		tenTwentyMap.put(14,"Fourteen");
		tenTwentyMap.put(15,"Fifteen");
		tenTwentyMap.put(16,"Sixteen");
		tenTwentyMap.put(17,"Seventeen");
		tenTwentyMap.put(18,"Eighteen");
		tenTwentyMap.put(19,"Nineteen");

		tensMap.put(1,"Ten");
		tensMap.put(2,"Twenty");
		tensMap.put(3,"Thirty");
		tensMap.put(4,"Fourty");
		tensMap.put(5,"Fifty");
		tensMap.put(6,"Sixty");
		tensMap.put(7,"Seventy");
		tensMap.put(8,"Eighty");
		tensMap.put(9,"Ninety");


	}
	public static void main(String[] args) {
		String number = "";
		LinkedList<String> wordsList  = new LinkedList<String>();
		LinkedList<String> numList = new LinkedList<String>();
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		if(tc >= 1 || tc <= 10){
			for(int i = 0 ; i < tc ; i++){
				number = input.nextLine();
				if(number.length() < 13){
					numList.add(number);
				}
			}
		}
		for(String num : numList){
			num = new String(Long.parseLong(num)+"");
			System.out.println(num);
			if(num.length() == 4){
				convertedWord =  callTillThousand(num);
			}else if(num.length() == 5){
				convertedWord = callTillTenThousand(num);
			}else if(num.length() == 6){
				convertedWord = callTillHundredThousand(num);
			}else if(num.length() == 7){
				convertedWord = callTillMillion(num);
			}else if(num.length() == 8){
				convertedWord = callTillTenMillion(num);
			}else if(num.length() == 9){
				convertedWord = callTillHundredMillion(num);
			}else if(num.length() == 10){
				convertedWord = callTillBillion(num);
			}else if(num.length() == 11){
				convertedWord = callTillTenBillion(num);
			}else if(num.length() == 12){
				convertedWord = callTillHundredBillion(num);
			}else if(num.length() == 3 || num.length() == 2 || num.length() == 1){
				convertedWord = callTillHundreds(num);
			}
			wordsList.add(convertedWord);

		}
		for(int i = 0 ; i < wordsList.size() ; i++){
			removeExtraSpace(wordsList.get(i));
			System.out.println();
		}
		input.close();
	}

	public static String removeExtraSpace(String str){
		String[] words = str.split(" ");
		String temp = "";
		for(int  i = 0 ; i < words.length ; i++){
			System.out.print(words[i].trim()+" ");
		}
		return temp;
	}

	public static String callTillHundreds(String word){

		String finalWord = "";
		int digit1 = 0 , digit2 = 0 , digit3 = 0;;
		word = String.valueOf(Integer.parseInt(word));
		if(word.length() == 1){
			if(Integer.parseInt(word) == 0){
				finalWord = "Zero";
			}else{
				finalWord = unitsMap.get(Integer.parseInt(word));
			}
		}
		if(word.length() == 2){

			digit1 = Integer.parseInt(word.charAt(0)+"");
			if(digit1 == 1){
				finalWord = tenTwentyMap.get(Integer.parseInt(word));
			}else{
				digit2 = Integer.parseInt(word.charAt(1)+"");
				if(digit2 == 0){
					finalWord = tensMap.get(digit1);
				}else{
					finalWord = tensMap.get(digit1)+" "+unitsMap.get(digit2);
				}
			}
		}

		if(word.length() == 3){

			digit1 = Integer.parseInt(word.charAt(0)+"");
			digit2 = Integer.parseInt(word.charAt(1)+"");

			if(digit2 == 1){
				finalWord = tenTwentyMap.get(Integer.parseInt(word.substring(1)));
			}else{
				digit3 = Integer.parseInt(word.charAt(2)+"");
				if(digit3 == 0){
					if(digit2 == 0){
						finalWord = "";
					}else{
						finalWord = tensMap.get(digit2);
					}
				}else{
					if(digit2 == 0){
						finalWord = unitsMap.get(digit3);
					}else{
						finalWord = tensMap.get(digit2)+" "+unitsMap.get(digit3);
					}
				}
			}
			finalWord = (unitsMap.get(digit1)+" Hundred "+finalWord).trim();
		}
		return finalWord.trim();
	}

	public static String callTillThousand(String word){
		if(callTillHundreds(word.substring(1)).equals("Zero")){
			return unitsMap.get(Integer.parseInt(word.charAt(0)+""))+" Thousand";
		}else{
			if(Integer.parseInt(word.charAt(0)+"") == 0){
				return (callTillHundreds(word.substring(1))).trim();
			}else{
				return (unitsMap.get(Integer.parseInt(word.charAt(0)+""))+" Thousand "+ callTillHundreds(word.substring(1))).trim();
			}
		}
	}

	public static String callTillTenThousand(String word){

		if(callTillHundreds(word.substring(2)).equals("Zero")){
			return callTillHundreds(word.substring(0,2))+" Thousand";
		}else{
			return ((callTillHundreds(word.substring(0,2))).trim()+" Thousand "+ callTillHundreds(word.substring(2))).trim();
		}
	}

	public static String callTillHundredThousand(String word){

		if(callTillHundreds(word.substring(0,3)).equals("Zero")){
			return (callTillHundreds(word.substring(3))).trim();
		}else{
			if(callTillHundreds(word.substring(3)).equals("Zero")){
				return callTillHundreds(word.substring(0,3))+" Thousand ";
			}else{
				return (callTillHundreds(word.substring(0,3))+" Thousand "+ callTillHundreds(word.substring(3))).trim();
			}
		}
	}

	public static String callTillMillion(String word){

		if(callTillHundredThousand(word.substring(1)).equals("Zero")){
			if(Integer.parseInt(word.charAt(0)+"") == 0){
				return "Zero";
			}else{
				return unitsMap.get(Integer.parseInt(word.charAt(0)+""))+" Million ";
			}
		}else{
			if(callTillHundreds(word.substring(0,3)).equals("Zero")){
				return (callTillThousand(word.substring(3))).trim();
			}else{
				if(Integer.parseInt(word.charAt(0)+"") == 0){
					return (callTillHundredThousand(word.substring(1))).trim();
				}else{
					return (unitsMap.get(Integer.parseInt(word.charAt(0)+""))+" Million "+callTillHundredThousand(word.substring(1))).trim();
				}
			}
		}

	}
	public static String callTillTenMillion(String word){

		if((callTillMillion(word.substring(1))).equals("Zero")){
			return tensMap.get(Integer.parseInt(word.charAt(0)+""))+" Million ";
		}else{
			return (callTillHundreds(word.substring(0,2))+" Million "+callTillHundredThousand(word.substring(2))).trim();
		}

	}
	public static String callTillHundredMillion(String word){

		if((callTillHundreds(word.substring(0,3)).equals("Zero"))){
			return (callTillHundredThousand(word.substring(3))).trim();
		}else{
			if(callTillHundreds(word.substring(3)).equals("Zero")){
				return callTillHundreds(word.substring(0,3))+" Million ";
			}else{
				return (callTillHundreds(word.substring(0,3))+" Million "+ callTillHundredThousand(word.substring(3))).trim();
			}
		}
	}
	public static String callTillBillion(String word){


		if(callTillHundredMillion(word.substring(1)).equals("Zero")){
			if(Integer.parseInt(word.charAt(0)+"") == 0){
				return "";
			}else{
				return unitsMap.get(Integer.parseInt(word.charAt(0)+""))+" Billion ";
			}
		}else{
			if(callTillHundreds(word.substring(0,3)).equals("Zero")){
				return callTillMillion(word.substring(3));
			}else{
				if(Integer.parseInt(word.charAt(0)+"") == 0){
					return callTillHundredMillion(word.substring(1));
				}else{
					return unitsMap.get(Integer.parseInt(word.charAt(0)+""))+" Billion "+callTillHundredMillion(word.substring(1));
				}
			}
		}

	}
	public static String callTillTenBillion(String word){

		if((callTillBillion(word.substring(1))).equals("")){
			return tensMap.get(Integer.parseInt(word.charAt(0)+""))+" Billion ";
		}else{
			return callTillHundreds(word.substring(0,2))+" Billion "+callTillHundredMillion(word.substring(2));
		}
	}
	public static String callTillHundredBillion(String word){

		if((callTillHundreds(word.substring(0,3)).equals("Zero"))){
			return callTillHundreds(word.substring(3));
		}else{
			if(callTillHundreds(word.substring(3)).equals("Zero")){
				return callTillHundreds(word.substring(0,3))+" Billion ";
			}else{
				return callTillHundreds(word.substring(0,3))+" Billion "+ callTillHundredMillion(word.substring(3));
			}
		}
	}
}

