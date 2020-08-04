package HackerRank;

import java.util.LinkedList;
import java.util.Scanner;

public class JavaLists {

	public static LinkedList<Integer> numList;
	public static void main(String[] args) throws Exception {
		numList = new LinkedList<Integer>();
		Scanner num = new Scanner(System.in);
		int index = 0 ,number = 0 , delIndex = 0; 
		String operation = "";
		int totalNumbers = num.nextInt();
		for(int i = 0 ; i < totalNumbers ; i++){
			numList.add(num.nextInt());
		}
		int totalOperations = num.nextInt();

		for(int i = 0 ; i < totalOperations ; i++){
			num.nextLine();
			operation = num.next();
			if(operation.equals("Insert")){
				index = num.nextInt();
				number = num.nextInt();
				numList.add(index, number);
			}else if(operation.equals("Delete")) { 
				delIndex = num.nextInt();
				numList.remove(delIndex);
			} 
		}
		for(Integer no : numList){
			System.out.print(no+" ");
		}
		num.close();
	}

}

