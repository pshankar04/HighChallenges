package CodeEvalModerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class MagicNumber {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{	
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			int count = 0;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0) && (count < 20)) {
				checkMagicness(line);
				count++;
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void checkMagicness(String series){
		LinkedList<Integer> magicNumbers = new LinkedList<Integer>();
		int start = Integer.parseInt(series.split(" ")[0]);
		int end = Integer.parseInt(series.split(" ")[1]);

		for(int i = start ; i <= end ; i++){
			if(isMagicNumber(i) && noDuplicates(i)){
				magicNumbers.add(i);
			}
		}

		if(magicNumbers.size() == 0){
			System.out.println("-1");
		}else{
			for(Integer i : magicNumbers){
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}

	public static boolean noDuplicates(int num){
		HashSet<String> digitSet = new HashSet<String>();
		String number = String.valueOf(num);

		for(int i = 0 ; i < number.length() ; i++){
			digitSet.add(number.charAt(i)+"");
		}

		if(digitSet.size() == number.length()){
			return true;
		}else{
			return false;
		}

	}



	public static boolean isMagicNumber(int num){
		String number = String.valueOf(num); 
		ArrayList<String> charsList = new ArrayList<String>();
		String orgNum = number;
		char pos = '0';
		int repeations = 0 , index = 0 ,addIndex = 0;
		repeations = max(number);

		
		for(int j = 0 ; j < repeations ; j++){
			number = number + number;
		}
		 
		
		for(int k = 0 ; k < orgNum.length() ; k++){
			if(k == 0){
				index = Integer.parseInt(orgNum.charAt(k)+"");
				pos = number.charAt(index);
				charsList.add(pos+"");
			}else{
				addIndex = Integer.parseInt(pos+"");
				index = index + addIndex ;
				pos = number.charAt(index);
				charsList.add(pos+"");
				addIndex = 0;

			}
		}
		number = "";
		index = 0;
		if(pos == orgNum.charAt(0) && allCharsMet(charsList,orgNum)){
			return true;
		}else{
			return false;
		}

	}

	public static boolean allCharsMet(ArrayList<String> charList , String num){
		int count = 0;
		for(int i = 0 ; i < num.length() ; i++){
			if(charList.contains(num.charAt(i)+"")){
				count++;
			}
		}
		if(charList.size() == num.length() && (count == charList.size() && (count == num.length()))){
			return true;
		}else{
			return false;
		}
	}
	
	
	public static int max(String num){
		ArrayList<Integer> digitList = new ArrayList<Integer>();

		for(int i = 0 ; i < num.length() ; i++){
			digitList.add(Integer.parseInt(num.charAt(i)+""));
		}

		return Collections.max(digitList);
	}







}
