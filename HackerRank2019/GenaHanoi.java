package HackerRank;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class GenaHanoi {
	public static LinkedList<Integer> diskNumList = new LinkedList<Integer>();
	public static LinkedList<Stack<Integer>> rodStackList = new LinkedList<Stack<Integer>>(); 

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int total = Integer.parseInt(input.nextLine());
		String[] rods = (input.nextLine()).split(" ");
		for(int i = 0 ; i < total ; i++){
			diskNumList.add(Integer.parseInt(rods[i]));
		}
		int rodCount = Collections.max(diskNumList);

		for(int i = 0 ; i < rodCount ; i++){
			rodStackList.add(new Stack<Integer>());
		}

		for(int j = rods.length - 1 ; j >= 0 ; j--){
			rodStackList.get(Integer.parseInt(rods[j]) - 1).push(j+1);
		}

		restoreDisks(rodStackList,total);
		input.close();
	}

	public static void restoreDisks(LinkedList<Stack<Integer>> diskStack, int totalDisks){
		int sizeOfOne = rodStackList.get(0).size();
		int requiredDisk = 0;
		while(sizeOfOne < totalDisks){
			requiredDisk = findDifference(rodStackList,totalDisks);
			reshuffle(rodStackList,requiredDisk);
		}

	}

	public static void reshuffle(LinkedList<Stack<Integer>> diskStackList , int diff){

		boolean found = false;
		int stackNumber = 0 , indexAtStack = 0;
		while(!found){
			for(int i = 1 ; i < diskStackList.size() ; i++){
				if(!found){
					for(int j = 0 ; j < diskStackList.get(i).size() ; j++){
						if(diskStackList.get(i).get(j) == diff){
							stackNumber = i;
							indexAtStack = j;
							found = true;
							break;
						}
					}
				}else{
					break;
				}
			}
		}
		moveDiskNow(diskStackList,stackNumber,indexAtStack);
	}

	public static void moveDiskNow(LinkedList<Stack<Integer>> diskStackList , int stackId , int index){
		
		diskStackList.get(0).push(diskStackList.get(stackId).remove(index));
		
		for(Stack<Integer> st : diskStackList){
			for(Integer i : st){
				System.out.print(i+" ");
			}
			System.out.println();
		}
		//maintainOrder(diskStackList);
	}
	
	
	public static int findDifference(LinkedList<Stack<Integer>> diskStackList , int total){
		Stack<Integer> firstStack = diskStackList.get(0);
		int diff = 0;
		if(firstStack.size() > 1){
			diff = firstStack.get(firstStack.size() - 2) - firstStack.get(firstStack.size() - 1);
		}else if(firstStack.size() == 1){
			diff =  firstStack.peek() - 1;
		}else if(firstStack.size() == 0){
			diff = total;
		}
		return diff;
	}
}
