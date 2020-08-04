package HackerRank;

import java.util.HashSet;
import java.util.Scanner;

public class NonDivisibleSubset {
	public static HashSet<String> subSet = new HashSet<String>();
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String data = input.nextLine();
		int k = Integer.parseInt(data.split(" ")[1]);
		String[] nums = input.nextLine().split(" ");
		String temp = "";
		for(String s : nums){
			temp = temp + s;
		}
		for(int i = 0; i < temp.length() ; i++){ 
			formSubstring(temp,"",i) ;
		}
		findOptimalLength(k);

		input.close();
	}

	public static void findOptimalLength(int div){
		int count = 0 , maxLength = 0 ,maxStrLength = 0;
		long[] nums ;
		for(String s : subSet){
			if(s.length() > maxStrLength){
				nums = new long[s.length()];
				for(int i = 0 ; i < nums.length ; i++){
					nums[i] = Integer.parseInt(s.charAt(i)+"");
				}
				for(int i = 0 ; i < nums.length ; i++){
					for(int j = 0 ; j < nums.length ; j++){
						if(((nums[i] + nums[j]) % div) == 0){
							count++;
						}
					}
				}
				if(count == 0){
					if(s.length() > maxLength){
						maxLength = s.length();
						maxStrLength = s.length();
					}
				}
				count = 0;
			}
		}
		System.out.println(maxLength);
	}

	public static void formSubstring(String str , String substr,int index)
	{
		String s = ""+str.charAt(index);  
		s = substr+s;  
		subSet.add(s);   

		for(int i=index+1;i<str.length();i++)
			formSubstring(str,s,i);  

	}
}
