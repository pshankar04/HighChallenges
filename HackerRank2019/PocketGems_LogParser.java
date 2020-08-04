package HackerRank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class PocketGems_LogParser {

	public static int count = 0;
	public static long timeInMillis = 0;
	public static long totalTimeInMillis = 0;
	public static Calendar startTime = null;
	public static Calendar endTime = null;
	public static LinkedList<Calendar> timeList = new LinkedList<Calendar>();

	public static void main(String[] args) {
		double activeMins = 0.0d , totalMins = 0.0d;
		double timePercent = 0.0d;
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.length() > 0)) {
				measureActiveTime(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		totalTimeInMillis =  measureTotalTime();
		 
		activeMins = TimeUnit.MILLISECONDS.toMinutes(timeInMillis);
		totalMins = TimeUnit.MILLISECONDS.toMinutes(totalTimeInMillis);
		timePercent = ((activeMins/totalMins) * 100);
		System.out.println(activeMins+"/"+totalMins);
		System.out.println(String.format("%.2f",timePercent)); 
	}

	public static void measureActiveTime(String timeString){

		
		String message  = timeString.substring(timeString.indexOf("::")+2); 
		timeString = timeString.substring(0,timeString.indexOf("::"));
		String year = timeString.substring(timeString.lastIndexOf('/')+1,timeString.indexOf('-'));
		String month = timeString.substring(timeString.indexOf('(')+1,timeString.indexOf('/'));
		String day = timeString.substring(timeString.indexOf('/')+1,timeString.lastIndexOf('/'));
		String hour = timeString.substring(timeString.indexOf('-')+1,timeString.indexOf(':'));
		String minutes = timeString.substring(timeString.indexOf(':')+1,timeString.lastIndexOf(':'));
		String second = timeString.substring(timeString.lastIndexOf(':')+1,timeString.indexOf(')'));


		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, Integer.parseInt(year));
		cal.add(Calendar.MONTH, Integer.parseInt(month)-1);
		cal.add(Calendar.DATE, Integer.parseInt(day));
		cal.add(Calendar.HOUR_OF_DAY, Integer.parseInt(hour));
		cal.add(Calendar.MINUTE, Integer.parseInt(minutes));
		cal.add(Calendar.SECOND, Integer.parseInt(second));



		if(message.equals("START")){
			startTime = cal;
		}
		else if(message.equals("CONNECTED")){
			timeList.add(cal);
			count++;
		}else if(message.equals("DISCONNECTED")){
			timeList.add(cal);
			count++;
		}else if(message.equals("SHUTDOWN")){
			timeList.add(cal);
			count++;
			endTime = cal;
		}

		if(count == 2){
			timeInMillis = timeInMillis + measureActiveTime(timeList);
			count = 0;
			timeList.removeAll(timeList);
		}
		cal = null;
	}

	public static long measureActiveTime(LinkedList<Calendar> times){
	
		return (times.getLast().getTimeInMillis() - times.getFirst().getTimeInMillis());
	}

	public static long measureTotalTime(){

		return (endTime.getTimeInMillis() - startTime.getTimeInMillis());
	}
}
