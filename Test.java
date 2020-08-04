import java.util.LinkedHashSet;
import java.util.Scanner;

public class Test {

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

		int index = 0; 

		if(count < str.length()){
			index = count - 1;
		}else{
			index = (count % str.length()) - 1;
		}
		String finalString = str;
		//
		finalString = finalString.substring(index + 1).concat(finalString.substring(0,index));
		System.out.println("Before :"+finalString+":::"+index);

		while(finalString.length() != 1){
			if(count == finalString.length()){
				index = (index % finalString.length());
				finalString = finalString.substring(0,index);
				System.out.println("1 :"+finalString+":::"+index);
			}
			else if(count < finalString.length()){
				index = (count % finalString.length()) - 1;
				finalString = finalString.substring(index + 1).concat(finalString.substring(0,index));
				System.out.println("2 :"+finalString+":::"+index);
			}else if(count > finalString.length()){
				index = (count % finalString.length()) - 1;
				finalString = finalString.substring(index + 1);
				System.out.println("3 :"+finalString+":::"+index);
			}
		}

	}
}
