package Serials;

import java.util.HashMap;
import java.util.Scanner;

public class RepeatedCharacter {

	public static int index;
	public static void main(String[] args) {
		 
		Scanner input = new Scanner(System.in);
		String element = input.nextLine();
		if(returnNonrepeatedCharacter(element) != "No Such Character")
		System.out.println("Element "+returnNonrepeatedCharacter(element)+" is found at position "+(index+1));
		else
			returnNonrepeatedCharacter(element);

	}
	
	public static String returnNonrepeatedCharacter(String str){
		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
		Character c ;
		Integer intr;
		
		for(int  i = 0 ; i < str.length() ; i++){
			c = new Character(str.charAt(i));
			intr = hm.get(c);
			 
			if(intr == null){
				hm.put(new Character(str.charAt(i)),1);
			}else{
				hm.put(new Character(str.charAt(i)), new Integer(intr.intValue() + 1));
			}
		}
		System.out.println(hm);
		for(int i = 0 ; i < str.length() ; i++){
			if(hm.get(new Character(str.charAt(i))) == 1){
				index = i;
				return new Character(str.charAt(i)).toString();
			} 
		}
		return "No Such Character";
		
		
	}

}
