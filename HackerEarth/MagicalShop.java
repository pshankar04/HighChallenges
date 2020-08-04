package HackerEarth;

import java.math.BigInteger;
import java.util.Scanner;

public class MagicalShop {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String data = input.nextLine();
		String firstPotion =  data.split(" ")[0];
		String modulo = data.split(" ")[1];
		String daySeries = input.nextLine();
		 
		BigInteger currentPotion = new BigInteger(firstPotion);
		BigInteger ans = BigInteger.ZERO;
		BigInteger power = BigInteger.ZERO;
		BigInteger modulus = new BigInteger(modulo);
		power = currentPotion;
		for(int i = 0 ; i < daySeries.length() ; i++){
			if(daySeries.charAt(i) == '1'){
				ans = (ans.add(power)).mod(modulus);
			}
			power = (power.multiply(power)).mod(modulus);
		}
		System.out.println(ans.toString());
		input.close();
	}
	
}
