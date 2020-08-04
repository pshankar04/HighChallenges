package Serials;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import javax.naming.BinaryRefAddr;

public class Test1 {


	public static void main(String[] args) {
		//		String input = "";
		//		String hex = "%5B%5E%27%3E%7E%7D%29%7D%7D";
		//		for(int i = 0 ; i< hex.length() ; i+=3){
		//		input = hex.substring(i+1,i+3);		
		//		int asciiValue = Integer.parseInt(input,16);
		//		System.out.print((char)asciiValue);
		//		}
		//		long i = 2;
		//		for(int l = 0 ; l < 33 ; l++){
		//			i = i * 2;
		//		}1834423448

		//		String email = "A@b@c@example.com";
		//		String adTemplate = email.substring(email.lastIndexOf('@')+1,email.lastIndexOf('.'));
		//		String afterDot = email.substring(email.lastIndexOf('.')+1);
		//		System.out.println(adTemplate+"   "+afterDot);
		//		if( (adTemplate.length() >= 1) && (!afterDot.matches("[^a-z]"))){
		//			System.out.println("true");
		//		}else{
		//			System.out.println("false");
		//		}
		
		System.out.println(reduceDigits(32.3,2));

		int[] nums1 = {9,9,2}; 
		int[] nums2 = {0,1,3}; 
		int[] nums3 ;
		if(nums1.length > nums2.length){
			nums3 = new int[nums1.length];
		}else{
			nums3 = new int[nums2.length];
		}

		int j = nums1.length - 1;
		int k = nums2.length - 1;
		int one = 0 , two = 0 , carryOver = 0 ,sum = 0;
		for(int i = nums3.length - 1 ; i >= 0 ; i--){
			if(j < 0 ){
				one = 0;
				two = nums2[k];
			}else if(k < 0){
				two = 0;
				one = nums1[j];
			}else{
				one = nums1[j];
				two = nums2[k];
			}

			if(String.valueOf(one + two).length() > 1){
				sum = carryOver + one + two;
				carryOver = Integer.parseInt((String.valueOf(sum)).charAt(0)+"");
				nums3[i] = Integer.parseInt((String.valueOf(sum)).charAt(1)+"");

			}else{
				nums3[i] = carryOver + one + two;
			}
			j--;k--;
		}
		String result = "";
		for(int i = 0; i < nums3.length ; i++){
			if(String.valueOf(nums3[i]).length() > 1){
				result = result + String.valueOf(nums3[i]).charAt(0)+","+String.valueOf(nums3[i]).charAt(1)+",";
			}else{
				result = result + nums3[i]+",";
			}
		}
		result = new String(new StringBuffer(result).deleteCharAt(result.length() - 1));
		System.out.println(result);
	}

	public static int findDuplicate(int[] input) {

		HashSet<Integer> hashSet = new HashSet<>();
		for(int item : input) {
			if(hashSet.contains(item)) {
				return item;
			}
			hashSet.add(item);
		}
		// throw new NoSuchElementException("No duplicate found");
		return 0;
	}


	public static String removeComma(String word){
		return new String(new StringBuilder(word).deleteCharAt(word.length() - 1));
	}

	public static int binaryToInteger(String binary) {
		char[] numbers = binary.toCharArray();
		int result = 0;
		for(int i=numbers.length - 1; i>=0; i--)
			if(numbers[i]=='1')
				result += Math.pow(2, (numbers.length-i - 1));
		return result;
	}

	public static boolean isAlpha(String name) {
		return name.matches("[a-zA-Z]+");
	}

	public static float reduceDigits(double pNumero, int pCantidadDecimales) {
		BigDecimal value = new BigDecimal(pNumero);
		value = value.setScale(pCantidadDecimales, BigDecimal.ROUND_HALF_EVEN); // here the value is correct (625.30)
		return value.floatValue(); // but here the values is 625.3
	}






}
