package Serials;
import java.util.*;

public class StringCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		int rCount = 0;
		int norepeats = 0;
		System.out.println(" Please enter the input string :" );
        Scanner in = new Scanner (System.in);
        String name = in.nextLine();
		char[] nameArray = name.toCharArray();
		LinkedHashMap<String,Integer> charCount = new LinkedHashMap<String,Integer>();
		for(int i=0 ; i<nameArray.length ; i++){
			
			if(charCount.size() > 0 && charCount.containsKey((nameArray[i]+"").toUpperCase())){
				rCount = charCount.get((nameArray[i]+"").toUpperCase()) + 1;
				charCount.put((nameArray[i]+"").toUpperCase(), rCount);
			
			}else if(charCount.size() > 0 && !charCount.containsKey((nameArray[i]+"").toUpperCase())){
				charCount.put((nameArray[i]+"").toUpperCase(),1);
			}else{
				charCount.put((nameArray[i]+"").toUpperCase(),1);
			}
			
		}
		System.out.println("Contents of HashMap is :"+charCount);
		for(int k = 0 ; k<name.length() ; k++){
			String c = (name.charAt(k)+"").toUpperCase();
			if(charCount.get(c) == 1){
				System.out.println("Non repeated character is :"+c);
				norepeats = 1;
				break;
			}
		}
		if(norepeats == 0)
		System.out.println("No non-repeated Characters in :"+name);
	}
}
