package HackerEarth;

import java.util.LinkedList;
import java.util.Scanner;

public class AkashGCD {
	public static LinkedList<Long> resultList = new LinkedList<Long>(); 
	public static LinkedList<String> queryList = new LinkedList<String>();
	public static String[] numbers;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int totalNumbers = Integer.parseInt(input.nextLine());
		numbers = new String[totalNumbers];
		numbers = (input.nextLine()).split(" ");
		long queryCount = Long.parseLong(input.nextLine());
		
		for(int i = 0 ; i < queryCount ; i++){
			queryList.add(input.nextLine());
		}
		
		for(String query : queryList){
			if(query.contains("C")){
				executeQuery(numbers,query);
			}else if(query.contains("U")){
				updateArray(query);
			}
		}
		
		for(Long i : resultList){
			System.out.println(i);
		}
		input.close();
	}

	public static void executeQuery(String[] nums , String exp){

		int X = Integer.parseInt(exp.split(" ")[1]);
		int Y = Integer.parseInt(exp.split(" ")[2]);
		long sumOfGcd = 0 ;
		int gcdNumber = X;
		 
		while(gcdNumber <= Y){
			sumOfGcd = sumOfGcd + functionGCD(Long.parseLong(nums[(gcdNumber - 1)]));
			gcdNumber++;
		}
		resultList.add(sumOfGcd);
	}

	public static void updateArray(String exp){
		int index = Integer.parseInt(exp.split(" ")[1]) - 1;
		int item = Integer.parseInt(exp.split(" ")[2]);
		
		for(int i = 0 ; i < numbers.length ; i++){
			if(i == index){
				numbers[i] = String.valueOf(item);
			}
		}
		 
	}

	public static long functionGCD(long num){
		long sum = 0;
		for(int i = 1 ; i <= num ; i++){
			sum = sum + findGCD(i,num);
		}
		return sum;
	}


	public static long findGCD(long num1 , long num2){
		
		while(num1 != num2)
        {
            if(num1 > num2)
                num1 = num1-num2;
            else
                num2 = num2-num1;
        }
		return num1;
	}
}
