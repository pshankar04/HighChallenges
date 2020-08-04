package Serials;

import java.util.HashSet;

public class SetImpliments {

	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		//String sb = new String("Pun");
		hs.add("Pun");
		hs.add(new String("Pun"));
		 
		 
		 
		System.out.println(hs);
		System.out.println("Pun".equals(new String("Pun")));

	}

}
