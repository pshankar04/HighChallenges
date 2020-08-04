package CodeEvalModerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ChainInspection {
	public static HashMap<String,String> chainMap;
	public static int beginCount = 0 , endCount = 0;
	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			int count = 0;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0) && count < 40) {
				if((line.contains("BEGIN") && line.contains("END"))){
					findChain(line);
					//System.out.println(line);
				}else{
					System.out.println("BAD");
				}
				count++;
			}

			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void findChain(String chain){
		String[] chains = chain.split(";");
		saveChains(chains);
		if(chain.equals("BEGIN-END")){
			System.out.println("GOOD");
		}else if((beginCount == 1) && (endCount == 1) && (findCompleteChain(chainMap,chains.length))){
			System.out.println("GOOD");
		}else{
			System.out.println("BAD");
		}
		beginCount = 0 ; endCount = 0;
	}

	public static void saveChains(String[] chain){
		chainMap = new HashMap<String,String>();
		for(int i = 0 ; i < chain.length ; i++){
			if((chain[i].split("-")[0]).equals("BEGIN")){
				beginCount++;
			}else if((chain[i].split("-")[1]).equals("END")){
				endCount++;
			}
			chainMap.put((chain[i]).split("-")[0],(chain[i]).split("-")[1]);
		}
	}

	public static boolean findCompleteChain(HashMap<String,String> chainMap, int chainLength){

		int count = 0;
		String key = "" , value = "" , beginAddress = "" ;
		boolean beginFound = true , endFound = false;
		while((count < chainLength) && !(endFound)){
			Set<Map.Entry<String,String>> entrySet = chainMap.entrySet();
			for(Map.Entry<String, String> entry : entrySet){
				key = entry.getKey();
				value = entry.getValue();
				if(key.equals("BEGIN") && beginFound){
					beginAddress = value;
					count++;
					beginFound = false;
					break;
				}
				else if(key.equals(beginAddress) && !(value.equals("END"))){
					beginAddress = value;
					count++;
					break;
				}
				else if(key.equals(beginAddress) && (value.equals("END"))){
					count++;
					endFound = true;
					break;
				}else{
					continue;
				}
			}
		}

		if((endFound) && (count == chainLength)){
			return true;
		}else{
			return false;
		}
	}

}
