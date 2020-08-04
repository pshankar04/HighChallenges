package HackerRank;

import java.util.LinkedList;
import java.util.Scanner;

public class MaxPathSum {
	public static LinkedList<LinkedList<String>> seriesList = new LinkedList<LinkedList<String>>();
	public static LinkedList<Integer> resultList;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		LinkedList<String> series ;
		String numSeries = "";
		int totalLines = 0,first = 0,second = 0,sum = 0 ;
		int tc = Integer.parseInt(input.nextLine());
		if(tc >= 1 && tc <= 10){
			for(int i = 0 ; i < tc ;i++){
				totalLines = Integer.parseInt(input.nextLine());
				if(totalLines >= 1 && totalLines <= 15){
					series = new LinkedList<String>();
					for(int j = 0 ; j < totalLines ; j++){
						series.add(input.nextLine());
					}
					seriesList.add(series);
				}
			}
		}

		for(LinkedList<String> list : seriesList){
			for(int i = list.size() - 1 ; i > 0 ;i--){
				String[] lastButOne = list.get(i-1).split(" ");
				String[] last = list.get(i).split(" ");
				resultList = new LinkedList<Integer>();
				for(int k = 0, j = 0  ; k < lastButOne.length && j < last.length ; j++,k++){
					if((j + 1) < last.length){
						sum = (Integer.parseInt(lastButOne[k]) + max(last[j],last[j + 1]));
						resultList.add(sum);
					}
				}
				list.remove(list.get(i));
				list.remove(list.get(i-1));
				numSeries = toStringRep(resultList);
				list.add(numSeries);
				
			}
			System.out.println(list.get(0));
		}
		input.close();
	}

	public static String toStringRep(LinkedList<Integer> rList){
		String nums = "";
		for(int i = 0 ; i < rList.size() ; i++){
			nums = nums + String.valueOf(rList.get(i)) + " ";
		}
		return nums;
	}


	public static int max(String a, String b){

		if(Integer.parseInt(a) > Integer.parseInt(b)){
			return Integer.parseInt(a);
		}else{
			return Integer.parseInt(b);
		}
	}
}
