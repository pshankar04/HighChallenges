package CodeEval;

import java.io.File;
 
public class LengthInBytes {
	public static void main(String[] args) {
		File file = new File(args[0]);
		System.out.println(file.length());

	}

}
