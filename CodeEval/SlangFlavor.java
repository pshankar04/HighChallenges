package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class SlangFlavor {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				replaceSlang(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void replaceSlang(String sentence){
		
		if(sentence.contains(".")  && sentence.lastIndexOf('.') != sentence.length() - 1){
			sentence = new String(new StringBuilder(sentence).replace(sentence.lastIndexOf('.'), sentence.lastIndexOf('.')+1, ", yeah!"));
		}if(sentence.contains("?")  && sentence.lastIndexOf('?') != sentence.length() - 1){
			sentence = new String(new StringBuilder(sentence).replace(sentence.lastIndexOf('?'), sentence.lastIndexOf('?')+1, ", this is crazy, I tell ya."));
		}if(sentence.contains(".")  && sentence.lastIndexOf('.') == sentence.length() - 1){
			sentence = new String(new StringBuilder(sentence).replace(sentence.lastIndexOf('.'), sentence.lastIndexOf('.')+1, ", can U believe this?"));
		}if( sentence.contains(".")  && sentence.indexOf('.') == sentence.length() - 1){
			sentence = new String(new StringBuilder(sentence).replace(sentence.lastIndexOf('.'), sentence.lastIndexOf('.')+1, ", yo."));
		}
		System.out.println(sentence);
	}
}
