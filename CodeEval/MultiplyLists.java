package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
 
public class MultiplyLists {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				multiplyList(line);
				System.out.println();
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void multiplyList(String numbers){
		
		String[] list1 = (numbers.split(" \\| ")[0]).split(" ");
		String[] list2 = (numbers.split(" \\| ")[1]).split(" ");
		String[] result = new String[list1.length];
		 
		for(int i = 0 ; i< list1.length ; i++){
			result[i] = String.valueOf((Integer.parseInt(list1[i])) * (Integer.parseInt(list2[i])));
		}
		
		for(String str : result){
			System.out.print(str+" ");
		}
	}

}
