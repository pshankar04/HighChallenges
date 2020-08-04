

import java.util.LinkedHashSet;
import java.util.Scanner;

public class ODUTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String sample1 = input.nextLine().toLowerCase();
		String sample2 = input.nextLine().toLowerCase();
		String sample3 = input.nextLine().toLowerCase();

		int nonDuplicates = compareAndErase(sample1,sample2);
		System.out.println(nonDuplicates);

		if(sample3.length() > 0){
			deleteCircularly(nonDuplicates,sample3);
		}
		input.close();
	}

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
		System.out.println(countedCharacterSet);
		return total - (countedCharacterSet.size() * 2);
	}

	public static void deleteCircularly(int count,String str){

		count = count - 1;
		int index = count - 1;
		String finalString = str;
		finalString = finalString.substring(0,count).concat(finalString.substring(count + 1));
		System.out.println("Before :"+finalString);
		
		while(finalString.length() != 1){
			finalString = finalString.substring(count).concat(finalString.substring(0,index));
			//count = finalString.length() % count;
			index = finalString.length() / count;
			System.out.println(finalString+":::"+index);
		}
	}

}
