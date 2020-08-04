package HackerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class JavaHashset {

	public static void main(String[] args) {
		//				Scanner in = new Scanner(System.in);
		//				int t = Integer.parseInt(in.nextLine());
		//				HashMap<String,String> nameMap = new HashMap<String,String>();
		//				int uniqueCount = 0;
		//				ArrayList<Integer> countList = new ArrayList<Integer>();
		//				

		//				for(int i = 0 ; i < t ; i++){
		//					firstName = in.next();
		//					secondName = in.next();
		//					if(nameMap.size() == 0){
		//						nameMap.put(firstName,secondName);	
		//						uniqueCount++;
		//					}
		//					else if(nameMap.containsKey(firstName) && !nameMap.get(firstName).equals(secondName)){
		//						uniqueCount++;
		//					}else if(nameMap.containsKey(firstName) && nameMap.get(firstName).equals(secondName)){
		//						countList.add(uniqueCount);
		//						continue;
		//					}
		//					else{
		//						nameMap.put(firstName,secondName);
		//						uniqueCount++;
		//					}
		//					countList.add(uniqueCount);
		//				}
		//				for(Integer e : countList){
		//					System.out.println(e);
		//				}
		//				in.close();
		//			}

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		String[] pair_left = new String[t];
		String[] pair_right = new String[t];
		int uniqueCount = 0;
		ArrayList<Integer> countList = new ArrayList<Integer>();
		HashMap<String,String> nameMap = new HashMap<String,String>();
		String firstName = "" , secondName = "";
		for(int i = 0 ; i < t ; i++){
			pair_left[i] = in.next();
			pair_right[i] = in.next();
		}
		 	
		for(int i = 0 ; i < t ; i++){
			firstName = pair_left[i];
			secondName = pair_right[i];
			if(nameMap.size() == 0){
				nameMap.put(firstName,secondName);	
				uniqueCount++;
			}
			else if(nameMap.containsKey(firstName) && !nameMap.get(firstName).equals(secondName)){
				uniqueCount++;
			}else if(nameMap.containsKey(firstName) && nameMap.get(firstName).equals(secondName)){
				countList.add(uniqueCount);
				continue;
			}
			else{
				nameMap.put(firstName,secondName);
				uniqueCount++;
			}
			countList.add(uniqueCount);
		}
		for(Integer e : countList){
			System.out.println(e);
		}
		in.close();
	}



}
