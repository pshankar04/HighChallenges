package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class FootBall {

	public   HashSet<Integer> numSet = new HashSet<Integer>();
	public   ArrayList<ArrayList<Integer>> numbersList = new ArrayList<ArrayList<Integer>>();
	public   TreeMap<Integer,String> supportingCountries = new TreeMap<Integer,String>();

	public static void main(String[] args) {

		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				FootBall fb= new FootBall();
				line = line.trim();
				fb.saveTeams(line);
				fb.findSupporters(fb.numSet,fb.numbersList);
				fb.printSupportingCountries(fb.supportingCountries);
			}
			buffer.close();

		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public void saveTeams(String countryTeams){
		String[] countries = countryTeams.split(" \\| ");
		for(int i = 0 ; i < countries.length ; i++){
			for(int k = 0 ; k < countries[i].split(" ").length ; k++){
					this.numSet.add(Integer.parseInt(countries[i].split(" ")[k]));
			}
			this.saveToArrayList(countries[i].trim());
		}
	}

	public void saveToArrayList(String strArray){
		String[] strNumArray = strArray.split(" ");
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int j = 0 ; j < strNumArray.length ; j++){
			list.add(Integer.parseInt(strNumArray[j]));
		}
		Collections.sort(list);
		this.numbersList.add(list);
	}

	public void findSupporters(HashSet<Integer> numberSet,ArrayList<ArrayList<Integer>> numbersList){

		Iterator<Integer> setItr = numberSet.iterator();
		while(setItr.hasNext()){
			Integer a = (Integer)setItr.next();
			this.checkForSupporters(a,numbersList);
		}
	}

	public void checkForSupporters(Integer team , ArrayList<ArrayList<Integer>> countryList){
		String teams = "";
		int count = 1;
		Iterator<ArrayList<Integer>> listItr = countryList.iterator();
		while(listItr.hasNext()){
			ArrayList<Integer> nums = (ArrayList<Integer>)listItr.next();
			if(nums.contains(team)){
				teams = teams + count + ",";
				this.supportingCountries.put(team,teams);
				count++;
			}else{
				count++;
			}
		}
	}
	
	public void printSupportingCountries(TreeMap<Integer,String> teamMaps){
		
		 Set<Map.Entry<Integer, String>> teamSet = teamMaps.entrySet();
		 for(Entry<Integer,String> entry : teamSet){
			 System.out.print(entry.getKey()+":"+this.manipulateValue(new StringBuilder(entry.getValue())));
			 System.out.print("; ");
		 }
		 System.out.println();
	}
	
	public String manipulateValue(StringBuilder value){
		while((value.charAt(value.length() - 1) == ',')){
			value = value.deleteCharAt(value.length() - 1);
		}
		return new String(value);
	}

}
