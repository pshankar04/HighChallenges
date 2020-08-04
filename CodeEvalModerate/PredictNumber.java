package CodeEvalModerate;

/**
 * PARTIAL
 * https://www.codeeval.com/open_challenges/125/ 
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class PredictNumber {
	public static HashMap<String,String> numMap ; 
	public static String number = "0112122012202001";
	public static int count = 0;
	public static String finalNumber = "" ,temp = "";
	public static ArrayList<String> numList ; 

	static{
		numList = new ArrayList<String>();
		numMap  = new HashMap<String,String>();
		numMap.put("0","1");
		numMap.put("1","2");
		numMap.put("2","0");
		numList.add(number);
	}
	public static void main(String[] args) {

		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			int totalCount = 0;
			while ((line = buffer.readLine()) != null && (line.length() > 0) && (totalCount < 40)) {
				if((Long.parseLong(line) >= 0) &&  (Long.parseLong(line) <= 3000000000L)){
				predictNow(line);
				}else{
					System.out.println("0");
				}
				totalCount++;
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public static void appendStrings(){

		for(String s : numList){
			temp = temp + s; 
		}
	}

	public static void predictNow(String indexInput){

		long index = Long.parseLong(indexInput);
		Long highest = 3000000000L;
		if((index >= 0) &&  (index <= highest)){
			while(count <  2){
				finalNumber = replaceNumber(number);
				numList.add(finalNumber);
				number = finalNumber;
				count++;

			}

			appendStrings();
			if(index <= 48){
				System.out.println(temp.charAt((int)index));
			}else{
				while((index = (index / 48)) > 48){
					index = index / 48;
					if(index < 48){
						break;
					}
				}
				System.out.println(temp.charAt((int)index));
			}
		}
	}

	public static String replaceNumber(String num){
		String tempo = "";
		for(int  i = 0 ; i < num.length() ; i++){
			tempo = tempo + numMap.get(num.charAt(i)+"");
		}
		return tempo;
	}
}
