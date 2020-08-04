package Serials;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {

	public static void main(String[] args) {


		ArrayList<String> caseList = new ArrayList<String>();
		String line = "";
		File file = new File("/Users/puneethshankar/Desktop/Random.txt");
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				line = sc.nextLine();
				caseList.add(line);
			}
			sc.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		caseList.remove(0);
		String[] cases = new String[caseList.size()];
		cases = caseList.toArray(cases);
		findRatios(cases);
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
