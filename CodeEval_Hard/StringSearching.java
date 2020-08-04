package CodeEval_Hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
 

public class StringSearching {
	public static HashSet<String> subStrings;
	public static void main(String[] args) {
		
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			 
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				 String org = line.split(",")[0];
				 String search = line.split(",")[1];
				 subStrings = formSubstrings(org);
				  
				 if(subStrings.contains(search) || advancedSearch(search,org)){
					 System.out.println("true");
				 }else{
					 System.out.println("false");
				 }
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static boolean advancedSearch(String search,String orginal){
		 
		String firstHalf = "" , secondHalf = "";
		boolean found = false;
		if(search.contains("*") && search.indexOf("*") == 0){
			secondHalf = search.substring(1); 
			if(orginal.contains(secondHalf)){
				found = true;
			}
		}else if(search.contains("*") && search.contains("\\")){
			search = search.replace("\\","");
			if(subStrings.contains(search)){
				found = true;
			}
		}else if(search.contains("*") && search.indexOf("*") > 0){
			firstHalf = search.substring(0,search.indexOf("*"));
			secondHalf = search.substring(search.indexOf("*")+1);
			if(orginal.contains(secondHalf) && orginal.contains(firstHalf)){
				found = true;
			}
		}
		return found;
	}
	

	public static HashSet<String> formSubstrings(String str){
		HashSet<String> subStringSet = new HashSet<String>();
		String sub;
		if(str.length() > 0){
			for( int c = 0 ; c < str.length() ; c++ )
			{
				for( int i = 1 ; i <= str.length() - c ; i++ )
				{
					sub = str.substring(c, c+i);
					subStringSet.add(sub);
				}
				sub = "";
			}
			return subStringSet;
		}
		else
			return subStringSet;
	}
	
}
