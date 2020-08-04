import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
 

public class CharacterCount {

	public static void main(String[] args) {
		File file = new File(args[0]);
		String line = "", fullText = "";
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			while ((line = buffer.readLine()) != null){
				fullText = fullText + line.replace(" ","");
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("LENGTH : "+fullText.length());
		 
	}

}
