package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class MatrixRotation {

	public static LinkedList<String> matrixList ;
	public static LinkedList<String> rotatedMatrixList ;
	public static String[] numbers ;
	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				rotateMatrix(line);
				System.out.println();
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void rotateMatrix(String matrixNumbers){
		matrixList = new LinkedList<String>();
		numbers = matrixNumbers.split(" ");
		String row = "";
		for(int i = 0 ; i < numbers.length ; i= (i+(int)Math.sqrt(numbers.length))){
			for(int k = 0 ; k < Math.sqrt(numbers.length) ; k++){
				row = row + numbers[i+k];
			}
			matrixList.add(row);
			row = "";
		}

		rotateAndPrint(matrixList);
	}

	public static void rotateAndPrint(LinkedList<String> numbersList){
		ListIterator<String> litr =  numbersList.listIterator();
		rotatedMatrixList = new LinkedList<String>();
		int i = 0 , j= 0;
		while(i < numbers.length){
			while(litr.hasNext()){litr.next();}
			while(litr.hasPrevious()){
				System.out.print(((String)litr.previous()).charAt(j)+" ");
			}
			i = i + (int)Math.sqrt(numbers.length);
			j++;
		}

	}
}
