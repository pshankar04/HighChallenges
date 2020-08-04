package HackerRank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileContentChecking {

	public static void main(String[] args) {

		BufferedReader br1 = null;
		BufferedReader br2 = null;

		try {

			String answerLine = "" , testLine = "";
			int lineNumber = 1;
			while(lineNumber <= 629){
				br1 = new BufferedReader(new FileReader("/Users/puneethshankar/Desktop/Answer.txt"));
				br2 = new BufferedReader(new FileReader("/Users/puneethshankar/Desktop/test.txt"));

				if (((answerLine = br1.readLine()) != null) && ((testLine = br2.readLine()) != null) && (answerLine.equals(testLine))){
					lineNumber++;
				}else{
					System.out.println(lineNumber);
					lineNumber++;
				}
			}
			System.out.println("LAST :"+lineNumber);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br1 != null)br1.close();
				if (br2 != null)br2.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

}
