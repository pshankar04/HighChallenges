package HackerRank;

import java.util.Scanner;

public class StandardOutput {
	    public static void main(String[] args) {
	            Scanner str = new Scanner(System.in);
	            Scanner doub = new Scanner(System.in);
	            Scanner inti = new Scanner(System.in);
	           
	            long a = inti.nextInt();
	            Double d = doub.nextDouble();
	            String x = str.nextLine();
	            

	            System.out.println("String: "+x);
	            System.out.println("Double: "+d);
	            System.out.println("Int: "+a);
	        
	        str.close();
	        doub.close();
	        inti.close();
	    }
	}
