package CodeEvalModerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class CycleDetection {

	public static LinkedHashMap<String,String> cycleMap ;
	public static int cycleDiff = 0;
	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;

			while ((line = buffer.readLine()) != null) {
				detectCycle(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void detectCycle(String series){
		cycleMap = new LinkedHashMap<String,String>();
		String[] chars = series.split(" ");

		for(int i = 0 ; i < chars.length ; i++){
			if(cycleMap.containsKey(chars[i]+"")){
				cycleMap.put(chars[i]+"",  cycleMap.get(chars[i]+"")+","+i+"");
			}else{
				cycleMap.put(chars[i]+"",i+"");
			}
		}
		 
		findCycles(cycleMap);
	}

	public static void findCycles(LinkedHashMap<String,String> cyclesMap){
		String key = "" , value = "" , cycleKeys = "";
		Set<Map.Entry<String,String>> entrySet = cyclesMap.entrySet();
		for(Map.Entry<String, String> entry : entrySet){
			key = entry.getKey() ; value = entry.getValue();
			if(value.contains(",") && (diffIsEven(value))){
				cycleKeys = cycleKeys + key +" ";
			}
		}
		System.out.println(cycleKeys.trim());
	}

	public static boolean diffIsEven(String mapValue){
		String[] diffs = mapValue.split(",");
		boolean diffStatus = true;
		int diff = 0 ;
		for(int i = 0 ; i < diffs.length - 1 ; i++){
			if(i == 0){
				diff = Integer.parseInt(diffs[i]) - Integer.parseInt(diffs[i+1]);
				cycleDiff = diff;
			}else{
				diff = Integer.parseInt(diffs[i]) - Integer.parseInt(diffs[i+1]);
				if(diff != cycleDiff){
					diffStatus = false;
					return diffStatus;
				}
			}
		}
		return diffStatus;
	}
}
