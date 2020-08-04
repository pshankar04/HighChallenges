package Serials;


 

public class ArrayClone {
	public static void main(String[] args) {
		System.out.println(fact(2));
		
	}
	
	public static int fact(int n){
		if(n>1){
			return fact(n-1) * n;
		}
		else{
			return 1;
		}
	}



}
