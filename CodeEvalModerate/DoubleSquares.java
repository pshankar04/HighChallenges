package CodeEvalModerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class DoubleSquares {

	public static boolean numberCount = true;
	public static ArrayList<Integer> numList = new ArrayList<Integer>();
	public static ArrayList<Integer> perfectSquareList ;
	public static int totalNums = 0;

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;

			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)) {
				saveNumbers(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		findDoubleSquares(numList);
	}


	public static void saveNumbers(String number){

		if(numberCount){
			totalNums = Integer.parseInt(number);
			numberCount = false;
		}else{
			numList.add(Integer.parseInt(number));
		}
	}


	public static void findDoubleSquares(ArrayList<Integer> numberList){
		perfectSquareList = new ArrayList<Integer>();
		int maxNumber = Collections.max(numberList);
		int sqrt = 0 ;
		for(int i = 0 ; i <= maxNumber ; i++){
			sqrt = (int) Math.sqrt(i);
			if (sqrt * sqrt == i) {
				perfectSquareList.add(i);
			}
		}

		for(Integer num : numberList){
			findlesserSquares(num,perfectSquareList);
		}
	}

	public static void findlesserSquares(int number, ArrayList<Integer> nList){
		ArrayList<Integer> squareList = new ArrayList<Integer>();
		ArrayList<String> squaresStringList = new ArrayList<String>();
		String content = "";
		for(Integer n : nList){
			if(n <= number){
				squareList.add(n);
			}
		}
		 
		if(squareList.size() == 1){
			System.out.println(squareList.size()); 
		}else{
			int[] numSqaures =  new int[squareList.size()];

			for(int i = 0 ; i < squareList.size() ; i++){
				numSqaures[i] = squareList.get(i);
			}

			for(int i = 0 ; i < numSqaures.length ; i++){
				for(int j = 0 ; j< numSqaures.length ; j++){
					if(i == j){
						continue;
					}else{
						if((numSqaures[i] + numSqaures[j]) == number ){
							content = numSqaures[i]+","+numSqaures[j];
							if(!squaresStringList.contains(content) && !squaresStringList.contains(returnReverse(content))){
								squaresStringList.add(content);
							}
						}
					}
				}
			}
			 
			System.out.println(squaresStringList.size());
		}
	}

	public static String returnReverse(String num){
		return  (num.split(",")[1]+","+num.split(",")[0]);
	}


}
