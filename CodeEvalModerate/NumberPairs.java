package CodeEvalModerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class NumberPairs {

	public static ArrayList<String> pairList;
	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			int count = 0;
			while ((line = buffer.readLine()) != null && (line.length() > 0) && (line.contains(";")) && (count < 40)) {
				findPairs(line);
				count++;
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void findPairs(String series){
		String sumString = "";
		pairList = new ArrayList<String>();
		String[] numbers = (series.split(";")[0]).split(",");
		int sum = Integer.parseInt(series.split(";")[1]);
		int eachSum = 0;
		int[] nums = new int[numbers.length];

		for(int i = 0 ; i < numbers.length ; i++){
			nums[i] = Integer.parseInt(numbers[i]);
		}

		for(int k = 0 ; k < nums.length ; k++){
			for(int j = k+1 ; j < nums.length ; j++){
				eachSum = eachSum + nums[k] + nums[j];
				if((eachSum == sum) && (!pairList.contains(nums[k]+","+nums[j])) && (!pairList.contains(nums[j]+","+nums[k]))){
					pairList.add(nums[k]+","+nums[j]);
				}
				eachSum = 0;
			}
		}

		for(String pair : pairList){
			sumString = sumString + pair + ";";
		}
		if(pairList.size() >= 1){
			sumString = new String((new StringBuffer(sumString)).deleteCharAt(sumString.length() - 1));
			System.out.println(sumString);
		}else{
			System.out.println("NULL");
		}
	}
}
