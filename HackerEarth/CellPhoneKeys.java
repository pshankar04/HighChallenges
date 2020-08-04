package HackerEarth;

import java.util.HashMap;
import java.util.Scanner;

public class CellPhoneKeys {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String keyInput = input.nextLine();
		System.out.println(reverse_t9(keyInput));
		input.close();
	}

	public static String reverse_t9(String text){
		HashMap<String,String> numMap = new HashMap<String,String>();
		numMap.put("0", " ");
		numMap.put("2","a");
		numMap.put("22","b");
		numMap.put("222","c");
		numMap.put("3","d");
		numMap.put("33","e");
		numMap.put("333","f");
		numMap.put("4","g");
		numMap.put("44","h");
		numMap.put("444","i");
		numMap.put("5","j");
		numMap.put("55","k");
		numMap.put("555","l");
		numMap.put("6","m");
		numMap.put("66","n");
		numMap.put("666","o");
		numMap.put("7","p");
		numMap.put("77","q");
		numMap.put("777","r");
		numMap.put("7777","s");
		numMap.put("8","t");
		numMap.put("88","u");
		numMap.put("888","v");
		numMap.put("9","w");
		numMap.put("99","x");
		numMap.put("999","y");
		numMap.put("9999","z");
		//numMap.put(" ","");
		String temp = "" , finalStr = "";
		char ch = text.charAt(0);
		int index = 1;

		if(text.contains(" ")){
			for(int i = 0 ; i < text.split(" ").length ; i++){
				temp = temp + numMap.get(text.split(" ")[i]);
			}
			return temp;
		}else{
			temp = ch+"";
			while(index < text.length()){
				for(int i = index ; i < text.length() ; i++,index++){
					if(ch == text.charAt(index)){
						temp = temp + text.charAt(index);
					}else{
						finalStr = finalStr + numMap.get(temp);
						ch = text.charAt(index);
						if(ch == ' '){
							index++;
							ch = text.charAt(index);
						}
						temp = ch+"";
					}	
				}	 
			}
		}
		return finalStr+numMap.get(temp);
	}
}
