package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class NotSoClever {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				 list.add(line);
			}
			buffer.close();

		}catch(Exception e){
			e.printStackTrace();
		}
		 
		for(String item : list){
			System.out.println(sortNow(item,new String()));
		}
	}

	public static String sortNow(String value,String result){
		 
		String[] contents = value.split(" \\| ");
		int iterations = Integer.parseInt(contents[1]);
		String[] nums = contents[0].split(" ");
		int[] numbers = new int[nums.length];
		for(int i = 0 ; i< nums.length ; i++){
			numbers[i] = Integer.parseInt(nums[i].trim());
		}
		int temp;
		for(int a = 0 ; a < iterations ; a++){
			if(numbers[a] > numbers[a+1]){
				temp = numbers[a];
				numbers[a] = numbers[a+1];
				numbers[a+1] = temp;
			}else{
				continue;
			}

		}
		for(int i = 0 ; i< numbers.length ; i++){
			result = result + numbers[i]+ " ";
		}
		return result.trim();

	}

}
