package CodeEvalModerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class JollyJumpers {

	public static ArrayList<Integer> numList ; 
	public static int count = 0;
	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;

			while ((line = buffer.readLine()) != null) {
				isAJollyJumper(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public static void isAJollyJumper(String num){
		String[] numbers = num.split(" ");
		count = Integer.parseInt(numbers[0]);
		int[] nums = new int[count];
		if(count == numbers.length -1){
			nums = saveNow(numbers,nums);
			findJollyness(nums);
		}

	}

	public static int[] saveNow(String[] nums,int[] ints){
		for(int i = 1 ; i < nums.length ; i++){
			ints[i-1] = Integer.parseInt(nums[i]);
		}
		return ints;
	}

	public static void findJollyness(int[] ints){
		boolean isJolly = true;
		numList = new ArrayList<Integer>();
		int diff = 0; 
		for(int k = 0 ; k < ints.length ; k++){
			if(k == ints.length - 1){
				break;
			}else{
				diff = Math.abs(ints[k] - ints[k+1]);
			}
			numList.add(diff);
		}
		
		for(int k = 1 ; k < count ; k++){
			if(!numList.contains(k)){
				isJolly = false;
				break;
			}
		}
		if(isJolly){
			System.out.println("Jolly");
		}else{
			System.out.println("Not jolly");
		}
	}
}
