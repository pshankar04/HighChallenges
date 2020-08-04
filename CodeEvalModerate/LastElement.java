package CodeEvalModerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LastElement {

	public static void main(String[] args) {

		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.length() > 0)) {
				findLastElement(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void findLastElement(String series){

		String[] nums = series.split(" ");
		int index = Integer.parseInt(nums[nums.length - 1]);
		if(nums.length > index){
			index = nums.length - index;
			for(int i = nums.length - 1 ; i>=0 ; i--){
				if(i == index -1){
					System.out.println(nums[i]);
					break;
				}
			}
		}
	}
}
