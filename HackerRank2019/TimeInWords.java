package HackerRank;

import java.util.HashMap;
import java.util.Scanner;

public class TimeInWords {



	public static HashMap<Integer,String> hourMap;
	public static HashMap<Integer,String> minutesMap;



	public static void main(String[] args) {
		initializeMaps();
		int fullHour = 60;
		int hour =  0;
		int minutes =  0;
		Scanner input = new Scanner(System.in);
		int times = input.nextInt();
		for(int i = 0 ; i < times ; i++){
			hour = Integer.parseInt(input.next());
			minutes = Integer.parseInt(input.next());

			if(minutes == 0){
				System.out.println(hourMap.get(hour)+" o' clock"); 
			}else if(minutes > 30){
				if((fullHour - minutes) == 1){
					System.out.println(minutesMap.get(fullHour - minutes).toLowerCase()+" minute to "+hourMap.get(hour+1)); 
				}else if((fullHour - minutes) == 15){
					System.out.println(minutesMap.get(fullHour - minutes).toLowerCase()+" to "+hourMap.get(hour + 1));
				}else{
					System.out.println(minutesMap.get(fullHour - minutes).toLowerCase()+" minutes to "+hourMap.get(hour+1));
				}
			}else if(minutes < 30 && minutes > 0){
				if(minutes == 1){
					System.out.println(minutesMap.get(minutes).toLowerCase()+" minute past "+hourMap.get(hour));
				}else if(minutes == 15){
					System.out.println(minutesMap.get(minutes).toLowerCase()+" past "+hourMap.get(hour));
				}else{
					System.out.println(minutesMap.get(minutes).toLowerCase()+" minutes past "+hourMap.get(hour));
				}
			}else if(minutes == 30){
				System.out.println(minutesMap.get(minutes).toLowerCase()+" past "+hourMap.get(hour));
			}
		}
		input.close();

	}

	public static void initializeMaps(){

		hourMap = new HashMap<Integer,String>();
		minutesMap = new HashMap<Integer,String>();

		hourMap.put(1, "one");hourMap.put(2, "two");hourMap.put(3, "three");hourMap.put(4, "four");hourMap.put(5, "five");
		hourMap.put(6, "six");hourMap.put(7, "seven");hourMap.put(8, "eight");hourMap.put(9, "nine");hourMap.put(10, "ten");
		hourMap.put(11, "eleven");hourMap.put(12, "twelve");

		minutesMap.put(1, "one");minutesMap.put(2, "two");minutesMap.put(3, "three");minutesMap.put(4, "four");minutesMap.put(5, "five");
		minutesMap.put(6, "six");minutesMap.put(7, "seven");minutesMap.put(8, "eight");minutesMap.put(9, "nine");minutesMap.put(10, "ten");
		minutesMap.put(11, "eleven");minutesMap.put(12, "twelve");

		minutesMap.put(13, "Thirteen");minutesMap.put(14, "Fourteen");minutesMap.put(15, "quarter");minutesMap.put(16, "Sixteen");minutesMap.put(17, "Seventeen");
		minutesMap.put(18, "Eighteen");minutesMap.put(19, "Nineteen");minutesMap.put(20, "Twenty");minutesMap.put(21, "Twenty One");minutesMap.put(22, "Twenty Two");
		minutesMap.put(23, "Twenty Three");minutesMap.put(24, "Twenty Four");

		minutesMap.put(25, "Twenty Five");minutesMap.put(26, "Twenty Six");minutesMap.put(27, "Twenty Seven");minutesMap.put(28, "Twenty Eight");
		minutesMap.put(29, "Twenty Nine");
		minutesMap.put(30, "half");  minutesMap.put(45, "quarter");  
	}

}
