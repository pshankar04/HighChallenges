package HackerEarth;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Scanner;

public class GirlFriendDemands {
	public static LinkedList<String> chantList;
	public static LinkedList<String> resultList;
	public static String demandItem = "";
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		demandItem = input.nextLine();
		long itemLen = demandItem.length();
		long totalChants = Long.parseLong(input.nextLine());
		BigInteger a = BigInteger.ONE;
		BigInteger b = BigInteger.ONE;
		String line = "";
		chantList = new LinkedList<String>();
		resultList = new LinkedList<String>();
		for(long i = 0 ; i < totalChants ; i++){
			line = input.nextLine();
			a = new BigInteger(line.split(" ")[0]);
			b = new BigInteger(line.split(" ")[1]);
			if(a.compareTo(new BigInteger(itemLen+"")) > 0){
				a = (a.mod(new BigInteger(itemLen+"")));

			}
			if(b.compareTo(new BigInteger(itemLen+"")) > 0){
				b = (b.mod(new BigInteger(itemLen+"")));
			}

			a = a.subtract(BigInteger.ONE);
			b = b.subtract(BigInteger.ONE);

			if((demandItem.charAt(a.intValue())) == (demandItem.charAt(b.intValue()))){
				//resultList.add("Yes");
				System.out.println("Yes");
			}else{
				//resultList.add("No");
				System.out.println("No");
			}

		}
//		for(String s : resultList){
//			System.out.println(s);
//		}
		input.close();
	}

}
