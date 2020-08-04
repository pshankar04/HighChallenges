package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class CashRegister {

	public static LinkedHashMap<String,Float> changeMap = new LinkedHashMap<String,Float>();
	public static float change;

	static{
		changeMap.put("ONE HUNDRED",new Float(100.00));
		changeMap.put("FIFTY",new Float(50.00));
		changeMap.put("TWENTY",new Float(20.00));
		changeMap.put("TEN",new Float(10.00));
		changeMap.put("FIVE",new Float(5.00));
		changeMap.put("TWO",new Float(2.00));
		changeMap.put("ONE",new Float(1.00));
		changeMap.put("HALF DOLLAR",new Float(0.50));
		changeMap.put("QUARTER",new Float(0.25));
		changeMap.put("DIME",new Float(0.10));
		changeMap.put("NICKEL",new Float(0.05));
		changeMap.put("PENNY",new Float(0.01));
	}


	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				System.out.println(returnChange(line));
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static String returnChange(String cashAmount){
		String returnChange = "ZERO";
		float purchasePrice = new Float(cashAmount.split(";")[0]).floatValue();
		float cash = new Float(cashAmount.split(";")[1]).floatValue();
		change = cash - purchasePrice;
		if(purchasePrice > 0 && cash > 0){
			if(cash < purchasePrice){
				returnChange =  "ERROR";
			}else if((cash - purchasePrice) == (float)0){
				returnChange =  "ZERO";
			}else{
				return removeComma(calculateChange(change));
			}
		}
		return returnChange;
	}
	public static String calculateChange(float changeReturn){
		
		String termString = "";
		boolean inLoop = true;
		while(inLoop){
			
			Set<Map.Entry<String,Float>> entrySet = changeMap.entrySet();
			for(Map.Entry<String, Float> entry : entrySet){
				float changeOnMap = (float)entry.getValue();
				if(reduceDigits(changeReturn,2) > changeOnMap){
					changeReturn = changeReturn - changeOnMap;
					termString = termString + entry.getKey() + ",";
					break;
				}else if(reduceDigits(changeReturn,2) == changeOnMap){
					changeReturn = reduceDigits(changeReturn,2) - changeOnMap;
					termString = termString + entry.getKey() + ",";
					inLoop = false;
					break;
				} 
			}
			if(reduceDigits(changeReturn,2) == 0.00){
				inLoop = false;
			}
		}
		return termString;
	}
	
	public static String removeComma(String term){
		return (term.charAt(term.length() -1) == ',') ? new String(new StringBuilder(term).deleteCharAt(term.lastIndexOf(','))) : term;
	}
	
	
	public static float reduceDigits(float pNumero, int pCantidadDecimales) {	  
	    BigDecimal value = new BigDecimal(pNumero);
	    value = value.setScale(pCantidadDecimales, BigDecimal.ROUND_HALF_EVEN); // here the value is correct (625.30)
	    return value.floatValue(); // but here the values is 625.3
	}
}
