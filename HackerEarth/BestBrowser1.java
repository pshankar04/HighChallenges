package HackerEarth;

import java.util.Scanner;
 

public class BestBrowser1 {

	public static void main(String[] args) {

		Scanner tcInput = new Scanner(System.in);
		Scanner sitesInput = new Scanner(System.in);
		int tc = tcInput.nextInt();
		String[] sites = new String[tc];
		for(int i = 0 ; i < tc ; i++){
			sites[i] = sitesInput.nextLine();
		}
		findRatios(sites);
		tcInput.close();
		sitesInput.close();
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
