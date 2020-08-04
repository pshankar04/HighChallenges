package HackerRank_Domains;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CheckResult {

	public static void main(String[] args) {
		 
		File output = new File("/Users/puneethshankar/Desktop/test.txt");
		 
		
		try{
			BufferedReader buffer1 = new BufferedReader(new FileReader(output));
			 
			String line1;
			int count = 1;
			while (((line1 = buffer1.readLine()) != null)){
				if(count == 313 || count == 549){
					System.out.println(line1);
				}
				count++;
			}
			buffer1.close();
			 
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
