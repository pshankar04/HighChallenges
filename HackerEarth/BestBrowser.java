package HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;



public class BestBrowser {

	public static void main(String[] args) {
		ArrayList<String> caseList = new ArrayList<String>();
		String line ;
		int count = -1;
		int totalTc = 0;
		Scanner in = new Scanner(System.in);
		line = in.nextLine() ;
		for( ;line != null || line != "" || line != "\n" || line.length() > 0; line = in.nextLine() ){
			if(line == "" || line.length() == 0 || line == "\n") break;
			if(count == -1){
				totalTc = Integer.parseInt(line);
				count++;
				continue;
			}
			if(count == totalTc) break;
			else {
				caseList.add(line);
				count++;
			}
		}
		//caseList.remove(0);
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
