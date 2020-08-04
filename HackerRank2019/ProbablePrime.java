package HackerRank;


import java.util.LinkedList;
import java.util.Scanner;

public class ProbablePrime {

	public static LinkedList<Integer> numList;
	public static String[] operationNames;
	public static String[] operationParametres;
	public static void main(String[] args) {
		numList = new LinkedList<Integer>();
		Scanner str = new Scanner(System.in);
		 
		int totalNumbers = Integer.parseInt(str.nextLine());
		
		for(int i = 0 ; i < totalNumbers ; i++){
			numList.add(str.nextInt());
		}
		
		int totalOperations = Integer.parseInt(str.nextLine());

		for(int i = 0 ; i < totalOperations ; i++){
			operationNames[i] = str.nextLine();
			operationParametres[i] = str.nextLine();
		}

		

		for(int i = 0 ; i < totalOperations ; i++){
			if(operationNames[i].equals("Insert")){
				numList.add(Integer.parseInt(operationParametres[i].split(" ")[0]), Integer.parseInt(operationParametres[i].split(" ")[1]));
			}else{
				numList.remove(Integer.parseInt(operationParametres[i]));
			}
		}
		for(Integer i : numList){
			System.out.print(i+" ");
		}

		str.close();

	}

}
