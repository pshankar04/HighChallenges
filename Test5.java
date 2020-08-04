import java.util.LinkedHashSet;
import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String sample1 = input.nextLine().toLowerCase();
		String sample2 = input.nextLine().toLowerCase();
		String sample3 = input.nextLine().toLowerCase();
		int nonDuplicates = compareAndErase(sample1,sample2);
		System.out.println("Total Characters :: "+nonDuplicates);

		if(sample3.length() > 0){
			deleteCircularly(nonDuplicates,sample3);
		}
		input.close();

	}

	/**
	 * Determines the total unique characters between two input Strings
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static int compareAndErase(String str1, String str2){
		LinkedHashSet<String> countedCharacterSet = new LinkedHashSet<String>();
		int total = str1.length() + str2.length();
		for(int i = 0 ; i < str1.length(); i++){
			for(int j = 0 ; j < str2.length() ; j++){
				if(str1.charAt(i) == str2.charAt(j) && countedCharacterSet.size() != 0 && !countedCharacterSet.contains(str2.charAt(j))){
					countedCharacterSet.add(str1.charAt(i)+"");
					break;
				}else if(str1.charAt(i) == str2.charAt(j) && countedCharacterSet.size() == 0){
					countedCharacterSet.add(str1.charAt(i)+"");
				}
			}
		}
		return total - (countedCharacterSet.size() * 2);
	}

	/**
	 * Deletes the characters circularly over the string 
	 * @param count
	 * @param str
	 */

	public static void deleteCircularly(int count,String str){

		int index = 0; 
		String finalString = str;

		System.out.println("Input String is :"+finalString);

		while(finalString.length() != 1){
			index = (count % finalString.length());
			if(index == 0){
				if(count == finalString.length()){
					index = count - 1;
					finalString = finalString.substring(0,index);
					System.out.println(finalString);
				}else{
					index = finalString.length() - 1;
					finalString = finalString.substring(0,index);
					System.out.println(finalString);
				}
			}else{
				finalString = finalString.substring(index).concat(finalString.substring(0,index - 1));
				System.out.println(finalString);
			}
		}

	}
}
