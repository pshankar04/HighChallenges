package TestRun;

import java.util.Scanner;

public class CheckCharacterSwap {
	public static boolean isEqual = false;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s1 = in.nextLine();
		String s2 = in.nextLine();
		boolean isEqual = false;
		int index1 = 0,index2 = 0;
		int count = 0;

		if(s1.length() != s2.length()){
			isEqual = false;
		}else if(s1.equals(s2)){
			isEqual = true;
		}else{
			for(int i = 0 ; i < s1.length() ;i++){
				if(s1.charAt(i) == s2.charAt(i)){
					continue;
				}else{
					count = count + 1;
					if(count == 1){
						index1 = i;
					}else if(count == 2){
						index2 = i;
					}else if(count > 2){
						isEqual = false;
						break;
					}else{
						//System.out.println("FALSE");
						isEqual = false;
						break;
					}
				}
			}
		}
		verifyEquality(s1,s2,index1,index2);
		

	}
	
	public static void verifyEquality(String str1,String str2,int pos1,int pos2){
		System.out.println(pos1+":"+pos2);
		System.out.println("STR1:"+str1+": STR2:"+str2);
		
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		char[] mStr1 = str1.toCharArray();
		char[] mStr2 = str2.toCharArray();
		
		mStr1[pos1] = str1.charAt(pos2);
		mStr1[pos2] = str1.charAt(pos1);
		
		mStr2[pos1] = str2.charAt(pos2);
		mStr2[pos2] = str2.charAt(pos1);
		
		for(int i = 0 ; i < mStr1.length ; i++){
			sb1 = sb1.append(mStr1[i]);
			sb2 = sb2.append(mStr2[i]);
		}
		
		System.out.println("SB1:  "+sb1);
		System.out.println("SB2:  "+sb2);
		
		String newStr = new String(sb1);
		if(newStr.equals(str2.trim())){
//			System.out.println("True");
			isEqual = true;
		}
		System.out.println(isEqual);
		
	}

}
