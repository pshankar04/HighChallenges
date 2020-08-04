package CodeEvalModerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

public class CardValidation {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{	
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;

			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)) {
				validateCardNumber(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public static void validateCardNumber(String cardNumber){
		cardNumber = cardNumber.replace(" ","");
		LinkedList<Integer> sumCount = new LinkedList<Integer>();
		int digit = 0 , sum = 0;
		String num = "";
		cardNumber = new String(new StringBuffer(cardNumber).reverse());
		 
		sumCount.add(Integer.parseInt(cardNumber.charAt(0)+""));
		for(int i = 1; i < cardNumber.length() ; i++){
			 
			if((i % 2) != 0 ){
				digit = Integer.parseInt(cardNumber.charAt(i)+"") * 2;
				if(digit > 9){
					num = String.valueOf(digit);
					digit = Integer.parseInt(num.charAt(0)+"") + Integer.parseInt(num.charAt(1)+"");
					sumCount.add(digit);	
				}else{
					sumCount.add(digit);
				}
			}else{
				sumCount.add(Integer.parseInt(cardNumber.charAt(i)+""));
			}
			digit = 0;
		}
		 
		for(Integer i : sumCount){
			sum = sum + i;
		}
		 
		if( (sum % 10) == 0){
			System.out.println("1");
		}else{
			System.out.println("0");
		}
	}
}
