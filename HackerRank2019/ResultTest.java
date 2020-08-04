package HackerRank_Domains;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ResultTest {

	public static void main(String[] args) {
		 
		File output = new File("/Users/puneethshankar/Desktop/output.txt");
		File tested = new File("/Users/puneethshankar/Desktop/tested.txt");
		
		try{
			BufferedReader buffer1 = new BufferedReader(new FileReader(output));
			BufferedReader buffer2 = new BufferedReader(new FileReader(tested));
			String line1 , line2;
			int count = 1;
			while (((line1 = buffer1.readLine()) != null) && ((line2 = buffer2.readLine()) != null)){
				if(!line1.equals(line2)){
					System.out.println(count);
				}
				count++;
			}
			System.out.println("DONE");
			buffer1.close();
			buffer2.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
