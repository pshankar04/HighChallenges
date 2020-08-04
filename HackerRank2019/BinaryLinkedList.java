package HackerRank;

import java.util.Scanner;

public class BinaryLinkedList {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println(getDecimalFromBinary(input.nextInt()));
		input.close();

	}

	public static int getDecimalFromBinary(int binary){
        
        int decimal = 0;
        int power = 0;
        while(true){
            if(binary == 0){
                break;
            } else {
                int tmp = binary%10;
                decimal += tmp*Math.pow(2, power);
                binary = binary/10;
                power++;
            }
        }
        return decimal;
    }
}
