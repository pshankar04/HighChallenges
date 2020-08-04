package HackerRank;

 
import java.util.LinkedList;
import java.util.Scanner;

public class SuperPythaTriplets {

	public static void main(String[] args) {
		int number = 0;
		LinkedList<Integer> numList = new LinkedList<Integer>();
		Scanner input = new Scanner(System.in);
		int tc = Integer.parseInt(input.nextLine());
		if(tc >= 1 || tc <= 3000){
			for(int i = 0 ; i < tc ; i++){
				number = Integer.parseInt(input.nextLine());
				if(number >= 1 || number <= 3000){
					numList.add(number);
				}
			}
			for(Integer num : numList){
				findMaxTriplets(num);
			}
		}
		input.close();
	}

	public static void findMaxTriplets(int number){
		long max = -1l;
		int i = 1 , j = 1;
		
		for(int k = 1 ; k <= (number/3); k++){
			  j = ((number - k) + ((k * k)/(k - number)))/2;
	          i = ((number - k) - ((k * k)/(k - number)))/2;
	          if((i == StrictMath.hypot(k, j)) && (sum(i,j,k) == number)){
	        	  if( (i * j * k) > max){
	        		  max = (i * j * k) ;
	        	  }
	          }
		}
		System.out.println(max);
	}

	public static int sum(int a , int b ,int c){
		return (a+b+c);
	}

	public static boolean isTriplet(int a , int b , int c){
		if((c * c) == ((a * a) + (b * b))){
			return true;
		}else{
			return false;
		}
	}
}



