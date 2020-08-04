package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class NiceAngles {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				findAngles(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	public static void findAngles(String number){
		 
		int wholePart =  Integer.parseInt(number.split("\\.")[0]);
		double fractionalPart = Double.parseDouble("0."+(number.split("\\.")[1]));
		double midPart = fractionalPart * 60;
		String mid = (String.valueOf(midPart)).substring(0, (String.valueOf(midPart)).indexOf('.'));
		double lastPart = Double.parseDouble("0."+(String.valueOf(midPart)).substring((String.valueOf(midPart)).indexOf('.')+1));
		lastPart = lastPart * 60 ;
		String last = (String.valueOf(lastPart)).substring(0, (String.valueOf(lastPart)).indexOf('.'));
		System.out.println(wholePart+"."+reSize(mid)+"'"+reSize(last)+"\"");
	}
	
	public static String reSize(String data){
		return (data.length() == 1) ? ("0" + data) : data;
	}
}
