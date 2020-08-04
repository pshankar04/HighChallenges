package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CreditCard {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				System.out.println(checkCreditCard(line));
			}
			buffer.close();

		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public static String checkCreditCard(String cardNumber){
		int sum = 0;
		if(cardNumber.length() > 0){
			String[] cardlets = cardNumber.split(" ");
			for(int i = 0 ; i < cardlets.length ; i++){
				sum = sum + calculateSum(cardlets[i]);
			}
			if((sum % 10) == 0){
				return "Real";
			}else{
				return "Fake";
			}
		}
		return "Enter proper Card Number";

	}

	public static int calculateSum(String nums){
		int tempSum = 0;
		for(int j = 0 ; j < nums.length() ; j++){
			tempSum = (Integer.parseInt(nums.charAt(0)+"") * 2) + (Integer.parseInt(nums.charAt(2)+"") * 2) + 
					   Integer.parseInt(nums.charAt(1)+"") +Integer.parseInt(nums.charAt(3)+"");
		}
		return tempSum;
	}

}
