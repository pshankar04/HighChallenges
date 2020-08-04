package HackerRank;

import java.util.Scanner;

public class QuoteArbitrage {
	    public static void main(String[] args) {
	        Scanner scanny = new Scanner(System.in);
	        int n = scanny.nextInt();
	        while(n-->0){
	            double profit =  100000 / scanny.nextDouble() / scanny.nextDouble() / scanny.nextDouble() - 100000;
	            if(profit>0){
	                System.out.println(Math.floor(((profit * 100) / 100)));
	            }else {
	                System.out.println('0');
	            }
	        }
	        scanny.close();
	    }
	}
