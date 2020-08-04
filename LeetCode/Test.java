package Serials;


import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		ArrayList<String> caseList = new ArrayList<String>();
		String line ;
		int count ;
		int totalTc ;
		Scanner in = new Scanner(System.in);
		totalTc = Integer.parseInt(in.nextLine()) ;
		line  = in.nextLine();
		
		for( count = 0 ;count < totalTc; line = in.nextLine() ,count++){	 
		caseList.add(line);
		}
		String[] cases = new String[caseList.size()];
		cases = caseList.toArray(cases);
		findRatios(cases);	

		in.close();
	}

	public static void findRatios(String[] portals){
		String bestPortalName = "";
		for(int k = 0 ; k < portals.length ; k++){
			bestPortalName = portals[k].substring(portals[k].indexOf('.')+1, portals[k].lastIndexOf('.'));
			bestPortalName = replaceNow(bestPortalName);
			returnRatio(portals[k],bestPortalName);
		}
	}

	public static String replaceNow(String test){

		return test.replace("a","").replace("e","").replace("i","").replace("o","").replace("u","");
	}

	public static void returnRatio(String original,String modified){
		System.out.println((modified.length() + 4) + "/" + original.length());
	}

}
