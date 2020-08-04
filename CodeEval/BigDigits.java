package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class BigDigits {
	public static int digitCount = 1;
	public static int perDigitSpace = 5;
	public static ArrayList<Integer> charList ; 
	
	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				printBigDigits(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void printBigDigits(String number){
		 
		digitCount = findCount(number);
		charList = new ArrayList<Integer>();
		for(int i = 0 ; i < number.length() ; i++){
			if(Character.isDigit(number.charAt(i))){
				charList.add(Character.getNumericValue(number.charAt(i)));
			}
		}
		 
		printDigitInBig(charList);
	}

	public static int findCount(String num){
		int digiCount = 0;
		for(int i = 0 ; i < num.length() ; i++){
			if(Character.isDigit(num.charAt(i))){
				digiCount++;
			}
		}
		return digiCount;
	}

	public static int getDigit(ArrayList<Integer> numberList,int index){
		int number = -1;
		if(numberList.size() >= (index + 1)){
			number = numberList.get(index);
		}
		return number;
	}
	public static void printDigitInBig(ArrayList<Integer> numList){

		int digit = 0;
		int digitNumber = 0;
		int columnCount = 0;
		int printCount = 0;
		for(int k = 1 ; k < 7 ; k++){
			for(int j = 1 ; (j < (perDigitSpace * digitCount) + 1); j++){
				if(printCount == 4 || printCount == 0){
					digit = getDigit(numList,digitNumber);
					if(digit >= 0){
						columnCount = getColumns(k,digit).split(",").length;
						printCount = 0;
					}else{
						break;
					}
				}
				if((j > 0) && ((j % 5) == 0)) {
					System.out.print("- ");
					printCount++;
					digitNumber++;
					digit = getDigit(numList,digitNumber);
					if(digit >= 0){
						columnCount = getColumns(k,digit).split(",").length;
						continue;
					}else{
						break;
					}
				}
				if(k == 1){
					if(columnCount == 4){
						if((j == ((digitNumber * 5) + Integer.parseInt(getColumns(k,digit).split(",")[0]))) ||
								(j == ((digitNumber * 5) + Integer.parseInt(getColumns(k,digit).split(",")[1]))) || 
								(j == ((digitNumber * 5) + Integer.parseInt(getColumns(k,digit).split(",")[2]))) ||
								(j == ((digitNumber * 5) + Integer.parseInt(getColumns(k,digit).split(",")[3])))){
							System.out.print("* ");
						}else{
							System.out.print("- ");
						}printCount++;
					}else if(columnCount == 3){

						if((j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[0])))) || 
								(j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[1])))) ||
								(j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[2]))))){
							System.out.print("* ");
						}else{
							System.out.print("- ");
						}printCount++;
					}else if(columnCount == 2){
						if((j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[0])))) ||
								((j ==  ((digitNumber * 5) +  (Integer.parseInt(getColumns(k,digit).split(",")[1])))))){
							System.out.print("* ");
						}else{
							System.out.print("- ");
						}printCount++;
					}else if(columnCount == 1){
						if((j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[0]))))){
							System.out.print("* ");
						}else{
							System.out.print("- ");
						}printCount++;
					}
				}else if(k == 2){
					if(columnCount == 4){
						if((j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[0])))) ||
								(j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[1])))) || 
								(j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[2])))) ||
								(j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[3]))))){
							System.out.print("* ");
						}else{
							System.out.print("- ");
						}printCount++;
					}else if(columnCount == 3){
						if((j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[0])))) || 
								(j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[1])))) ||
								(j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[2]))))){
							System.out.print("* ");
						}else{
							System.out.print("- ");
						}printCount++;
					}else if(columnCount == 2){
						if((j == (digitNumber * 5) + Integer.parseInt(getColumns(k,digit).split(",")[0])) ||
						   (j == (digitNumber * 5) + Integer.parseInt(getColumns(k,digit).split(",")[1]))){
							System.out.print("* ");
						}else{
							System.out.print("- ");
						}printCount++;
					}else if(columnCount == 1){
						if((j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[0]))))){
							System.out.print("* ");
						}else{
							System.out.print("- ");
						}printCount++;
					}

				}else if(k == 3){
					if(columnCount == 4){
						if((j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[0])))) ||
								(j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[1])))) || 
								(j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[2])))) ||
								(j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[3]))))){
							System.out.print("* ");
						}else{
							System.out.print("- ");
						}printCount++;
					}else if(columnCount == 3){
						if((j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[0])))) || 
								(j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[1])))) ||
								(j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[2]))))){
							System.out.print("* ");
						}else{
							System.out.print("- ");
						}printCount++;
					}else if(columnCount == 2){
						if((j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[0])))) ||
								((j ==  ((digitNumber * 5) +  (Integer.parseInt(getColumns(k,digit).split(",")[1])))))){
							System.out.print("* ");
						}else{
							System.out.print("- ");
						}printCount++;
					}else if(columnCount == 1){
						if((j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[0]))))){
							System.out.print("* ");
						}else{
							System.out.print("- ");
						}printCount++;
					}

				}else if(k == 4){
					if(columnCount == 4){
						if((j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[0])))) ||
						   (j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[1])))) || 
						   (j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[2])))) ||
						   (j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[3]))))){
							System.out.print("* ");
						}else{
							System.out.print("- ");
						}printCount++;
					}else if(columnCount == 3){
						if((j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[0])))) || 
								(j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[1])))) ||
								(j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[2]))))){
							System.out.print("* ");
						}else{
							System.out.print("- ");
						}printCount++;
					}else if(columnCount == 2){
						if((j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[0])))) ||
								((j ==  ((digitNumber * 5) +  (Integer.parseInt(getColumns(k,digit).split(",")[1])))))){
							System.out.print("* ");
						}else{
							System.out.print("- ");
						}printCount++;
					}else if(columnCount == 1){
						if((j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[0]))))){
							System.out.print("* ");
						}else{
							System.out.print("- ");
						}printCount++;
					}

				}else if(k == 5){
					if(columnCount == 4){
						if((j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[0])))) ||
								(j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[1])))) || 
								(j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[2])))) ||
								(j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[3]))))){
							System.out.print("* ");
						}else{
							System.out.print("- ");
						}printCount++;
					}else if(columnCount == 3){
						if((j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[0])))) || 
								(j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[1])))) ||
								(j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[2]))))){
							System.out.print("* ");
						}else{
							System.out.print("- ");
						}printCount++;
					}else if(columnCount == 2){
						if((j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[0])))) ||
								((j ==  ((digitNumber * 5) +  (Integer.parseInt(getColumns(k,digit).split(",")[1])))))){
							System.out.print("* ");
						}else{
							System.out.print("- ");
						}printCount++;
					}else if(columnCount == 1){
						if((j == ((digitNumber * 5) + (Integer.parseInt(getColumns(k,digit).split(",")[0]))))){
							System.out.print("* ");
						}else{
							System.out.print("- ");
						}printCount++;
					}
				}
				else{
					System.out.print("- ");
				}
			}
			digitNumber = 0;
			printCount = 0;
			System.out.println();
		}

	}


	public static String getColumns(int row , int digi){
//		if(row == 2)
//		System.out.println("DIGIT : "+digi);
		String colNumbers = "";
		if(row == 1){
			if(digi == 0){
				colNumbers = "2,3";
			}if(digi == 1){
				colNumbers = "3";
			}if(digi == 2){
				colNumbers = "1,2,3";
			}if(digi == 3){
				colNumbers = "1,2,3";
			}if(digi == 4){
				colNumbers = "2";
			}if(digi == 5){
				colNumbers = "1,2,3,4";
			}if(digi == 6){
				colNumbers = "2,3";
			}if(digi == 7){
				colNumbers = "1,2,3,4";
			}if(digi == 8){
				colNumbers = "2,3";
			}if(digi == 9){
				colNumbers = "2,3";
			}
		}else if(row == 2){

			if(digi == 0){
				colNumbers = "1,4";
			}if(digi == 1){
				colNumbers = "2,3";
			}if(digi == 2){
				colNumbers = "4";
			}if(digi == 3){
				colNumbers = "4";
			}if(digi == 4){
				colNumbers = "1,4";
			}if(digi == 5){
				colNumbers = "1" ;
			}if(digi == 6){
				colNumbers = "1";
			}if(digi == 7){
				colNumbers = "4";
			}if(digi == 8){
				colNumbers = "1,4";
			}if(digi == 9){
				colNumbers = "1,4";
			}
		}else if(row == 3){

			if(digi == 0){
				colNumbers = "1,4";
			}if(digi == 1){
				colNumbers = "3";
			}if(digi == 2){
				colNumbers = "3";
			}if(digi == 3){
				colNumbers = "2,3";
			}if(digi == 4){
				colNumbers = "1,2,3,4";
			}if(digi == 5){
				colNumbers = "1,2,3" ;
			}if(digi == 6){
				colNumbers = "1,2,3";
			}if(digi == 7){
				colNumbers = "3";
			}if(digi == 8){
				colNumbers = "2,3";
			}if(digi == 9){
				colNumbers = "2,3,4";
			}
		}else if(row == 4){

			if(digi == 0){
				colNumbers = "1,4";
			}if(digi == 1){
				colNumbers = "3";
			}if(digi == 2){
				colNumbers = "2";
			}if(digi == 3){
				colNumbers = "4";
			}if(digi == 4){
				colNumbers = "4";
			}if(digi == 5){
				colNumbers = "4" ;
			}if(digi == 6){
				colNumbers = "1,4";
			}if(digi == 7){
				colNumbers = "2";
			}if(digi == 8){
				colNumbers = "1,4";
			}if(digi == 9){
				colNumbers = "4";
			}
		} else if(row == 5){

			if(digi == 0){
				colNumbers = "2,3";
			}if(digi == 1){
				colNumbers = "2,3,4";
			}if(digi == 2){
				colNumbers = "1,2,3,4";
			}if(digi == 3){
				colNumbers = "1,2,3";
			}if(digi == 4){
				colNumbers = "4";
			}if(digi == 5){
				colNumbers = "1,2,3" ;
			}if(digi == 6){
				colNumbers = "2,3";
			}if(digi == 7){
				colNumbers = "2";
			}if(digi == 8){
				colNumbers = "2,3";
			}if(digi == 9){
				colNumbers = "2,3";
			}
		}
		return colNumbers;
	}
}
