package HackerRank;

import java.util.Scanner;

public class MergeSortedArrays {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a = Integer.parseInt(input.nextLine());
		int[] first = new int[a];
		for(int i = 0 ; i < a ; i++){
			first[i] = Integer.parseInt(input.nextLine());
		}
		int b = Integer.parseInt(input.nextLine());
		int[] second = new int[b];
		for(int i = 0 ; i < b ; i++){
			second[i] = Integer.parseInt(input.nextLine());
		}
		int[] finalArray = mergeArrays(first,second);
		
		for(Integer i : finalArray){
			System.out.println(i);
		}
		input.close();
	}

	public static int[] mergeArrays(int[] a , int[] b){
		int[] finalArray = new int[a.length + b.length];
		int j = 0 , k= 0;
		for(int i = 0 ; (i < finalArray.length) ; i++){
			if((j < a.length) && (k < b.length) && (a[j] < b[k])){
				finalArray[i] = a[j];
				j++;
			}else if((j < a.length) && (k < b.length) && (a[j] > b[k])){
				finalArray[i] = b[k];
				k++;
			}else if((j < a.length) && (k < b.length) && (a[j] == b[k])){
				finalArray[i] = a[j];
				i++;
				finalArray[i] = b[k];
				k++;
				j++;
			}else if(k >= b.length){
				for(int n = j ; n < a.length ; n++){
					finalArray[i] = a[n];
					i++;
				}
			}else if(j >= a.length){
				for(int n = k ; n < b.length ; n++){
					finalArray[i] = b[n];
					i++;
				}
			}
		}
		return finalArray;
	}
}
