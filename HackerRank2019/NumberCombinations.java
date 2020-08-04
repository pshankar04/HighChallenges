package HackerRank;

import java.util.ArrayList;
import java.util.Scanner;

public class NumberCombinations {
	public static ArrayList<String> numList = new ArrayList<String>();
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int number = Integer.parseInt(input.nextLine());
		System.out.println(arrangements(number));
		input.close();
	}

	public static int arrangements(int num){
		int[] nums = new int[num];
		int count = 0,total = 0;
		String[] numArray ;
		for(int i = 0 ; i < num ; i++){
			nums[i] = i+1;
		}
		permute(nums,0);
		
		for(String s : numList){
			s = removeComma(s);
			numArray = s.split(",");
			for(int j = 0 ; j < numArray.length ;j++){
				if((Integer.parseInt(numArray[j]) % (j+1) == 0) && ((j+1) % (Integer.parseInt(numArray[j])) == 0)){
					count++;
				}
			}
			if(count == numArray.length){
				total++;
			}
			count = 0;
		}
		return total;
	}
	
	public static String removeComma(String str){
	
		return new String(new StringBuilder(str).deleteCharAt(str.length()-1));
	}
	
	public static void permute(int[] a, int k) 
    {
		String list = "";
        if (k == a.length) 
        {
            for (int i = 0; i < a.length; i++) 
            {
            	list = list + a[i]+ ",";
            }
             numList.add(list);
             list = "";
        } 
        else 
        {
            for (int i = k; i < a.length; i++) 
            {
                int temp = a[k];
                a[k] = a[i];
                a[i] = temp;
 
                permute(a, k + 1);
 
                temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
        }
    }
}
