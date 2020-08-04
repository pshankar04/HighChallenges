package CodeEvalModerate;
/**
 * PARTIAL
 * https://www.codeeval.com/open_challenges/81/
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
 
public class ZeroSum {

	public static void main(String[] args) {

		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.length() > 0)) {
				findSeries(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
 
	public static void findSeries(String set){
		String[] numbers = set.split(",");
		int sum = 0;
		if(numbers.length > 4){
			numbers = doubleTheLength(numbers);
			checkTheCount(numbers);
		}else{
			for(int i = 0 ; i < numbers.length ; i++){
				sum = sum + Integer.parseInt(numbers[i]);
			}
			if(sum == 0){
				System.out.println(1);
			}
		}
	}

	public static void checkTheCount(String[] nums){
		int sum = 0 , i = 0, count = 0 , j = 0;

		while(i < (nums.length/2)){
			for(j = i ; j < (i+4) ; j++){
				sum = sum + Integer.parseInt(nums[j]);
			}
			if(sum == 0){
				count++;
			}
			sum = 0;
			i++;
		}
		System.out.println(count);
	}
	public static String[] doubleTheLength(String[] str){

		String[] newStr = new String[2 * str.length];
		ArrayList<String> list = new ArrayList<String>();

		while(list.size() < 2 * str.length){
			for(int i = 0 ; i < str.length ; i++){
				list.add(str[i]);
			}
		}

		for(int j = 0 ; j < list.size() ; j++){
			newStr[j] = list.get(j);
		}

		return newStr;
	}
}
