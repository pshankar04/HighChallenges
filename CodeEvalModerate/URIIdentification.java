package CodeEvalModerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class URIIdentification {

	public static ArrayList<String> siteName1 ; 
	public static ArrayList<String> siteName2 ; 

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			int count = 0;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0) && count < 40){
				//System.out.println(line);
				verifyMatching(line);
				count++;
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static String convertToAscii(String words){

		String asciiString = "";
		String hex = "";
		int asciiValue = 0;
		for(int i = 0 ; i < words.length() ; i++){
			if(words.charAt(i) == '%' && (Character.isDigit((words.charAt(i+1))))){
				hex = (words.substring(i+1,i+3)).toLowerCase();
				asciiValue = Integer.parseInt(hex,16);
				asciiString = asciiString + ((char)asciiValue) ;
				i = i+2;
				continue;
			}
			asciiString = asciiString + words.charAt(i)+"" ;
		}
		return asciiString;
	}

	public static void verifyMatching(String words){

		String[] uris = words.split(";");
		siteName2 = new ArrayList<String>();
		siteName1 = new ArrayList<String>();
		uris[0] = convertToAscii(uris[0]);
		uris[1] = convertToAscii(uris[1]);

		String protocol1 = uris[0].substring(0,uris[0].indexOf('/')+2);
		String protocol2 = uris[1].substring(0,uris[1].indexOf('/')+2);

		siteName1.add(protocol1.toLowerCase().trim()); siteName2.add(protocol2.toLowerCase().trim());

		uris[0] = uris[0].substring(uris[0].indexOf('/')+2,uris[0].length());
		uris[1] = uris[1].substring(uris[1].indexOf('/')+2,uris[1].length());
		for(int i = 0 ; i < uris.length ; i++){
			if(i == 0){
				populateSiteNameLists(uris[0],siteName1);
			}else{
				populateSiteNameLists(uris[1],siteName2);	 
			}
		}


		if(checkEquality(siteName1,siteName2)){
			System.out.println("True");
		}else{
			System.out.println("False");
		}
	}

	public static void populateSiteNameLists(String site,ArrayList<String> siteList){

		String sitename = "";
		while(site.length() > 0 && site.contains("/")){
			for(int i = 0 ; i < site.length() ; i++){
				if(site.charAt(i) == '/'){
					sitename = site.substring(0,i);
					if(sitename.contains(".")){
						if(!sitename.contains(":")){
							sitename =sitename + ":80";
						}
						siteList.add(sitename.toLowerCase());
						site = site.substring(i + 1);
						break;
					}else{
						siteList.add(sitename);
						site = site.substring(i + 1);
						break;
					}
				}
			}
		}
		siteList.add(site.trim());
		//System.out.println(siteList);

	}

	public static boolean checkEquality(ArrayList<String> site1,ArrayList<String> site2){

		boolean areEqual = false;
		if(site1.size() == site2.size()){
			for(int i = 0 ; i < site1.size() ; i++){
				if(site1.get(i).equals(site2.get(i))){
					areEqual = true;
				}else{
					areEqual = false;
					break;
				}
			}
		}
		return areEqual;
	}


}
