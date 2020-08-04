package CodeEvalModerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ArrayAbsurdity {

	public static void main(String[] args) {

		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.length() > 0)) {
				findDuplicates(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void findDuplicates(String series){
		int size = Integer.parseInt(series.split(";")[0]);
		ArrayList<String> numList = new ArrayList<String>();
		String[] nums = (series.split(";")[1]).split(",");
		
		if(nums.length == size){
			for(int i = 0 ; i < nums.length ; i++){
				if(numList.contains(nums[i])){
					System.out.println(nums[i]);
				}else{
					numList.add(nums[i]);
				}
			}
		}
	}
}
