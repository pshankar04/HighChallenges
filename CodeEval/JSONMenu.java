package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class JSONMenu {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				captureIds(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void captureIds(String json){
		json = json.substring(json.indexOf('[')+1,json.lastIndexOf(']')).trim();
		String[] jsonObjects = json.split("id");
		int sum = 0;
		for(int i = 0 ; i < jsonObjects.length ; i++){
			if(jsonObjects[i].contains("Label")){
				sum = sum + Integer.parseInt(jsonObjects[i].substring(jsonObjects[i].indexOf("Label") + 6, jsonObjects[i].lastIndexOf('}') - 1));
			}
		}
		System.out.println(sum);
	}
}
