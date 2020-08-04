package HackerRank;

import java.util.ArrayList;
import java.util.LinkedList;

public class SubList {

	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		list1.add(10);
		list1.add(20);
		list1.add(30);
		
		list2.add(40);
		list2.add(50);

		 System.out.println(find(list1,list2));
	}

 
	public static int find(ArrayList<Integer> l1 , ArrayList<Integer> l2){
		int sub = 1;
		LinkedList<Integer> indexList = new LinkedList<Integer>();
		 for(Integer i : l2){
			 if(l1.contains(i)){
				 indexList.add(getIndex(i,l1));
			 }
		 }
		 
		 for(Integer index : indexList){
			 sub = index - sub ;
			 sub++;
		 }
		 if(sub == l2.size()){
			 return indexList.getFirst();
		 }else{
			 return -1;
		 }
		 
	}
	
	public static int getIndex(int num , ArrayList<Integer> numList){
		
		for(int i = 0 ; i < numList.size() ; i++){
			if(numList.get(i) == num){
				return i;
			}
		}
		return -1;
	}
}
