package HackerRank;

 
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution2 {

	public static TreeSet<Integer> numSet  = new TreeSet<Integer>();
	public static TreeSet<Integer> finalNumSet ;  
	public static void main(String[] args) {
		String[] series;
		Scanner numInput = new Scanner(System.in);
		int totalNums = Integer.parseInt(numInput.nextLine());
		if(totalNums >= 2){
			series = (numInput.nextLine()).split(" ");
			for(int i = 0 ; i < series.length ; i++){
				numSet.add(Integer.parseInt(series[i]));
			}
			int largestIndex = Integer.parseInt(numInput.nextLine());
			finalNumSet = performOperation(numSet);
			if(largestIndex >= 1){
				System.out.println(findLargestNumber(largestIndex));
			}
		}
		numInput.close();
		 
	}


	public static TreeSet<Integer> performOperation(TreeSet<Integer> numberSet){
		finalNumSet = new TreeSet<Integer>(numberSet);
		int sum = 0;
		int[] numArray = new int[finalNumSet.size()];
		numArray = pushToArray(finalNumSet);
		for(int  i = 0 ; i < numArray.length ; i++){
			for(int j = 0 ; j < numArray.length ; j++){
				if(i == j){
					continue;
				}else{
					sum = Math.abs(numArray[i] - numArray[j]);
					finalNumSet.add(sum);
					sum = 0;
				}
			}
		}

		return finalNumSet;
	}

	public static int[] pushToArray(TreeSet<Integer> setNum){
		int[] nums = new int[setNum.size()];
		int i = 0;
		for(Integer number : setNum){
			nums[i] = number;
			i++;
		}
		return nums;
	}

	public static int findLargestNumber(int index){
		index = index -1;
		int largeNum = 0 , i = 0;
		LinkedList<Integer> numList = new LinkedList<Integer>(finalNumSet);
		ListIterator<Integer> li = numList.listIterator();
		while(li.hasNext()){
			li.next();
		}
		
		while(li.hasPrevious()){
			if(i == index){
				largeNum = li.previous();
				break;
			}else{
				li.previous();
			}
			i++;
		}
		return largeNum;
	}
}
