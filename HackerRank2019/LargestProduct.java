package HackerRank;

import java.math.BigInteger;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class LargestProduct {
	public static LinkedList<Long> productList;
	public static void main(String[] args) {
		int lengthOfNumber = 0 , consInteger = 0;
		String number = "";
		String series = "";
		LinkedList<String> numDataList = new LinkedList<String>();
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		if(tc >= 1 || tc <= 100){
			for(int i = 0 ; i < tc ; i++){
				series = input.nextLine();
				lengthOfNumber = Integer.parseInt(series.split(" ")[0]);
				consInteger = Integer.parseInt(series.split(" ")[1]);
				number =  input.nextLine();

				if((lengthOfNumber >= consInteger || lengthOfNumber <= 1000) && (consInteger >= 1 && consInteger <= 7)) {
					numDataList.add(lengthOfNumber+","+consInteger+","+number);
				}
			}

			for(String s : numDataList){ 
				findLargestProduct(Integer.parseInt(((s.split(","))[0]).trim()),Integer.parseInt(((s.split(","))[1]).trim()),s.split(",")[2]);
			}
		}
		input.close();
	}

	public static void findLargestProduct(int len , int size , String number){
		productList = new LinkedList<Long>();
		long product = 1;
		 
		for(int i = 0 ; i < (len - size) ; i++){
			for(int k = i ; k < (size + i) ; k++){
				product = product * (Integer.parseInt(number.charAt(k)+""));
			}
			productList.add(product);
			product = 1;
		}
		System.out.println(Collections.max(productList));
	}
}
