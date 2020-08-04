package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Calendar;


public class DeltaTime {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				findTimeDifference(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static  void findTimeDifference(String times){

		String start = times.split(" ")[0];
		String end = times.split(" ")[1];
		int startHour = Integer.parseInt(start.split(":")[0]);
		int startMin = Integer.parseInt(start.split(":")[1]);
		int startSecond = Integer.parseInt(start.split(":")[2]);
		int endHour = Integer.parseInt(end.split(":")[0]);
		int endMin = Integer.parseInt(end.split(":")[1]);
		int endSecond = Integer.parseInt(end.split(":")[2]);

		if(startHour < endHour){
			Calendar cal1 = Calendar.getInstance();
			cal1.set(Calendar.HOUR_OF_DAY,endHour);
			cal1.set(Calendar.MINUTE,endMin);
			cal1.set(Calendar.SECOND,endSecond);
			cal1.add(Calendar.HOUR_OF_DAY,-startHour);
			cal1.add(Calendar.MINUTE,-startMin);
			cal1.add(Calendar.SECOND,-startSecond);
			System.out.println(reSize(cal1.get(Calendar.HOUR_OF_DAY))+":"+reSize(cal1.get(Calendar.MINUTE))+":"+reSize(cal1.get(Calendar.SECOND)));
		}
		else{
			if((startHour == endHour) && (startMin <= endMin) ){
				Calendar cal1 = Calendar.getInstance();
				cal1.set(Calendar.HOUR_OF_DAY,endHour);
				cal1.set(Calendar.MINUTE,endMin);
				cal1.set(Calendar.SECOND,endSecond);
				cal1.add(Calendar.HOUR_OF_DAY,-startHour);
				cal1.add(Calendar.MINUTE,-startMin);
				cal1.add(Calendar.SECOND,-startSecond);
				System.out.println(reSize(cal1.get(Calendar.HOUR_OF_DAY))+":"+reSize(cal1.get(Calendar.MINUTE))+":"+reSize(cal1.get(Calendar.SECOND)));	
			}else{
				Calendar cal1 = Calendar.getInstance();
				cal1.set(Calendar.HOUR_OF_DAY,startHour);
				cal1.set(Calendar.MINUTE,startMin);
				cal1.set(Calendar.SECOND,startSecond);
				cal1.add(Calendar.HOUR_OF_DAY,-endHour);
				cal1.add(Calendar.MINUTE,-endMin);
				cal1.add(Calendar.SECOND,-endSecond);
				System.out.println(reSize(cal1.get(Calendar.HOUR_OF_DAY))+":"+reSize(cal1.get(Calendar.MINUTE))+":"+reSize(cal1.get(Calendar.SECOND)));
			}
		}
	}
	public static String reSize(int data){
		return ((String.valueOf(data).length()) == 1) ? ("0" + String.valueOf(data)) : String.valueOf(data);
	}

}
