package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MajorElement {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				findMajorElement(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void findMajorElement(String elements){
		int count = 1;
		String result = "None";
		HashMap<Integer,Integer> countMap = new HashMap<Integer,Integer>();
		String[] nums = elements.split(",");
		for(int i = 0 ; i < nums.length ;i++){
			if(!countMap.containsKey(Integer.parseInt(nums[i]))){
				countMap.put(Integer.parseInt(nums[i]), count);
			}else{
				countMap.put(Integer.parseInt(nums[i]), countMap.get(Integer.parseInt(nums[i])) + 1);
			}
		}
		Set<Map.Entry<Integer,Integer>> entrySet = countMap.entrySet();
		for(Map.Entry<Integer, Integer> entry : entrySet){
			if(entry.getValue() > (nums.length/2)){
				result = String.valueOf(entry.getKey());
				break;
			}else{
				result = "None";
			}
		}
		System.out.println(result);
	}

}
